/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/10/9
 * Time: 18:36
 **/
package com.aks.management.controller;

import com.aks.management.bean.Cargo;
import com.aks.management.bean.PurchaseCargo;
import com.aks.management.service.CargoService;
import com.aks.management.service.PurchaseCargoService;
import com.aks.management.service.PurchaseService;
import com.aks.management.utils.AjaxResponse;
import com.aks.management.utils.AjaxResponseList;
import com.aks.management.utils.purchase.PurchaseShow;
import com.aks.management.utils.purchaseCargo.PurchaseCargoFull;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.yitter.idgen.YitIdHelper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Tag(name="采购货物接口",description = "采购货物的接口清单")
@RequestMapping(value="/api/purchaseCargo")
public class PurchaseCargoController {
    
    @Resource
    private PurchaseCargoService purchaseCargoService;
    @Resource
    private CargoService cargoService;
    @Resource
    private PurchaseService purchaseService;
    
    @Operation(
            summary = "采购单货物清单",
            description = "采购单货物，用于列表展示",
            parameters = {
                    @Parameter(name="pageNum", description = "页码",required = true),
                    @Parameter(name="pageSize", description = "页数",required = true)
            }
    )
    @GetMapping(value = "/list")
    public AjaxResponseList listPurchaseCargoByPurchaseId(Long purchaseId,Integer pageNum,Integer pageSize){
        AjaxResponseList ajaxResponseList = new AjaxResponseList();
        if(pageNum == null || pageNum < 0 || pageSize == null || pageSize < 0){
            ajaxResponseList.setCode(1030);
            ajaxResponseList.setMessage("页数或页码错误");
            return ajaxResponseList;
        }
        List<PurchaseCargo> purchaseCargoList = purchaseCargoService.getPurchaseCargoByPurchaseId(pageNum,pageSize,purchaseId);
        if(purchaseCargoList == null || purchaseCargoList.isEmpty()){
            ajaxResponseList.setCode(1342);
            ajaxResponseList.setMessage("查询采购单货物为空");
            return ajaxResponseList;
        }
        int totalNum = purchaseCargoService.getCountByState(100);
        if(totalNum > 0){
            ajaxResponseList.setTotal(totalNum);
        }else{
            ajaxResponseList.setTotal(0);
        }
        ajaxResponseList.setPageSize(pageSize);
        ajaxResponseList.setPageNum(pageNum);
        ajaxResponseList.setCode(0);
        ajaxResponseList.setMessage("成功");
        ajaxResponseList.setData(purchaseCargoList);
        return ajaxResponseList;
    }
    
    @Operation(
            summary = "添加采购单货物信息",
            description = "添加采购单货物信息",
            parameters = {
                    @Parameter(name="purchaseCargo", description = "采购单货物信息", required = true),
            }
    )
    @PostMapping(value = "/add")
    public AjaxResponse addPurchaseCargo(@RequestBody List<PurchaseCargo> purchaseCargoList){
        int successNum = 0;
        int failureNum = 0;
        int totalNum = 0;
        int result = 0;
        
        AjaxResponse ajaxResponse = new AjaxResponse();
        if(purchaseCargoList == null || purchaseCargoList.isEmpty()){
            ajaxResponse.setCode(1340);
            ajaxResponse.setMessage("采购货物信息不合法");
            return ajaxResponse;
        }
        totalNum = purchaseCargoList.size();
        for (PurchaseCargo purchaseCargo : purchaseCargoList) {
            if(purchaseService.getPurchaseById(purchaseCargo.getPurchaseId()) == null){
                failureNum++;
                continue;
            }
            if(cargoService.getCargoById(purchaseCargo.getCargoId()) == null){
                failureNum++;
                continue;
            }
            purchaseCargo.setId(YitIdHelper.nextId());
            result = purchaseCargoService.addPurchaseCargo(purchaseCargo);
            if(result == 1){
                successNum++;
            }else{
                failureNum++;
            }
        }
        
        if( successNum == totalNum){
            ajaxResponse.setCode(0);
            ajaxResponse.setMessage("成功");
        }else{
            ajaxResponse.setCode(1341);
            ajaxResponse.setMessage("添加采购货物存在失败！货物共计：" + totalNum + "，成功：" + successNum + "，失败：" + failureNum);
        }
        return ajaxResponse;
    }
    
    @Operation(
            summary = "添加采购单单个货物信息",
            description = "添加采购单单个货物信息",
            parameters = {
                    @Parameter(name="purchaseCargo", description = "采购单单个货物信息", required = true),
            }
    )
    @PostMapping(value = "/addOne")
    public AjaxResponse addOnePurchaseCargo(@RequestBody PurchaseCargo purchaseCargo){
        AjaxResponse ajaxResponse = new AjaxResponse();
        if(purchaseCargo == null){
            ajaxResponse.setCode(1340);
            ajaxResponse.setMessage("采购货物信息不合法");
            return ajaxResponse;
        }
        if(purchaseService.getPurchaseById(purchaseCargo.getPurchaseId()) == null){
            ajaxResponse.setCode(1340);
            ajaxResponse.setMessage("采购货物信息不合法");
            return ajaxResponse;
        }
        if(cargoService.getCargoById(purchaseCargo.getCargoId()) == null){
            ajaxResponse.setCode(1340);
            ajaxResponse.setMessage("采购货物信息不合法");
            return ajaxResponse;
        }
        purchaseCargo.setId(YitIdHelper.nextId());
        int result = purchaseCargoService.addPurchaseCargo(purchaseCargo);
        if( result == 1){
            ajaxResponse.setCode(0);
            ajaxResponse.setMessage("成功");
            ajaxResponse.setData(purchaseCargo.getCargoId());
        }else{
            ajaxResponse.setCode(1341);
            ajaxResponse.setMessage("添加采购货物失败");
        }
        return ajaxResponse;
    }
    
    @Operation(
            summary = "更新采购单单个货物信息",
            description = "更新采购单单个货物信息",
            parameters = {
                    @Parameter(name="purchaseCargo", description = "待更新的采购单单个货物信息", required = true),
            }
    )
    @PostMapping(value = "/update")
    public AjaxResponse updatePurchaseCargoById(@RequestBody PurchaseCargo purchaseCargo){
        AjaxResponse ajaxResponse = new AjaxResponse();
        if(purchaseCargo == null || purchaseCargo.getId() == null){
            ajaxResponse.setCode(1346);
            ajaxResponse.setMessage("采购货物ID不合法");
            return ajaxResponse;
        }
        if(purchaseCargo.getCargoId() == null || purchaseCargo.getCargoId() < 0L){
            ajaxResponse.setCode(1343);
            ajaxResponse.setMessage("不存在货物信息");
            return ajaxResponse;
        }
        if(purchaseCargo.getPurchaseId() == null || purchaseCargo.getPurchaseId() < 0L){
            ajaxResponse.setCode(1345);
            ajaxResponse.setMessage("采购单ID不合法");
            return ajaxResponse;
        }
        if(purchaseCargoService.checkPurchaseCargoIsExist(purchaseCargo.getId())){
            ajaxResponse.setCode(1345);
            ajaxResponse.setMessage("待更新的采购货物不存在");
            return ajaxResponse;
        }
        int result = purchaseCargoService.updatePurchaseCargoById(purchaseCargo);
        if( result == 1){
            ajaxResponse.setCode(0);
            ajaxResponse.setMessage("成功");
        }else{
            ajaxResponse.setCode(1346);
            ajaxResponse.setMessage("更新采购货物失败");
        }
        return ajaxResponse;
    }
    
    @Operation(
            summary = "删除采购单单个货物信息",
            description = "删除采购单单个货物信息",
            parameters = {
                    @Parameter(name="id", description = "待删除的采购单单个货物ID", required = true),
            }
    )
    @GetMapping(value = "/delete")
    public AjaxResponse deletePurchaseCargoById(Long id){
        AjaxResponse ajaxResponse = new AjaxResponse();
        if(id == null || id < 0L){
            ajaxResponse.setCode(1343);
            ajaxResponse.setMessage("不存在货物信息");
            return ajaxResponse;
        }
        PurchaseCargo purchaseCargo = new PurchaseCargo();
        purchaseCargo.setId(id);
        purchaseCargo.setState(0);
        int result = purchaseCargoService.updatePurchaseCargoById(purchaseCargo);
        if( result == 1){
            ajaxResponse.setCode(0);
            ajaxResponse.setMessage("成功");
        }else{
            ajaxResponse.setCode(1347);
            ajaxResponse.setMessage("删除货物失败");
        }
        return ajaxResponse;
    }
    
    
    @Operation(
            summary = "获取单个采购单的所有货物信息",
            description = "获取单个采购单的所有货物信息",
            parameters = {
                    @Parameter(name="purchaseId", description = "采购单Id",required = true),
            }
    )
    @GetMapping(value = "/show")
    public AjaxResponse getPurchaseCargoByPurchaseId(Long purchaseId){
        AjaxResponse ajaxResponse = new AjaxResponse();
        if (purchaseId == null || purchaseId <= 0L){
            ajaxResponse.setCode(1343);
            ajaxResponse.setMessage("采购单ID不合法");
            return ajaxResponse;
        }
        List<PurchaseCargo> purchaseCargoList = purchaseCargoService.getPurchaseCargoByPurchaseId(1,0,purchaseId);
        if( purchaseCargoList == null || purchaseCargoList.isEmpty()){
            ajaxResponse.setCode(1344);
            ajaxResponse.setMessage("不存在货物信息");
            return ajaxResponse;
        }
        List<PurchaseCargoFull> purchaseCargoFullList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            purchaseCargoFullList = objectMapper.readValue(objectMapper.writeValueAsString(purchaseCargoList), new TypeReference<List<PurchaseCargoFull>>() {});
        }catch (Exception e){
            //e.printStackTrace();
            ajaxResponse.setCode(1031);
            ajaxResponse.setMessage("类型转换错误");
            return ajaxResponse;
        }
        purchaseCargoFullList.forEach( purchaseCargoFull -> {
            Cargo cargo = cargoService.getCargoById(purchaseCargoFull.getCargoId());
            if(cargo != null){
                purchaseCargoFull.setCargoName(cargo.getCargoName());
                purchaseCargoFull.setBrand(cargo.getBrand());
                purchaseCargoFull.setDescription(cargo.getDescription());
                purchaseCargoFull.setCargoType(cargo.getCargoType());
            }else{
                purchaseCargoFull.setCargoName("-");
                purchaseCargoFull.setBrand("-");
                purchaseCargoFull.setDescription("-");
                purchaseCargoFull.setCargoType("-");
            }
        });
        ajaxResponse.setCode(0);
        ajaxResponse.setMessage("成功");
        ajaxResponse.setData(purchaseCargoFullList);
        return ajaxResponse;
    }
    
    
}
