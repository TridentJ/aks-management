/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/6/20
 * Time: 19:57
 **/
package com.aks.management.controller;

import com.aks.management.bean.InvoiceBase;
import com.aks.management.bean.SupplierContacts;
import com.aks.management.service.CustomerService;
import com.aks.management.service.InvoiceBaseService;
import com.aks.management.service.SupplierService;
import com.aks.management.utils.AjaxResponse;
import com.aks.management.utils.AjaxResponseList;
import com.aks.management.utils.invoiceBase.InvoiceBaseShow;
import com.aks.management.utils.invoiceBase.InvoiceSearch;
import com.aks.management.utils.invoiceBase.InvoiceSearchResult;
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
@Tag(name="发票信息接口",description = "操作发票的接口清单")
@RequestMapping(value = "/api/invoiceBase")
public class InvoiceBaseController {
    
    @Resource
    private InvoiceBaseService invoiceBaseService;
    
    @Resource
    private SupplierService supplierService;
    @Resource
    private CustomerService customerService;
    
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Operation(
            summary = "查询发票信息",
            description = "查询单个供应商或客户的发票信息",
            parameters = {
                    @Parameter(name="id", description = "供应商ID或客户ID"),
                    @Parameter(name="type", description = "查询类型，1：供应商，2：客户")
            }
    )
    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public AjaxResponse showInvoiceBase(Long id, Integer type){
        AjaxResponse ajaxResponse = new AjaxResponse();
        if(id == null || id < 0L){
            ajaxResponse.setCode(1160);
            ajaxResponse.setMessage("发票ID不合法");
            return ajaxResponse;
        }
        List<InvoiceBase> invoiceBaseList = null;
        //List<InvoiceBaseShow> invoiceBaseShowList = new ArrayList<>();
        if(type == 1){
            invoiceBaseList = invoiceBaseService.getInvoiceBaseBySupplierId(id);
            if(invoiceBaseList == null || invoiceBaseList.isEmpty()){
                ajaxResponse.setCode(1161);
                ajaxResponse.setMessage("供应商无发票信息");
                return ajaxResponse;
            }
        }else if( type == 2){
            invoiceBaseList = invoiceBaseService.getInvoiceBaseByCustomerId(id);
            if(invoiceBaseList == null || invoiceBaseList.isEmpty()){
                ajaxResponse.setCode(1169);
                ajaxResponse.setMessage("客户无发票信息");
                return ajaxResponse;
            }
        }else{
            ajaxResponse.setCode(1173);
            ajaxResponse.setMessage("操作类型错误");
            return ajaxResponse;
        }
        /*
        for (InvoiceBase invoiceBase : invoiceBaseList) {
            InvoiceBaseShow invoiceBaseShow = null;
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                invoiceBaseShow = objectMapper.readValue(objectMapper.writeValueAsString(invoiceBase), InvoiceBaseShow.class);
            } catch (Exception e) {
                ajaxResponse.setCode(1031);
                ajaxResponse.setMessage("类型转换错误");
                return ajaxResponse;
            }
            try {
                invoiceBaseShow.setCreateTimeStr(sdf.format(invoiceBaseShow.getCreateTime()));
            } catch (Exception e) {
                invoiceBaseShow.setCreateTimeStr("-");
            }
            try {
                invoiceBaseShow.setUpdateTimeStr(sdf.format(invoiceBaseShow.getUpdateTime()));
            } catch (Exception e) {
                invoiceBaseShow.setUpdateTimeStr("-");
            }
            invoiceBaseShowList.add(invoiceBaseShow);
        }
        */
        ajaxResponse.setCode(0);
        ajaxResponse.setMessage("成功");
        ajaxResponse.setData(invoiceBaseList);
        
        return ajaxResponse;
    }
    
    @Operation(
            summary = "添加多张发票信息",
            description = "添加单个供应商或客户的多个发票信息",
            parameters = {
                    @Parameter(name="invoiceBaseShowList", description = "供应商或客户发票信息"),
            }
    )
    @PostMapping(value = "/add")
    public AjaxResponse addInvoiceBase(@RequestBody List<InvoiceBase> invoiceBaseList){
        AjaxResponse ajaxResponse = new AjaxResponse();
        if(invoiceBaseList == null || invoiceBaseList.isEmpty()){
            ajaxResponse.setCode(1162);
            ajaxResponse.setMessage("发票信息不合法");
            return ajaxResponse;
        }
        
        int totalNum = invoiceBaseList.size();
        int successNum = 0;
        int failureNum = 0;
        int result = 0;
        for( InvoiceBase invoiceBase: invoiceBaseList){
            //InvoiceBase invoiceBase = invoiceBaseShow;
            invoiceBase.setCreateTime(null);
            invoiceBase.setUpdateTime(null);
            invoiceBase.setId(YitIdHelper.nextId());
            result = invoiceBaseService.addInvoiceBase(invoiceBase);
            if(result == 1){
                successNum++;
            }else{
                failureNum++;
            }
        }
        if( successNum == totalNum){
            ajaxResponse.setCode(0);
            ajaxResponse.setMessage("成功");
            //ajaxResponse.setData("添加发票信息成功");
        }else{
            ajaxResponse.setCode(1163);
            ajaxResponse.setMessage("添加发票信息出现失败！发票信息共：" + totalNum + "条，成功：" + successNum + "条，失败：" + failureNum + "条。");
            //ajaxResponse.setData("添加发票信息存在失败！发票信息共：" + totalNum + "条，成功：" + successNum + "条，失败：" + failureNum + "条。");
        }
        
        return ajaxResponse;
    }
    
    @Operation(
            summary = "添加单张发票信息",
            description = "添加单个供应商或客户的单张发票信息",
            parameters = {
                    @Parameter(name="invoiceBase", description = "供应商/客户发票信息"),
            }
    )
    @PostMapping(value = "/addOne")
    public AjaxResponse addOneInvoiceBase(@RequestBody InvoiceBase invoiceBase){
        AjaxResponse ajaxResponse = new AjaxResponse();
        if(invoiceBase == null){
            ajaxResponse.setCode(1162);
            ajaxResponse.setMessage("发票信息不合法");
            return ajaxResponse;
        }
        /*
        if( (invoiceBase.getSupplierId() == null || invoiceBase.getSupplierId() < 0L) && (invoiceBase.getCustomerId() == null || invoiceBase.getCustomerId() < 0L)){
            ajaxResponse.setCode(1162);
            ajaxResponse.setMessage("发票信息不合法");
            return ajaxResponse;
        }
        */
        if( invoiceBase.getSupplierId() != null && invoiceBase.getSupplierId() > 0L && invoiceBase.getCustomerId() != null && invoiceBase.getCustomerId() > 0L){
            ajaxResponse.setCode(1174);
            ajaxResponse.setMessage("一张发票不能同时关联给供应商和客户");
            return ajaxResponse;
        }
        int result;
        if( invoiceBase.getSupplierId() != null && invoiceBase.getSupplierId() > 0L){
            result = supplierService.checkSupplierIsExists(invoiceBase.getSupplierId());
            if(result == 0){
                ajaxResponse.setCode(1164);
                ajaxResponse.setMessage("发票关联的供应商不存在");
                return ajaxResponse;
            }
        }else if( invoiceBase.getCustomerId() != null && invoiceBase.getCustomerId() > 0L){
            result = customerService.checkCustomerIsExists(invoiceBase.getCustomerId());
            if(result == 0){
                ajaxResponse.setCode(1170);
                ajaxResponse.setMessage("发票关联的客户不存在");
                return ajaxResponse;
            }
        }else{
            ajaxResponse.setCode(1162);
            ajaxResponse.setMessage("发票信息不合法");
            return ajaxResponse;
        }
        invoiceBase.setCreateTime(null);
        invoiceBase.setUpdateTime(null);
        invoiceBase.setId(YitIdHelper.nextId());
        result = invoiceBaseService.addInvoiceBase(invoiceBase);
        if(result == 0){
            ajaxResponse.setCode(1163);
            ajaxResponse.setMessage("添加发票失败");
        }else{
            ajaxResponse.setCode(0);
            ajaxResponse.setMessage("成功");
            ajaxResponse.setData(invoiceBase.getId());
        }
        return ajaxResponse;
    }
    
    @Operation(
            summary = "更新单张发票信息",
            description = "更新单个供应商或客户的单张发票信息",
            parameters = {
                    @Parameter(name="invoiceBase", description = "供应商/客户发票信息"),
            }
    )
    @PostMapping(value = "/update")
    public AjaxResponse updateInvoiceBaseById(@RequestBody InvoiceBase invoiceBase){
        AjaxResponse ajaxResponse = new AjaxResponse();
        if(invoiceBase == null || invoiceBase.getId() == null || invoiceBase.getId() < 0L){
            ajaxResponse.setCode(1162);
            ajaxResponse.setMessage("发票信息不合法");
            return ajaxResponse;
        }
        if( invoiceBase.getSupplierId() != null && invoiceBase.getSupplierId() > 0L && invoiceBase.getCustomerId() != null && invoiceBase.getCustomerId() > 0L){
            ajaxResponse.setCode(1174);
            ajaxResponse.setMessage("一张发票不能同时关联给供应商和客户");
            return ajaxResponse;
        }
        int result = invoiceBaseService.checkInvoiceBaseIsExists(invoiceBase.getId());
        if(result != 1){
            ajaxResponse.setCode(1164);
            ajaxResponse.setMessage("发票不存在");
            return ajaxResponse;
        }
        if( invoiceBase.getSupplierId() != null && invoiceBase.getSupplierId() > 0L){
            result = supplierService.checkSupplierIsExists(invoiceBase.getSupplierId());
            if(result != 1){
                ajaxResponse.setCode(1165);
                ajaxResponse.setMessage("需更新发票的供应商不存在");
                return ajaxResponse;
            }
        }else if(invoiceBase.getCustomerId() != null && invoiceBase.getCustomerId() > 0L){
            result = customerService.checkCustomerIsExists(invoiceBase.getCustomerId());
            if(result != 1){
                ajaxResponse.setCode(1171);
                ajaxResponse.setMessage("需更新发票的客户不存在");
                return ajaxResponse;
            }
        }else{
            ajaxResponse.setCode(1162);
            ajaxResponse.setMessage("发票信息不合法");
            return ajaxResponse;
        }
        
        invoiceBase.setCreateTime(null);
        invoiceBase.setUpdateTime(null);
        
        result = invoiceBaseService.updateInvoiceBase(invoiceBase);
        if(result == 1){
            ajaxResponse.setCode(0);
            ajaxResponse.setMessage("成功");
        }else{
            ajaxResponse.setCode(1166);
            ajaxResponse.setMessage("更新发票失败");
        }
        return ajaxResponse;
    }
    
    @Operation(
            summary = "删除单张发票信息",
            description = "删除单个供应商或客户的单张发票信息",
            parameters = {
                    @Parameter(name="id", description = "发票ID"),
            }
    )
    @GetMapping(value = "/delete")
    public AjaxResponse deleteInvoiceBaseById(Long id){
        AjaxResponse ajaxResponse = new AjaxResponse();
        int result = invoiceBaseService.changeInvoiceBaseStateById(id,0);
        if(result == 1){
            ajaxResponse.setCode(0);
            ajaxResponse.setMessage("成功");
        }else{
            ajaxResponse.setCode(1167);
            ajaxResponse.setMessage("删除发票失败");
        }
        return ajaxResponse;
    }
    
    
    @Operation(
            summary = "搜索发票信息",
            description = "搜索供应商或客户的发票信息",
            parameters = {
                    @Parameter(name="invoiceSearch", description = "搜索发票信息"),
            }
    )
    @PostMapping(value="/search")
    public AjaxResponseList searchInvoiceBase(@RequestBody InvoiceSearch invoiceSearch){
        AjaxResponseList ajaxResponseList = new AjaxResponseList();
        if(invoiceSearch == null){
            ajaxResponseList.setCode(1168);
            ajaxResponseList.setMessage("发票搜索信息不合法");
            return ajaxResponseList;
        }
        if( invoiceSearch.getSearchType() == null || invoiceSearch.getSearchType() < 0){
            ajaxResponseList.setCode(1168);
            ajaxResponseList.setMessage("发票搜索信息不合法");
            return ajaxResponseList;
        }
        if(invoiceSearch.getPageNum() == null || invoiceSearch.getPageNum() < 0){
            ajaxResponseList.setCode(1030);
            ajaxResponseList.setMessage("页数或页码错误");
            return ajaxResponseList;
        }
        if(invoiceSearch.getPageSize() == null || invoiceSearch.getPageSize() < 1 || invoiceSearch.getPageSize() > 100){
            ajaxResponseList.setCode(1030);
            ajaxResponseList.setMessage("页数或页码错误");
            return ajaxResponseList;
        }
        
        InvoiceSearchResult invoiceSearchResult = invoiceBaseService.searchInvoiceBase(invoiceSearch);
        if(invoiceSearchResult == null || invoiceSearchResult.getTotal() == 0 || invoiceSearchResult.getInvoiceBaseList().isEmpty()){
            ajaxResponseList.setCode(1032);
            ajaxResponseList.setMessage("未搜索到符合条件的内容！");
            return  ajaxResponseList;
        }
        List<InvoiceBaseShow> invoiceBaseShowList = null;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            invoiceBaseShowList = objectMapper.readValue(objectMapper.writeValueAsString(invoiceSearchResult.getInvoiceBaseList()), new TypeReference<List<InvoiceBaseShow>>() {});
        }catch (Exception e){
            //e.printStackTrace();
            ajaxResponseList.setCode(1031);
            ajaxResponseList.setMessage("类型转换错误");
            return ajaxResponseList;
        }
        invoiceBaseShowList.forEach( invoiceBaseShow -> {
            /*
            try {
                String createTime = sdf.format(invoiceBaseShow.getCreateTime());
                invoiceBaseShow.setCreateTimeStr(createTime);
            }catch (Exception e){
                invoiceBaseShow.setCreateTimeStr("-");
            }
            try {
                String updateTime = sdf.format(invoiceBaseShow.getUpdateTime());
                invoiceBaseShow.setUpdateTimeStr(updateTime);
            }catch (Exception e){
                invoiceBaseShow.setUpdateTimeStr("-");
            }
            */
            if(invoiceBaseShow.getSupplierId() != null && invoiceBaseShow.getSupplierId() > 0L){
                try {
                    String supplierName = supplierService.getSupplierById(invoiceBaseShow.getSupplierId()).getSupplierName();
                    invoiceBaseShow.setSupplierName(supplierName);
                }catch (Exception e){
                    invoiceBaseShow.setSupplierName("-");
                }
            }
            if(invoiceBaseShow.getCustomerId() != null && invoiceBaseShow.getCustomerId() > 0L){
                try {
                    String customerName = customerService.getCustomerById(invoiceBaseShow.getCustomerId()).getCustomerName();
                    invoiceBaseShow.setCustomerName(customerName);
                }catch (Exception e){
                    invoiceBaseShow.setCustomerName("-");
                }
            }
            
        });
        ajaxResponseList.setCode(0);
        ajaxResponseList.setMessage("成功");
        ajaxResponseList.setData(invoiceBaseShowList);
        ajaxResponseList.setPageNum(invoiceSearchResult.getPageNum());
        ajaxResponseList.setPageSize(invoiceSearchResult.getPageSize());
        ajaxResponseList.setTotal(invoiceSearchResult.getTotal());
        return ajaxResponseList;
    }
    
    
}
