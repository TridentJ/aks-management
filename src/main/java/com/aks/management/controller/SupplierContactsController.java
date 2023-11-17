/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/6/20
 * Time: 20:27
 **/
package com.aks.management.controller;

import com.aks.management.bean.SupplierContacts;
import com.aks.management.service.SupplierContactsService;
import com.aks.management.service.SupplierService;
import com.aks.management.utils.AjaxResponse;
import com.aks.management.utils.AjaxResponseList;
import com.aks.management.utils.invoiceBase.InvoiceBaseShow;
import com.aks.management.utils.invoiceBase.InvoiceSearch;
import com.aks.management.utils.invoiceBase.InvoiceSearchResult;
import com.aks.management.utils.supplier.SupplierContactsSearch;
import com.aks.management.utils.supplier.SupplierContactsSearchResult;
import com.aks.management.utils.supplier.SupplierContactsShow;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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
@Tag(name="供应商联系人接口",description = "操作供应商联系人的接口清单")
@RequestMapping(value = "/api/supplierContacts")
public class SupplierContactsController {
    
    @Resource
    private SupplierContactsService supplierContactsService;
    
    @Resource
    private SupplierService supplierService;
    
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Operation(
            summary = "查询供应商联系人信息",
            description = "查询单个供应商所有联系人信息",
            parameters = {
                    @Parameter(name="supplierId", description = "供应商ID", required = true),
            }
    )
    @RequestMapping("/show")
    public AjaxResponse getSupplierContactsBySupplierId(Long supplierId){
        //System.out.println("/api/supplierContacts/show: supplierId = " + supplierId);
        AjaxResponse ajaxResponse = new AjaxResponse();
        if(supplierId == null || supplierId < 0L){
            ajaxResponse.setCode(1190);
            ajaxResponse.setMessage("供应商ID不合法");
            return ajaxResponse;
        }
        //List<SupplierContactsShow> supplierContactsShowList = new ArrayList<>();
        
            
        List<SupplierContacts> supplierContactsList = supplierContactsService.getSupplierContactsBySupplierId(supplierId);
        if(supplierContactsList == null || supplierContactsList.isEmpty()){
            ajaxResponse.setCode(1191);
            ajaxResponse.setMessage("供应商无联系人信息");
            return ajaxResponse;
        }
        /*
        for(SupplierContacts supplierContacts : supplierContactsList){
            SupplierContactsShow supplierContactsShow;
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                supplierContactsShow = objectMapper.readValue(objectMapper.writeValueAsString(supplierContacts), SupplierContactsShow.class);
            }catch (Exception e){
                ajaxResponse.setCode(1031);
                ajaxResponse.setMessage("类型转换错误");
                return ajaxResponse;
            }
            try {
                supplierContactsShow.setCreateTimeStr(sdf.format(supplierContactsShow.getCreateTime()));
            }catch (Exception e){
                supplierContactsShow.setCreateTimeStr("-");
            }
            try {
                supplierContactsShow.setUpdateTimeStr(sdf.format(supplierContactsShow.getUpdateTime()));
            }catch (Exception e){
                supplierContactsShow.setUpdateTimeStr("-");
            }
            supplierContactsShowList.add(supplierContactsShow);
        }
        */
        ajaxResponse.setCode(0);
        ajaxResponse.setMessage("成功");
        //ajaxResponse.setData(supplierContactsShowList);
        ajaxResponse.setData(supplierContactsList);
        
        return ajaxResponse;
    }
    
    @Operation(
            summary = "添加供应商多个联系人",
            description = "添加供应商多个联系人信息（一次可给一个供应商添加多个联系人）",
            parameters = {
                    @Parameter(name="supplierContactsShowList", description = "供应商联系人信息", required = true),
            }
    )
    @PostMapping(value = "/add")
    public AjaxResponse addSupplierContacts(@RequestBody List<SupplierContacts> supplierContactsList){
        AjaxResponse ajaxResponse = new AjaxResponse();
        if(supplierContactsList == null || supplierContactsList.isEmpty()){
            ajaxResponse.setCode(1192);
            ajaxResponse.setMessage("供应商联系人不合法");
            return ajaxResponse;
        }
        int totalNum = supplierContactsList.size();
        int successNum = 0;
        int failureNum = 0;
        int result = 0;
        for( SupplierContacts supplierContacts : supplierContactsList){
            //SupplierContacts supplierContacts = supplierContactsShow;
            supplierContacts.setCreateTime(null);
            supplierContacts.setUpdateTime(null);
            supplierContacts.setId(YitIdHelper.nextId());
            result = supplierContactsService.addSupplierContacts(supplierContacts);
            if(result == 1){
                successNum++;
            }else{
                failureNum++;
            }
        }
        if( successNum == totalNum){
            ajaxResponse.setCode(0);
            ajaxResponse.setMessage("成功");
            //ajaxResponse.setData("添加供应商联系人信息成功");
        }else{
            ajaxResponse.setCode(1193);
            ajaxResponse.setMessage("添加联系人信息出现失败！联系人信息共：" + totalNum + "条，成功：" + successNum + "条，失败：" + failureNum + "条。");
            //ajaxResponse.setData("添加供应商联系人信息存在失败！联系人信息共：" + totalNum + "条，成功：" + successNum + "条，失败：" + failureNum + "条。");
        }
        return ajaxResponse;
    }
    
    @Operation(
            summary = "添加一个供应商联系人",
            description = "添加一个供应商联系人信息（一次只给一个供应商添加一个联系人）",
            parameters = {
                    @Parameter(name="supplierContacts", description = "供应商联系人信息", required = true),
            }
    )
    @PostMapping(value = "/addOne")
    public AjaxResponse addOneSupplierContacts(@RequestBody SupplierContacts supplierContacts){
        AjaxResponse ajaxResponse = new AjaxResponse();
        if(supplierContacts == null || supplierContacts.getSupplierId() == null || supplierContacts.getSupplierId() < 0L){
            ajaxResponse.setCode(1192);
            ajaxResponse.setMessage("供应商联系人不合法");
            return ajaxResponse;
        }
        int result = supplierService.checkSupplierIsExists(supplierContacts.getSupplierId());
        if(result == 0){
            ajaxResponse.setCode(1194);
            ajaxResponse.setMessage("联系人关联的供应商不存在");
            return ajaxResponse;
        }
        supplierContacts.setCreateTime(null);
        supplierContacts.setUpdateTime(null);
        supplierContacts.setId(YitIdHelper.nextId());
        result = supplierContactsService.addSupplierContacts(supplierContacts);
        if(result == 0){
            ajaxResponse.setCode(1193);
            ajaxResponse.setMessage("添加供应商联系人失败");
        }else{
            ajaxResponse.setCode(0);
            ajaxResponse.setMessage("成功");
            ajaxResponse.setData(supplierContacts.getId());
        }
        return ajaxResponse;
    }
    
    @Operation(
            summary = "更新供应商单个联系人",
            description = "更新供应商单个联系人信息",
            parameters = {
                    @Parameter(name="supplierContacts", description = "供应商联系人信息", required = true),
            }
    )
    @PostMapping(value = "/update")
    public AjaxResponse updateSupplierContactsById(@RequestBody SupplierContacts supplierContacts){
        AjaxResponse ajaxResponse = new AjaxResponse();
        if(supplierContacts == null || supplierContacts.getId() == null || supplierContacts.getSupplierId() == null || supplierContacts.getId() < 0L || supplierContacts.getSupplierId() < 0L){
            ajaxResponse.setCode(1190);
            ajaxResponse.setMessage("供应商ID不合法");
            return ajaxResponse;
        }
        int result = supplierService.checkSupplierIsExists(supplierContacts.getSupplierId());
        if(result != 1){
            ajaxResponse.setCode(1194);
            ajaxResponse.setMessage("联系人关联的供应商不存在");
        }
        result = supplierContactsService.checkSupplierContactsIsExists(supplierContacts.getId());
        if(result != 1){
            ajaxResponse.setCode(1195);
            ajaxResponse.setMessage("需更新的供应商联系人不存在");
        }
        supplierContacts.setCreateTime(null);
        supplierContacts.setUpdateTime(null);
        
        result = supplierContactsService.updateSupplierContactsById(supplierContacts);
        if(result == 1){
            ajaxResponse.setCode(0);
            ajaxResponse.setMessage("成功");
        }else{
            ajaxResponse.setCode(1196);
            ajaxResponse.setMessage("更新供应商联系人失败");
        }
        return ajaxResponse;
    }
    
    @Operation(
            summary = "删除供应商单个联系人",
            description = "删除供应商单个联系人",
            parameters = {
                    @Parameter(name="id", description = "供应商联系人ID", required = true),
            }
    )
    @GetMapping(value = "/delete")
    public AjaxResponse deleteSupplierContactsById(Long id){
        AjaxResponse ajaxResponse = new AjaxResponse();
        int result = supplierContactsService.changeSupplierContactsStateById(id,0);
        if(result == 1){
            ajaxResponse.setCode(0);
            ajaxResponse.setMessage("成功");
        }else{
            ajaxResponse.setCode(1197);
            ajaxResponse.setMessage("删除供应商联系人失败");
        }
        return ajaxResponse;
    }
    
    @Operation(
            summary = "搜索供应商联系人信息",
            description = "搜索供应商联系人信息，按联系人自身信息搜索，不支持限定供应商搜索",
            parameters = {
                    @Parameter(name="supplierContactsSearch", description = "联系人搜索信息", required = true),
            }
    )
    @PostMapping(value="/search")
    public AjaxResponseList searchSupplierContacts(@RequestBody SupplierContactsSearch supplierContactsSearch){
        AjaxResponseList ajaxResponseList = new AjaxResponseList();
        if(supplierContactsSearch == null){
            ajaxResponseList.setCode(1198);
            ajaxResponseList.setMessage("供应商联系人搜索信息不合法");
            return ajaxResponseList;
        }
        if(supplierContactsSearch.getPageNum() == null || supplierContactsSearch.getPageNum() < 0){
            ajaxResponseList.setCode(1030);
            ajaxResponseList.setMessage("页数或页码错误");
            return ajaxResponseList;
        }
        if(supplierContactsSearch.getPageSize() == null || supplierContactsSearch.getPageSize() < 1 || supplierContactsSearch.getPageSize() > 100){
            ajaxResponseList.setCode(1030);
            ajaxResponseList.setMessage("页数或页码错误");
            return ajaxResponseList;
        }
        
        SupplierContactsSearchResult supplierContactsSearchResult = supplierContactsService.searchSupplierContacts(supplierContactsSearch);
        if(supplierContactsSearchResult == null || supplierContactsSearchResult.getTotal() == 0 || supplierContactsSearchResult.getSupplierContactsList().isEmpty()){
            ajaxResponseList.setCode(1032);
            ajaxResponseList.setMessage("未搜索到符合条件的内容！");
            return  ajaxResponseList;
        }
        List<SupplierContactsShow> supplierContactsShowList = null;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            supplierContactsShowList = objectMapper.readValue(objectMapper.writeValueAsString(supplierContactsSearchResult.getSupplierContactsList()), new TypeReference<List<SupplierContactsShow>>() {});
        }catch (Exception e){
            ajaxResponseList.setCode(1031);
            ajaxResponseList.setMessage("类型转换错误");
            return ajaxResponseList;
        }
        supplierContactsShowList.forEach(  supplierContactsShow -> {
            /*
            try {
                String createTime = sdf.format( supplierContactsShow.getCreateTime());
                 supplierContactsShow.setCreateTimeStr(createTime);
            }catch (Exception e){
                 supplierContactsShow.setCreateTimeStr("-");
            }
            try {
                String updateTime = sdf.format( supplierContactsShow.getUpdateTime());
                 supplierContactsShow.setUpdateTimeStr(updateTime);
            }catch (Exception e){
                 supplierContactsShow.setUpdateTimeStr("-");
            }
            */
            try {
                String supplierName = supplierService.getSupplierById( supplierContactsShow.getSupplierId()).getSupplierName();
                 supplierContactsShow.setSupplierName(supplierName);
            }catch (Exception e){
                 supplierContactsShow.setSupplierName("-");
            }
        });
        ajaxResponseList.setCode(0);
        ajaxResponseList.setMessage("成功");
        ajaxResponseList.setData( supplierContactsShowList);
        ajaxResponseList.setPageNum(supplierContactsSearchResult.getPageNum());
        ajaxResponseList.setPageSize(supplierContactsSearchResult.getPageSize());
        ajaxResponseList.setTotal(supplierContactsSearchResult.getTotal());
        
        return ajaxResponseList;
    }
    
}
