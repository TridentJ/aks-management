/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/6/20
 * Time: 20:27
 **/
package com.aks.management.controller;

import com.aks.management.bean.CustomerContacts;
import com.aks.management.service.CustomerContactsService;
import com.aks.management.service.CustomerService;
import com.aks.management.utils.AjaxResponse;
import com.aks.management.utils.AjaxResponseList;
import com.aks.management.utils.customer.CustomerContactsSearch;
import com.aks.management.utils.customer.CustomerContactsSearchResult;
import com.aks.management.utils.customer.CustomerContactsShow;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.yitter.idgen.YitIdHelper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@Tag(name="客户联系人接口",description = "操作客户联系人的接口清单")
@RequestMapping(value = "/api/customerContacts")
public class CustomerContactsController {
    
    @Resource
    private CustomerContactsService customerContactsService;
    
    @Resource
    private CustomerService customerService;
    
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Operation(
            summary = "查询客户联系人信息",
            description = "查询单个客户所有联系人信息",
            parameters = {
                    @Parameter(name="customerId", description = "客户ID", required = true),
            }
    )
    @RequestMapping("/show")
    public AjaxResponse getCustomerContactsByCustomerId(Long customerId){
        //System.out.println("/api/customerContacts/show: customerId = " + customerId);
        AjaxResponse ajaxResponse = new AjaxResponse();
        if(customerId == null || customerId < 0L){
            ajaxResponse.setCode(1280);
            ajaxResponse.setMessage("客户ID不合法");
            return ajaxResponse;
        }
        List<CustomerContactsShow> customerContactsShowList = new ArrayList<>();
        
            
        List<CustomerContacts> customerContactsList = customerContactsService.getCustomerContactsByCustomerId(customerId);
        if(customerContactsList == null || customerContactsList.isEmpty()){
            ajaxResponse.setCode(1281);
            ajaxResponse.setMessage("客户无联系人信息");
            return ajaxResponse;
        }
        /*
        for(CustomerContacts customerContacts : customerContactsList){
            CustomerContactsShow customerContactsShow;
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                customerContactsShow = objectMapper.readValue(objectMapper.writeValueAsString(customerContacts), CustomerContactsShow.class);
            }catch (Exception e){
                ajaxResponse.setCode(1031);
                ajaxResponse.setMessage("类型转换错误");
                return ajaxResponse;
            }
            try {
                customerContactsShow.setCreateTimeStr(sdf.format(customerContactsShow.getCreateTime()));
            }catch (Exception e){
                customerContactsShow.setCreateTimeStr("-");
            }
            try {
                customerContactsShow.setUpdateTimeStr(sdf.format(customerContactsShow.getUpdateTime()));
            }catch (Exception e){
                customerContactsShow.setUpdateTimeStr("-");
            }
            customerContactsShowList.add(customerContactsShow);
        }
        */
        
        ajaxResponse.setCode(0);
        ajaxResponse.setMessage("成功");
        //ajaxResponse.setData(customerContactsShowList);
        ajaxResponse.setData(customerContactsList);
        return ajaxResponse;
    }
    
    @Operation(
            summary = "添加客户多个联系人",
            description = "添加客户多个联系人信息（一次可给一个客户添加多个联系人）",
            parameters = {
                    @Parameter(name="customerContactsShowList", description = "客户联系人信息", required = true),
            }
    )
    @PostMapping(value = "/add")
    public AjaxResponse addCustomerContacts(@RequestBody List<CustomerContacts> customerContactsList){
        AjaxResponse ajaxResponse = new AjaxResponse();
        if(customerContactsList == null || customerContactsList.isEmpty()){
            ajaxResponse.setCode(1282);
            ajaxResponse.setMessage("客户联系人不合法");
            return ajaxResponse;
        }
        int totalNum = customerContactsList.size();
        int successNum = 0;
        int failureNum = 0;
        int result = 0;
        for( CustomerContacts customerContacts : customerContactsList){
            //CustomerContacts customerContacts = customerContactsShow;
            customerContacts.setCreateTime(null);
            customerContacts.setUpdateTime(null);
            customerContacts.setId(YitIdHelper.nextId());
            result = customerContactsService.addCustomerContacts(customerContacts);
            if(result == 1){
                successNum++;
            }else{
                failureNum++;
            }
        }
        if( successNum == totalNum){
            ajaxResponse.setCode(0);
            ajaxResponse.setMessage("成功");
            //ajaxResponse.setData("添加客户联系人信息成功");
        }else{
            ajaxResponse.setCode(1283);
            ajaxResponse.setMessage("添加联系人信息出现失败！联系人信息共：" + totalNum + "条，成功：" + successNum + "条，失败：" + failureNum + "条。");
            //ajaxResponse.setData("添加客户联系人信息存在失败！联系人信息共：" + totalNum + "条，成功：" + successNum + "条，失败：" + failureNum + "条。");
        }
        return ajaxResponse;
    }
    
    @Operation(
            summary = "添加一个客户联系人",
            description = "添加一个客户联系人信息（一次只给一个客户添加一个联系人）",
            parameters = {
                    @Parameter(name="customerContacts", description = "客户联系人信息", required = true),
            }
    )
    @PostMapping(value = "/addOne")
    public AjaxResponse addOneCustomerContacts(@RequestBody CustomerContacts customerContacts){
        AjaxResponse ajaxResponse = new AjaxResponse();
        if(customerContacts == null || customerContacts.getCustomerId() == null || customerContacts.getCustomerId() < 0L){
            ajaxResponse.setCode(1282);
            ajaxResponse.setMessage("客户联系人不合法");
            return ajaxResponse;
        }
        int result = customerService.checkCustomerIsExists(customerContacts.getCustomerId());
        if(result == 0){
            ajaxResponse.setCode(1284);
            ajaxResponse.setMessage("联系人关联的客户不存在");
            return ajaxResponse;
        }
        customerContacts.setCreateTime(null);
        customerContacts.setUpdateTime(null);
        customerContacts.setId(YitIdHelper.nextId());
        result = customerContactsService.addCustomerContacts(customerContacts);
        if(result == 0){
            ajaxResponse.setCode(1283);
            ajaxResponse.setMessage("添加客户联系人失败");
        }else{
            ajaxResponse.setCode(0);
            ajaxResponse.setMessage("成功");
            ajaxResponse.setData(customerContacts.getId());
        }
        return ajaxResponse;
    }
    
    @Operation(
            summary = "更新客户单个联系人",
            description = "更新客户单个联系人信息",
            parameters = {
                    @Parameter(name="customerContacts", description = "客户联系人信息", required = true),
            }
    )
    @PostMapping(value = "/update")
    public AjaxResponse updateCustomerContactsById(@RequestBody CustomerContacts customerContacts){
        AjaxResponse ajaxResponse = new AjaxResponse();
        if(customerContacts == null || customerContacts.getId() == null || customerContacts.getCustomerId() == null || customerContacts.getId() < 0L || customerContacts.getCustomerId() < 0L){
            ajaxResponse.setCode(1280);
            ajaxResponse.setMessage("客户ID不合法");
            return ajaxResponse;
        }
        int result = customerService.checkCustomerIsExists(customerContacts.getCustomerId());
        if(result != 1){
            ajaxResponse.setCode(1284);
            ajaxResponse.setMessage("联系人关联的客户不存在");
        }
        result = customerContactsService.checkCustomerContactsIsExists(customerContacts.getId());
        if(result != 1){
            ajaxResponse.setCode(1285);
            ajaxResponse.setMessage("需更新的客户联系人不存在");
        }
        customerContacts.setCreateTime(null);
        customerContacts.setUpdateTime(null);
        
        result = customerContactsService.updateCustomerContactsById(customerContacts);
        if(result == 1){
            ajaxResponse.setCode(0);
            ajaxResponse.setMessage("成功");
        }else{
            ajaxResponse.setCode(1286);
            ajaxResponse.setMessage("更新客户联系人失败");
        }
        return ajaxResponse;
    }
    
    @Operation(
            summary = "删除客户单个联系人",
            description = "删除客户单个联系人",
            parameters = {
                    @Parameter(name="id", description = "客户联系人ID", required = true),
            }
    )
    @PostMapping(value = "/delete")
    public AjaxResponse deleteCustomerContactsById(@RequestBody Long id){
        AjaxResponse ajaxResponse = new AjaxResponse();
        int result = customerContactsService.changeCustomerContactsStateById(id,0);
        if(result == 1){
            ajaxResponse.setCode(0);
            ajaxResponse.setMessage("成功");
        }else{
            ajaxResponse.setCode(1287);
            ajaxResponse.setMessage("删除客户联系人失败");
        }
        return ajaxResponse;
    }
    
    @Operation(
            summary = "搜索客户联系人信息",
            description = "搜索客户联系人信息，按联系人自身信息搜索，不支持限定客户搜索",
            parameters = {
                    @Parameter(name="customerContactsSearch", description = "联系人搜索信息", required = true),
            }
    )
    @PostMapping(value="/search")
    public AjaxResponseList searchCustomerContacts(@RequestBody CustomerContactsSearch customerContactsSearch){
        AjaxResponseList ajaxResponseList = new AjaxResponseList();
        if(customerContactsSearch == null){
            ajaxResponseList.setCode(1288);
            ajaxResponseList.setMessage("客户联系人搜索信息不合法");
            return ajaxResponseList;
        }
        if(customerContactsSearch.getPageNum() == null || customerContactsSearch.getPageNum() < 0){
            ajaxResponseList.setCode(1030);
            ajaxResponseList.setMessage("页数或页码错误");
            return ajaxResponseList;
        }
        if(customerContactsSearch.getPageSize() == null || customerContactsSearch.getPageSize() < 1 || customerContactsSearch.getPageSize() > 100){
            ajaxResponseList.setCode(1030);
            ajaxResponseList.setMessage("页数或页码错误");
            return ajaxResponseList;
        }
        
        CustomerContactsSearchResult customerContactsSearchResult = customerContactsService.searchCustomerContacts(customerContactsSearch);
        if(customerContactsSearchResult == null || customerContactsSearchResult.getTotal() == 0 || customerContactsSearchResult.getCustomerContactsList().isEmpty()){
            ajaxResponseList.setCode(1032);
            ajaxResponseList.setMessage("未搜索到符合条件的内容！");
            return  ajaxResponseList;
        }
        List<CustomerContactsShow> customerContactsShowList = null;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            customerContactsShowList = objectMapper.readValue(objectMapper.writeValueAsString(customerContactsSearchResult.getCustomerContactsList()), new TypeReference<List<CustomerContactsShow>>() {});
        }catch (Exception e){
            ajaxResponseList.setCode(1031);
            ajaxResponseList.setMessage("类型转换错误");
            return ajaxResponseList;
        }
        customerContactsShowList.forEach(  customerContactsShow -> {
            /*
            try {
                String createTime = sdf.format( customerContactsShow.getCreateTime());
                 customerContactsShow.setCreateTimeStr(createTime);
            }catch (Exception e){
                 customerContactsShow.setCreateTimeStr("-");
            }
            try {
                String updateTime = sdf.format( customerContactsShow.getUpdateTime());
                 customerContactsShow.setUpdateTimeStr(updateTime);
            }catch (Exception e){
                 customerContactsShow.setUpdateTimeStr("-");
            }
            */
            try {
                String customerName = customerService.getCustomerById( customerContactsShow.getCustomerId()).getCustomerName();
                 customerContactsShow.setCustomerName(customerName);
            }catch (Exception e){
                 customerContactsShow.setCustomerName("-");
            }
        });
        ajaxResponseList.setCode(0);
        ajaxResponseList.setMessage("成功");
        ajaxResponseList.setData( customerContactsShowList);
        ajaxResponseList.setPageNum(customerContactsSearchResult.getPageNum());
        ajaxResponseList.setPageSize(customerContactsSearchResult.getPageSize());
        ajaxResponseList.setTotal(customerContactsSearchResult.getTotal());
        
        return ajaxResponseList;
    }
    
}
