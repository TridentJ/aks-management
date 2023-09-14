/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/9/12
 * Time: 18:31
 **/
package com.aks.management.service;

import com.aks.management.bean.Purchase;
import com.aks.management.bean.PurchaseExample;
import com.aks.management.dao.PurchaseMapper;
import com.github.pagehelper.PageHelper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {
    
    @Resource
    private PurchaseMapper purchaseMapper;
    
    public Purchase getPurchaseById(Long id){
        return purchaseMapper.selectByPrimaryKey(id);
    }
    
    public List<Purchase> getPurchaseBySupplierId(Long supplierId,int pageNum,int pageSize){
        PurchaseExample purchaseExample = new PurchaseExample();
        purchaseExample.createCriteria().andSupplierIdEqualTo(supplierId);
        purchaseExample.setOrderByClause("id desc");
        PageHelper.startPage(pageNum,pageSize);
        return purchaseMapper.selectByExample(purchaseExample);
    }
    
    public List<Purchase> getPurchaseByState(int state,int pageNum,int pageSize){
        PurchaseExample purchaseExample = new PurchaseExample();
        if(state == 100){
            purchaseExample.createCriteria().andIdGreaterThan(0L).andStateGreaterThan(0);
        } else if(state == 200){
            purchaseExample.createCriteria().andIdGreaterThan(0L).andStateGreaterThanOrEqualTo(0);
        }else{
            purchaseExample.createCriteria().andIdGreaterThan(0L).andStateEqualTo(state);
        }
        purchaseExample.setOrderByClause("id desc");
        PageHelper.startPage(pageNum,pageSize);
        return purchaseMapper.selectByExample(purchaseExample);
    }
    public List<Purchase> getPurchaseByPurchaseState(int purchaseState,int pageNum,int pageSize){
        PurchaseExample purchaseExample = new PurchaseExample();
        if(purchaseState == 100){
            purchaseExample.createCriteria().andIdGreaterThan(0L).andPurchaseStateGreaterThan(0);
        } else if(purchaseState == 200){
            purchaseExample.createCriteria().andIdGreaterThan(0L).andPurchaseStateGreaterThanOrEqualTo(0);
        }else{
            purchaseExample.createCriteria().andIdGreaterThan(0L).andStateEqualTo(purchaseState);
        }
        purchaseExample.setOrderByClause("id desc");
        PageHelper.startPage(pageNum,pageSize);
        return purchaseMapper.selectByExample(purchaseExample);
    }
    
    public int addPurchase(Purchase purchase){
        return purchaseMapper.insertSelective(purchase);
    }
    
    public int updatePurchase(Purchase purchase){
        return purchaseMapper.updateByPrimaryKeySelective(purchase);
    }
    
    public int getAllCountByState(int state){
        PurchaseExample purchaseExample = new PurchaseExample();
        if(state == 100){
            purchaseExample.createCriteria().andIdGreaterThan(0L).andStateGreaterThan(0);
        } else if(state == 200){
            purchaseExample.createCriteria().andIdGreaterThan(0L).andStateGreaterThanOrEqualTo(0);
        }else{
            purchaseExample.createCriteria().andIdGreaterThan(0L).andStateEqualTo(state);
        }
        return (int) purchaseMapper.countByExample(purchaseExample);
    }
    
    public int changePurchasePurchaseStateById(long id,int purchaseState){
        Purchase purchase = new Purchase();
        purchase.setId(id);
        purchase.setPurchaseState(purchaseState);
        return purchaseMapper.updateByPrimaryKeySelective(purchase);
    }
    
    public int changePurchaseStateById(long id,int state){
        Purchase purchase = new Purchase();
        purchase.setId(id);
        purchase.setState(state);
        return purchaseMapper.updateByPrimaryKeySelective(purchase);
    }
    
}
