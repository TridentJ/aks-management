/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/10/9
 * Time: 10:15
 **/
package com.aks.management.service;

import com.aks.management.bean.PurchaseCargo;
import com.aks.management.bean.PurchaseCargoExample;
import com.aks.management.controller.PurchaseCargoController;
import com.aks.management.dao.PurchaseCargoMapper;
import com.github.pagehelper.PageHelper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseCargoService {
    
    @Resource
    private PurchaseCargoMapper purchaseCargoMapper;
    
    public PurchaseCargo getPurchaseCargoById(Long id){
        return purchaseCargoMapper.selectByPrimaryKey(id);
    }
    
    public List<PurchaseCargo> getPurchaseCargoByState(int pageNum,int pageSize,int state){
        PurchaseCargoExample purchaseCargoExample = new PurchaseCargoExample();
        purchaseCargoExample.createCriteria().andStateGreaterThan(state);
        purchaseCargoExample.setOrderByClause("id desc");
        PageHelper.startPage(pageNum,pageSize);
        return purchaseCargoMapper.selectByExample(purchaseCargoExample);
    }
    
    public List<PurchaseCargo> getPurchaseCargoByPurchaseId(int pageNum,int pageSize,Long purchaseId){
        PurchaseCargoExample purchaseCargoExample = new PurchaseCargoExample();
        purchaseCargoExample.createCriteria().andPurchaseIdEqualTo(purchaseId).andStateGreaterThan(0);
        purchaseCargoExample.setOrderByClause("id desc");
        PageHelper.startPage(pageNum,pageSize);
        return purchaseCargoMapper.selectByExample(purchaseCargoExample);
    }
    
    public int addPurchaseCargo(PurchaseCargo purchaseCargo){
        return purchaseCargoMapper.insertSelective(purchaseCargo);
    }
    
    public int getCountByState(int state){
        PurchaseCargoExample purchaseCargoExample = new PurchaseCargoExample();
        if(state == 100){
            purchaseCargoExample.createCriteria().andIdGreaterThan(0L).andStateGreaterThan(0);
        } else if(state == 200){
            purchaseCargoExample.createCriteria().andIdGreaterThan(0L).andStateGreaterThanOrEqualTo(0);
        }else{
            purchaseCargoExample.createCriteria().andIdGreaterThan(0L).andStateEqualTo(state);
        }
        return (int) purchaseCargoMapper.countByExample(purchaseCargoExample);
    }
    
    public int updatePurchaseCargoById(PurchaseCargo purchaseCargo){
        return purchaseCargoMapper.updateByPrimaryKeySelective(purchaseCargo);
    }
    
    public boolean checkPurchaseCargoIsExist(Long id){
        PurchaseCargo purchaseCargo = purchaseCargoMapper.selectByPrimaryKey(id);
        if(purchaseCargo == null){
            return false;
        }
        return true;
    }
    
}
