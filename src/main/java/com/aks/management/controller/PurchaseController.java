/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/9/12
 * Time: 18:48
 **/
package com.aks.management.controller;

import com.aks.management.bean.Purchase;
import com.aks.management.bean.Supplier;
import com.aks.management.service.PurchaseService;
import com.aks.management.service.SupplierService;
import com.aks.management.utils.AjaxResponse;
import com.aks.management.utils.AjaxResponseList;
import com.aks.management.utils.purchase.PurchaseSampleList;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@Tag(name="采购单接口",description = "采购单的接口清单")
@RequestMapping(value = "/api/purchase")
public class PurchaseController {
    
    @Resource
    private PurchaseService purchaseService;
    @Resource
    private SupplierService supplierService;
    
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Operation(
            summary = "采购单清单",
            description = "采购单信息，用于列表展示",
            parameters = {
                    @Parameter(name="pageNum", description = "页码",required = true),
                    @Parameter(name="pageSize", description = "页数",required = true)
            }
    )
    @GetMapping(value = "/list")
    public AjaxResponseList listPurchase(Integer pageNum, Integer pageSize){
        AjaxResponseList ajaxResponseList = new AjaxResponseList();
        if(pageNum == null || pageNum < 0 || pageSize == null || pageSize < 0){
            ajaxResponseList.setCode(1030);
            ajaxResponseList.setMessage("页数或页码错误");
            return ajaxResponseList;
        }
        List<Purchase> purchaseList = purchaseService.getPurchaseByState(100,pageNum,pageSize);
        if(purchaseList == null && purchaseList.isEmpty()){
            ajaxResponseList.setCode(1120);
            ajaxResponseList.setMessage("采购清单为空");
            return ajaxResponseList;
        }
        List<PurchaseSampleList> purchaseSampleListList = new ArrayList<PurchaseSampleList>();
        Supplier supplier = null;
        for (Purchase purchase:purchaseList){
            PurchaseSampleList purchaseSampleList = new PurchaseSampleList();
            purchaseSampleList.setPurchaseName(purchase.getPurchaseName());
            purchaseSampleList.setPurchaseState(purchase.getPurchaseState());
            purchaseSampleList.setId(purchase.getId());
            purchaseSampleList.setPurchaseSelfId(purchase.getPurchaseSelfId());
            purchaseSampleList.setPurchasePeerId(purchase.getPurchasePeerId());
            supplier = supplierService.getSupplierById(purchase.getSupplierId());
            if(supplier == null){
                ajaxResponseList.setCode(1121);
                ajaxResponseList.setMessage("关联供应商错误");
                return ajaxResponseList;
            }else{
                purchaseSampleList.setSupplierName(supplier.getSupplierName());
            }
            purchaseSampleList.setDeposit(purchase.getDeposit());
            purchaseSampleList.setPriceIncludingTax(purchase.getPriceIncludingTax());
            try {
                purchaseSampleList.setSignTime(sdf.format(purchase.getSignTime()));
            }catch (Exception e){
                purchaseSampleList.setSignTime("-");
            }
            try {
                purchaseSampleList.setContractDeliverDate(sdf.format(purchase.getContractDeliverDate()));
            }catch (Exception e){
                purchaseSampleList.setContractDeliverDate("-");
            }
            purchaseSampleListList.add(purchaseSampleList);
        }
        int totalNum = purchaseService.getAllCountByState(100);
        if(totalNum > 0){
            ajaxResponseList.setTotal(totalNum);
        }else{
            ajaxResponseList.setTotal(0);
        }
        ajaxResponseList.setPageSize(pageSize);
        ajaxResponseList.setPageNum(pageNum);
        ajaxResponseList.setCode(0);
        ajaxResponseList.setMessage("成功");
        ajaxResponseList.setData(purchaseSampleListList);
        return ajaxResponseList;
        
    }
    
    @Operation(
            summary = "查询单个采购单信息",
            description = "单个采购单信息",
            parameters = {
                    @Parameter(name="id", description = "采购单ID", required = true),
            }
    )
    @GetMapping(value = "/show")
    public AjaxResponse showPurchase(Long id){
        AjaxResponse ajaxResponse = new AjaxResponse();
        if(id == null || id < 0){
            ajaxResponse.setCode(1123);
            ajaxResponse.setMessage("采购单ID不合法");
            return ajaxResponse;
        }
        Purchase purchase = purchaseService.getPurchaseById(id);
        if( purchase == null){
            ajaxResponse.setCode(1124);
            ajaxResponse.setMessage("查询的采购单不存在");
            return ajaxResponse;
        }
        ajaxResponse.setCode(0);
        ajaxResponse.setMessage("成功");
        ajaxResponse.setData(purchase);
        return ajaxResponse;
    }
    
    @Operation(
            summary = "删除采购单",
            description = "删除采购单",
            parameters = {
                    @Parameter(name="id", description = "采购单ID", required = true),
            }
    )
    @GetMapping(value = "/delete")
    public AjaxResponse frozeState(Long id){
        AjaxResponse ajaxResponse = new AjaxResponse();
        int result = purchaseService.changePurchaseStateById(id,0);
        if(result == 1){
            ajaxResponse.setCode(0);
            ajaxResponse.setMessage("成功");
        }else{
            ajaxResponse.setCode(1122);
            ajaxResponse.setMessage("删除采购单失败");
        }
        return ajaxResponse;
    }
    
    
}
