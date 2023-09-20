/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/6/7
 * Time: 20:25
 **/
package com.aks.management.controller;

import com.aks.management.bean.Supplier;
import com.aks.management.service.SupplierService;
import com.aks.management.utils.AjaxResponse;
import com.aks.management.utils.AjaxResponseList;
import com.aks.management.utils.supplier.SupplierSampleInfo;
import com.aks.management.utils.supplier.SupplierSearch;
import com.aks.management.utils.supplier.SupplierSearchResult;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.yitter.idgen.YitIdHelper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
@Tag(name="供应商接口",description = "操作供应商的接口清单")
@RequestMapping(value="/api/supplier")
public class SupplierController {
    
    
    @Resource
    private SupplierService supplierService;
    
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Operation(
            summary = "供应商基础信息清单",
            description = "基础供应商信息，用于列表展示",
            parameters = {
                @Parameter(name="pageNum", description = "页码",required = true),
                @Parameter(name="pageSize", description = "页数",required = true)
            }
    )
    @GetMapping (value = "/list")
    public AjaxResponseList listSupplier(Integer pageNum, Integer pageSize){
        AjaxResponseList ajaxResponse = new AjaxResponseList();
        //Integer pageNum = sampleListRequest.getPageNum();
        //Integer pageSize = sampleListRequest.getPageSize();
        if(pageNum == null || pageNum < 0 || pageSize == null || pageSize < 0){
            ajaxResponse.setCode(1030);
            ajaxResponse.setMessage("页数或页码错误");
            return ajaxResponse;
        }
        List<Supplier> supplierList = supplierService.getSupplierByState(100,pageNum,pageSize);
        if(supplierList == null || supplierList.isEmpty()){
            ajaxResponse.setCode(1130);
            ajaxResponse.setMessage("供应商查询结果为空");
            return ajaxResponse;
        }
        
        List<SupplierSampleInfo> supplierSampleInfoList = new ArrayList<>();
        supplierList.forEach( supplier -> {
            SupplierSampleInfo supplierSampleInfo = new SupplierSampleInfo();
            supplierSampleInfo.setId(supplier.getId());
            supplierSampleInfo.setSupplierName(supplier.getSupplierName());
            supplierSampleInfo.setSupplierNumber(supplier.getSupplierNumber());
            supplierSampleInfo.setOrderQuantity(10);
            supplierSampleInfo.setAddress(supplier.getCompanyAddress());
            supplierSampleInfo.setState(supplier.getState());
            supplierSampleInfo.setTelephone(supplier.getTelephone());
            supplierSampleInfo.setCreateTime(supplier.getCreateTime());
            
            supplierSampleInfoList.add(supplierSampleInfo);
            
        });
        int totalNum = supplierService.getAllCountByState(100);
        if(totalNum > 0){
            ajaxResponse.setTotal(totalNum);
        }else{
            ajaxResponse.setTotal(0);
        }
        ajaxResponse.setPageSize(pageSize);
        ajaxResponse.setPageNum(pageNum);
        ajaxResponse.setCode(0);
        ajaxResponse.setMessage("成功");
        ajaxResponse.setData(supplierSampleInfoList);
        return ajaxResponse;
    }
    
    
    @Operation(
            summary = "查询单个供应商基础信息",
            description = "单个供应商的基础信息",
            parameters = {
                    @Parameter(name="id", description = "供应商ID", required = true),
            }
    )
    @GetMapping(value = "/show")
    public AjaxResponse showSupplier(Long id){
        //System.out.println("/api/supplier/show: id = " + id);
        AjaxResponse ajaxResponse = new AjaxResponse();
        if(id == null || id < 0){
            ajaxResponse.setCode(1131);
            ajaxResponse.setMessage("供应商ID不合法");
            return ajaxResponse;
        }
        Supplier supplier = supplierService.getSupplierById(id);
        if(supplier == null){
            ajaxResponse.setCode(1132);
            ajaxResponse.setMessage("查询的供应商不存在");
            return ajaxResponse;
        }
        //SupplierShow supplierShow = (SupplierShow) supplier;
        /*
        SupplierShow supplierShow = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            supplierShow = objectMapper.readValue(objectMapper.writeValueAsString(supplier), SupplierShow.class);
        }catch (Exception e){
            ajaxResponse.setCode(1031);
            ajaxResponse.setMessage("类型转换错误");
            return ajaxResponse;
        }
        try {
            String time = sdf.format(supplier.getCreateTime());
            supplierShow.setCreateTimeStr(time);
        }catch (Exception e){
            supplierShow.setCreateTimeStr("-");
        }
        try {
            String time = sdf.format(supplier.getUpdateTime());
            supplierShow.setUpdateTimeStr(time);
        }catch (Exception e){
            supplierShow.setUpdateTimeStr("-");
        }
        */
        //supplierShow.setComments(supplierShow.getComments());

        ajaxResponse.setCode(0);
        ajaxResponse.setMessage("成功");
        ajaxResponse.setData(supplier);
        
        
        return ajaxResponse;
    }
    
    @Operation(
            summary = "添加供应商基础信息",
            description = "添加供应商的基础信息",
            parameters = {
                    @Parameter(name="supplierShow", description = "供应商信息", required = true),
            }
    )
    @PostMapping(value = "/add")
    public AjaxResponse addSupplier(@RequestBody Supplier supplier){
        AjaxResponse ajaxResponse = new AjaxResponse();
        if(supplier == null){
            ajaxResponse.setCode(1134);
            ajaxResponse.setMessage("供应商信息不合法");
            return ajaxResponse;
        }
        //Supplier supplier = supplierShow;
        supplier.setCreateTime(null);
        supplier.setUpdateTime(null);
        supplier.setId(YitIdHelper.nextId());
        int result = supplierService.addSupplier(supplier);
        if(result == 1){
            //成功
            ajaxResponse.setCode(0);
            ajaxResponse.setMessage("成功");
            ajaxResponse.setData(supplier.getId());
        }else{
            ajaxResponse.setCode(1135);
            ajaxResponse.setMessage("添加供应商信息失败");
        }
        return ajaxResponse;
    }
    
    @Operation(
            summary = "更新供应商基础信息",
            description = "更新供应商的基础信息",
            parameters = {
                    @Parameter(name="supplier", description = "供应商信息", required = true),
            }
    )
    @PostMapping(value = "/update")
    public AjaxResponse updateSupplier(@RequestBody Supplier supplier){
        AjaxResponse ajaxResponse = new AjaxResponse();
        if(supplier == null || supplier.getId() == null || supplier.getId() < 0L){
            ajaxResponse.setCode(1134);
            ajaxResponse.setMessage("供应商信息不合法");
            return ajaxResponse;
        }
        Supplier supplier1 = supplierService.getSupplierById(supplier.getId());
        if(supplier1 == null){
            ajaxResponse.setCode(1131);
            ajaxResponse.setMessage("供应商ID不合法");
            return ajaxResponse;
        }
        supplier.setCreateTime(null);
        supplier.setUpdateTime(LocalDateTime.now());
        int result = supplierService.updateSupplierById(supplier);
        if(result == 1){
            ajaxResponse.setCode(0);
            ajaxResponse.setMessage("成功");
        }else{
            ajaxResponse.setCode(1136);
            ajaxResponse.setMessage("更新供应商信息失败");
        }
        return ajaxResponse;
    }
    
    @Operation(
            summary = "搜索供应商基础信息",
            description = "搜索供应商的基础信息",
            parameters = {
                    @Parameter(name="supplierSearch", description = "供应商信息", required = true),
            }
    )
    @PostMapping(value = "/search")
    public AjaxResponseList searchSupplier(@RequestBody SupplierSearch supplierSearch){
    
        AjaxResponseList ajaxResponse = new AjaxResponseList();
        if(supplierSearch == null){
            ajaxResponse.setCode(1137);
            ajaxResponse.setMessage("供应商搜索信息不合法");
            return ajaxResponse;
        }
        if(supplierSearch.getPageNum() == null || supplierSearch.getPageNum() < 0){
            ajaxResponse.setCode(1030);
            ajaxResponse.setMessage("页数或页码错误");
            return ajaxResponse;
        }
        if(supplierSearch.getPageSize() == null || supplierSearch.getPageSize() < 1 || supplierSearch.getPageSize() > 100){
            ajaxResponse.setCode(1030);
            ajaxResponse.setMessage("页数或页码错误");
            return ajaxResponse;
        }
        //List<SupplierShow> supplierShowList = new ArrayList<>();
        //List<Supplier> supplierList = supplierService.searchSupplier(supplierSearch);
        SupplierSearchResult supplierSearchResult = supplierService.searchSupplier(supplierSearch);
        if(supplierSearchResult == null || supplierSearchResult.getTotal() == 0 || supplierSearchResult.getSupplierList().isEmpty()){
            ajaxResponse.setCode(1032);
            ajaxResponse.setMessage("未搜索到符合条件的内容！");
            return  ajaxResponse;
        }
        /*
        List<SupplierShow> supplierShowList = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            supplierShowList = objectMapper.readValue(objectMapper.writeValueAsString(supplierSearchResult.getSupplierList()), new TypeReference<List<SupplierShow>>() {});
        }catch (Exception e){
            ajaxResponse.setCode(1031);
            ajaxResponse.setMessage("类型转换错误");
            return ajaxResponse;
        }
        supplierShowList.forEach( supplierShow -> {
            try {
                String createTime = sdf.format(supplierShow.getCreateTime());
                supplierShow.setCreateTimeStr(createTime);
            }catch (Exception e){
                supplierShow.setCreateTimeStr("-");
            }
            try {
                String updateTime = sdf.format(supplierShow.getUpdateTime());
                supplierShow.setUpdateTimeStr(updateTime);
            }catch (Exception e){
                supplierShow.setUpdateTimeStr("-");
            }
        });
        */
        ajaxResponse.setCode(0);
        ajaxResponse.setMessage("成功");
        ajaxResponse.setData(supplierSearchResult.getSupplierList());
        ajaxResponse.setPageNum(supplierSearchResult.getPageNum());
        ajaxResponse.setPageSize(supplierSearchResult.getPageSize());
        ajaxResponse.setTotal(supplierSearchResult.getTotal());
        return ajaxResponse;
    }
    
    @Operation(
            summary = "删除供应商",
            description = "删除供应商",
            parameters = {
                    @Parameter(name="id", description = "供应商ID", required = true),
            }
    )
    @GetMapping(value = "/delete")
    public AjaxResponse frozeState(Long id){
        AjaxResponse ajaxResponse = new AjaxResponse();
        int result = supplierService.changeSupplierStateById(id,0);
        if(result != 1){
            ajaxResponse.setCode(1138);
            ajaxResponse.setMessage("删除失败");
        }else{
            ajaxResponse.setCode(0);
            ajaxResponse.setMessage("成功");
        }
        return ajaxResponse;
    }
    
    
}
