/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/9/6
 * Time: 9:10
 **/
package com.aks.management.controller;

import com.aks.management.bean.Customer;
import com.aks.management.service.CustomerService;
import com.aks.management.utils.AjaxResponse;
import com.aks.management.utils.AjaxResponseList;
import com.aks.management.utils.customer.CustomerSampleInfo;
import com.aks.management.utils.customer.CustomerSearch;
import com.aks.management.utils.customer.CustomerSearchResult;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.yitter.idgen.YitIdHelper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@Tag(name="客户接口",description = "操作客户的接口清单")
@RequestMapping(value="/api/customer")
public class CustomerController {
    
    @Resource
    private CustomerService customerService;
    
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Operation(
            summary = "客户基础信息清单",
            description = "基础客户信息，用于列表展示",
            parameters = {
                    @Parameter(name="pageNum", description = "页码",required = true),
                    @Parameter(name="pageSize", description = "页数",required = true)
            }
    )
    @GetMapping(value = "/list")
    public AjaxResponseList listCustomer(Integer pageNum, Integer pageSize){
        AjaxResponseList ajaxResponse = new AjaxResponseList();
        //Integer pageNum = sampleListRequest.getPageNum();
        //Integer pageSize = sampleListRequest.getPageSize();
        if(pageNum == null || pageNum < 0 || pageSize == null || pageSize < 0){
            ajaxResponse.setCode(1030);
            ajaxResponse.setMessage("页数或页码错误");
            return ajaxResponse;
        }
        List<Customer> customerList = customerService.getCustomerByState(100,pageNum,pageSize);
        if(customerList == null || customerList.isEmpty()){
            ajaxResponse.setCode(1150);
            ajaxResponse.setMessage("客户查询结果为空");
            return ajaxResponse;
        }
        
        List<CustomerSampleInfo> customerSampleInfoList = new ArrayList<>();
        customerList.forEach( customer -> {
            CustomerSampleInfo customerSampleInfo = new CustomerSampleInfo();
            customerSampleInfo.setId(customer.getId());
            customerSampleInfo.setCustomerName(customer.getCustomerName());
            customerSampleInfo.setCustomerNumber(customer.getCustomerNumber());
            customerSampleInfo.setOrderQuantity(10);
            customerSampleInfo.setAddress(customer.getAddress());
            customerSampleInfo.setState(customer.getState());
            customerSampleInfo.setTelephone(customer.getTelephone());
            //customerSampleInfo.setOderQuantity(0);
            try {
                String time = sdf.format(customer.getCreateTime());
                customerSampleInfo.setCreateTime(time);
            }catch (Exception e){
                customerSampleInfo.setCreateTime("-");
            }
            customerSampleInfoList.add(customerSampleInfo);
            
        });
        int totalNum = customerService.getAllCountByState(2);
        if(totalNum > 0){
            ajaxResponse.setTotal(totalNum);
        }else{
            ajaxResponse.setTotal(0);
        }
        ajaxResponse.setPageSize(pageSize);
        ajaxResponse.setPageNum(pageNum);
        ajaxResponse.setCode(0);
        ajaxResponse.setMessage("成功");
        ajaxResponse.setData(customerSampleInfoList);
        return ajaxResponse;
    }
    
    
    @Operation(
            summary = "查询单个客户基础信息",
            description = "单个客户的基础信息",
            parameters = {
                    @Parameter(name="id", description = "客户ID", required = true),
            }
    )
    @GetMapping(value = "/show")
    public AjaxResponse showCustomer(Long id){
        //System.out.println("/api/customer/show: id = " + id);
        AjaxResponse ajaxResponse = new AjaxResponse();
        if(id == null || id < 0){
            ajaxResponse.setCode(1151);
            ajaxResponse.setMessage("客户ID不合法");
            return ajaxResponse;
        }
        
        
        Customer customer = customerService.getCustomerById(id);
        if(customer == null){
            ajaxResponse.setCode(1152);
            ajaxResponse.setMessage("查询的客户不存在");
            return ajaxResponse;
        }
        //CustomerShow customerShow = (CustomerShow) customer;
        //CustomerShow customerShow = null;
        /*ObjectMapper objectMapper = new ObjectMapper();
        try {
            customerShow = objectMapper.readValue(objectMapper.writeValueAsString(customer), CustomerShow.class);
        }catch (Exception e){
            ajaxResponse.setCode(1031);
            ajaxResponse.setMessage("类型转换错误");
            return ajaxResponse;
        }*/
        /*try {
            String time = sdf.format(customer.getCreateTime());
            customerShow.setCreateTimeStr(time);
        }catch (Exception e){
            customerShow.setCreateTimeStr("-");
        }
        try {
            String time = sdf.format(customer.getUpdateTime());
            customerShow.setUpdateTimeStr(time);
        }catch (Exception e){
            customerShow.setUpdateTimeStr("-");
        }*/
        //customerShow.setComments(customerShow.getComments());
        
        ajaxResponse.setCode(0);
        ajaxResponse.setMessage("成功");
        //ajaxResponse.setData(customerShow);
        ajaxResponse.setData(customer);
        
        
        return ajaxResponse;
    }
    
    @Operation(
            summary = "添加客户基础信息",
            description = "添加客户的基础信息",
            parameters = {
                    @Parameter(name="customerShow", description = "客户信息", required = true),
            }
    )
    @PostMapping(value = "/add")
    public AjaxResponse addCustomer(@RequestBody Customer customer){
        AjaxResponse ajaxResponse = new AjaxResponse();
        if(customer == null){
            ajaxResponse.setCode(1154);
            ajaxResponse.setMessage("客户信息不合法");
            return ajaxResponse;
        }
        //Customer customer = customerShow;
        customer.setCreateTime(null);
        customer.setUpdateTime(null);
        customer.setId(YitIdHelper.nextId());
        int result = customerService.addCustomer(customer);
        if(result == 1){
            //成功
            ajaxResponse.setCode(0);
            ajaxResponse.setMessage("成功");
            ajaxResponse.setData(customer.getId());
        }else{
            ajaxResponse.setCode(1155);
            ajaxResponse.setMessage("添加客户信息失败");
        }
        return ajaxResponse;
    }
    
    @Operation(
            summary = "更新客户基础信息",
            description = "更新客户的基础信息",
            parameters = {
                    @Parameter(name="customer", description = "客户信息", required = true),
            }
    )
    @PostMapping(value = "/update")
    public AjaxResponse updateCustomer(@RequestBody Customer customer){
        AjaxResponse ajaxResponse = new AjaxResponse();
        if(customer == null || customer.getId() == null || customer.getId() < 0L){
            ajaxResponse.setCode(1154);
            ajaxResponse.setMessage("客户信息不合法");
            return ajaxResponse;
        }
        Customer customer1 = customerService.getCustomerById(customer.getId());
        if(customer1 == null){
            ajaxResponse.setCode(1151);
            ajaxResponse.setMessage("客户ID不合法");
            return ajaxResponse;
        }
        customer.setCreateTime(null);
        customer.setUpdateTime(null);
        int result = customerService.updateCustomerById(customer);
        if(result == 1){
            ajaxResponse.setCode(0);
            ajaxResponse.setMessage("成功");
        }else{
            ajaxResponse.setCode(1156);
            ajaxResponse.setMessage("更新客户信息失败");
        }
        return ajaxResponse;
    }
    
    @Operation(
            summary = "搜索客户基础信息",
            description = "搜索客户的基础信息",
            parameters = {
                    @Parameter(name="customerSearch", description = "客户信息", required = true),
            }
    )
    @PostMapping(value = "/search")
    public AjaxResponseList searchCustomer(@RequestBody CustomerSearch customerSearch){
        
        AjaxResponseList ajaxResponse = new AjaxResponseList();
        if(customerSearch == null){
            ajaxResponse.setCode(1157);
            ajaxResponse.setMessage("客户搜索信息不合法");
            return ajaxResponse;
        }
        if(customerSearch.getPageNum() == null || customerSearch.getPageNum() < 0){
            ajaxResponse.setCode(1030);
            ajaxResponse.setMessage("页数或页码错误");
            return ajaxResponse;
        }
        if(customerSearch.getPageSize() == null || customerSearch.getPageSize() < 1 || customerSearch.getPageSize() > 100){
            ajaxResponse.setCode(1030);
            ajaxResponse.setMessage("页数或页码错误");
            return ajaxResponse;
        }
        //List<CustomerShow> customerShowList = new ArrayList<>();
        //List<Customer> customerList = customerService.searchCustomer(customerSearch);
        CustomerSearchResult customerSearchResult = customerService.searchCustomer(customerSearch);
        if(customerSearchResult == null || customerSearchResult.getTotal() == 0 || customerSearchResult.getCustomerList().isEmpty()){
            ajaxResponse.setCode(1032);
            ajaxResponse.setMessage("未搜索到符合条件的内容！");
            return  ajaxResponse;
        }
        /*
        List<CustomerShow> customerShowList = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            customerShowList = objectMapper.readValue(objectMapper.writeValueAsString(customerSearchResult.getCustomerList()), new TypeReference<List<CustomerShow>>() {});
        }catch (Exception e){
            ajaxResponse.setCode(1031);
            ajaxResponse.setMessage("类型转换错误");
            return ajaxResponse;
        }
        customerShowList.forEach( customerShow -> {
            try {
                String createTime = sdf.format(customerShow.getCreateTime());
                customerShow.setCreateTimeStr(createTime);
            }catch (Exception e){
                customerShow.setCreateTimeStr("-");
            }
            try {
                String updateTime = sdf.format(customerShow.getUpdateTime());
                customerShow.setUpdateTimeStr(updateTime);
            }catch (Exception e){
                customerShow.setUpdateTimeStr("-");
            }
        });
        */
        ajaxResponse.setCode(0);
        ajaxResponse.setMessage("成功");
        ajaxResponse.setData(customerSearchResult.getCustomerList());
        ajaxResponse.setPageNum(customerSearchResult.getPageNum());
        ajaxResponse.setPageSize(customerSearchResult.getPageSize());
        ajaxResponse.setTotal(customerSearchResult.getTotal());
        return ajaxResponse;
    }
    
    @Operation(
            summary = "删除客户",
            description = "删除客户",
            parameters = {
                    @Parameter(name="id", description = "客户ID", required = true),
            }
    )
    @GetMapping(value = "/delete")
    public AjaxResponse frozeState(Long id){
        AjaxResponse ajaxResponse = new AjaxResponse();
        int result = customerService.changeCustomerStateById(id,0);
        if(result != 1){
            ajaxResponse.setCode(1158);
            ajaxResponse.setMessage("删除失败");
        }else{
            ajaxResponse.setCode(0);
            ajaxResponse.setMessage("成功");
        }
        return ajaxResponse;
    }

}
