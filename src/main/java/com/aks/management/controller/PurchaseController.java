/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/9/12
 * Time: 18:48
 **/
package com.aks.management.controller;

import com.aks.management.bean.Purchase;
import com.aks.management.bean.Supplier;
import com.aks.management.bean.SupplierContacts;
import com.aks.management.bean.User;
import com.aks.management.service.PurchaseService;
import com.aks.management.service.SupplierContactsService;
import com.aks.management.service.SupplierService;
import com.aks.management.service.UserService;
import com.aks.management.utils.AjaxResponse;
import com.aks.management.utils.AjaxResponseList;
import com.aks.management.utils.purchase.PurchaseSampleList;
import com.aks.management.utils.purchase.PurchaseShow;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    @Resource
    private SupplierContactsService supplierContactsService;
    @Resource
    private UserService userService;
    
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
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
                //LocalDateTime signTime = LocalDateTime.parse(purchase.getSignTime(),DATE_FORMATTER);
                purchaseSampleList.setSignTime(purchase.getSignTime().format(DATE_FORMATTER));
            }catch (Exception e){
                purchaseSampleList.setSignTime("-");
            }
            try {
                purchaseSampleList.setContractDeliverDate(purchase.getContractDeliverDate().format(DATE_FORMATTER));
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
        PurchaseShow purchaseShow = null;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            purchaseShow = objectMapper.readValue(objectMapper.writeValueAsString(purchase), new TypeReference<PurchaseShow>() {});
        }catch (Exception e){
            ajaxResponse.setCode(1031);
            ajaxResponse.setMessage("类型转换错误");
            return ajaxResponse;
        }
        if(purchaseShow == null){
            ajaxResponse.setCode(1124);
            ajaxResponse.setMessage("查询的采购单不存在");
            return ajaxResponse;
        }
        if ( purchase.getSupplierId() != null && purchase.getSupplierId() > 0L){
            Supplier supplier = supplierService.getSupplierById(purchase.getSupplierId());
            if(supplier != null){
                purchaseShow.setSupplierName(supplier.getSupplierName());
            }
        }
        if ( purchase.getContactsId() != null && purchase.getContactsId() > 0L){
            
            SupplierContacts supplierContacts = supplierContactsService.getSupplierContactsById(purchase.getContactsId());
            if(supplierContacts != null){
                purchaseShow.setContactsName(supplierContacts.getScName());
            }
        }
        if(purchase.getSalesmanId() != null && purchase.getSalesmanId() > 0L){
            User user = userService.getUserById(purchase.getSalesmanId());
            if(user != null){
                purchaseShow.setSalesmanName(user.getNickName());
            }
        }
        /*
        if(purchase.getOperatorId() != null && purchase.getOperatorId() > 0L){
            User user = userService.getUserById(purchase.getOperatorId());
            if(user != null){
                purchaseShow.setOperatorName(user.getNickName());
            }
        }
        */
        ajaxResponse.setCode(0);
        ajaxResponse.setMessage("成功");
        ajaxResponse.setData(purchaseShow);
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
    
    @Operation(
            summary = "添加采购单",
            description = "新增一个采购单",
            parameters = {
                    @Parameter(name="purchase", description = "采购单信息", required = true),
            }
    )
    @PostMapping(value = "/add")
    public AjaxResponse addPurchase(@RequestBody Purchase purchase){
        AjaxResponse ajaxResponse = new AjaxResponse();
        if( purchase == null){
            ajaxResponse.setCode(1125);
            ajaxResponse.setMessage("采购信息不合法");
            return ajaxResponse;
        }
        purchase.setId(YitIdHelper.nextId());
        purchase.setCreateTime(null);
        purchase.setUpdateTime(null);
        int result = purchaseService.addPurchase(purchase);
        if(result != 1){
            ajaxResponse.setCode(1126);
            ajaxResponse.setMessage("采购单添加失败");
            return ajaxResponse;
        }
        ajaxResponse.setCode(0);
        ajaxResponse.setMessage("成功");
        ajaxResponse.setData(purchase.getId());
        return ajaxResponse;
    }
    
}
