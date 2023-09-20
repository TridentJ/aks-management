/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/6/7
 * Time: 19:51
 **/
package com.aks.management.service;

import com.aks.management.bean.Supplier;
import com.aks.management.bean.SupplierContacts;
import com.aks.management.bean.SupplierExample;
import com.aks.management.dao.SupplierMapper;
import com.aks.management.utils.supplier.SupplierSearch;
import com.aks.management.utils.supplier.SupplierSearchResult;
import com.github.pagehelper.PageHelper;
import jakarta.annotation.Resource;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class SupplierService {
    
    @Resource
    private SupplierMapper supplierMapper;
    
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    public Supplier getSupplierById(Long id) {
        
        return supplierMapper.selectByPrimaryKey(id);
    }
    
    public int checkSupplierIsExists(Long id){
        Supplier supplier = supplierMapper.selectByPrimaryKey(id);
        if(supplier == null){
            return 0;
        }
        return 1;
    }
    
    public List<Supplier> getAllSupplier(int pageNum, int pageSize) {
        SupplierExample supplierExample = new SupplierExample();
        supplierExample.createCriteria().andIdGreaterThan(0L);
        supplierExample.setOrderByClause("id desc");
        PageHelper.startPage(pageNum,pageSize);
        return supplierMapper.selectByExample(supplierExample);
    }
    
    public List<Supplier> getSupplierByState(int state, int pageNum, int pageSize){
        SupplierExample supplierExample = new SupplierExample();
        if(state == 100){
            supplierExample.createCriteria().andIdGreaterThan(0L).andStateGreaterThan(0);
        } else if(state == 200){
            supplierExample.createCriteria().andIdGreaterThan(0L).andStateGreaterThanOrEqualTo(0);
        }else{
            supplierExample.createCriteria().andIdGreaterThan(0L).andStateEqualTo(state);
        }
        supplierExample.setOrderByClause("id desc");
        PageHelper.startPage(pageNum,pageSize);
        return supplierMapper.selectByExample(supplierExample);
    }
    
    
    
    
    public SupplierSearchResult searchSupplier(SupplierSearch supplierSearch) {
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SupplierExample supplierExample = new SupplierExample();
        SupplierExample.Criteria criteria = supplierExample.createCriteria();
        if(supplierSearch.getCreateTimeStart() != null && supplierSearch.getCreateTimeEnd() != null){
            if(supplierSearch.getCreateTimeStart().compareTo(supplierSearch.getCreateTimeEnd()) < 0){
                try {
                    LocalDateTime createTimeStart = LocalDateTime.parse(supplierSearch.getCreateTimeStart() + " 00:00:00",DATE_TIME_FORMATTER);
                    LocalDateTime createTimeEnd = LocalDateTime.parse(supplierSearch.getCreateTimeEnd() + " 23:59:59",DATE_TIME_FORMATTER);
                    criteria.andCreateTimeBetween(createTimeStart,createTimeEnd);
                } catch (Exception e) {
                    return null;
                }
    
            }
        }
        if(supplierSearch.getUpdateTimeStart() != null && supplierSearch.getUpdateTimeEnd() != null){
            if(supplierSearch.getUpdateTimeStart().compareTo(supplierSearch.getUpdateTimeEnd()) < 0){
                try {
                    LocalDateTime updateTimeStart = LocalDateTime.parse(supplierSearch.getUpdateTimeStart() + " 00:00:00",DATE_TIME_FORMATTER);
                    LocalDateTime updateTimeEnd = LocalDateTime.parse(supplierSearch.getCreateTimeEnd() + " 23:59:59",DATE_TIME_FORMATTER);
                    criteria.andUpdateTimeBetween(updateTimeStart,updateTimeEnd);
                } catch (Exception e) {
                    return null;
                }
            }
        }
        if(supplierSearch.getSupplierName() != null && supplierSearch.getSupplierName().compareTo("") != 0){
            criteria.andSupplierNameLike("%" + supplierSearch.getSupplierName() + "%");
        }
        if(supplierSearch.getSupplierNumber() != null && supplierSearch.getSupplierNumber().compareTo("") != 0){
            criteria.andSupplierNumberLike("%" + supplierSearch.getSupplierNumber() + "%");
        }
        if(supplierSearch.getTelephone() != null && supplierSearch.getTelephone().compareTo("") != 0){
            criteria.andTelephoneLike("%" + supplierSearch.getTelephone() + "%");
        }
        if(supplierSearch.getPhone() != null && supplierSearch.getPhone().compareTo("") != 0){
            criteria.andPhoneLike("%" + supplierSearch.getPhone() + "%");
        }
        if(supplierSearch.getFax() != null && supplierSearch.getFax().compareTo("") != 0){
            criteria.andFaxLike("%" + supplierSearch.getFax() + "%");
        }
        if(supplierSearch.getCompanyAddress() != null && supplierSearch.getCompanyAddress().compareTo("") != 0){
            criteria.andCompanyAddressLike("%" + supplierSearch.getCompanyAddress() + "%");
        }
        if(supplierSearch.getDeliveryAddress() != null && supplierSearch.getDeliveryAddress().compareTo("") != 0){
            criteria.andDeliveryAddressLike("%" + supplierSearch.getDeliveryAddress() + "%");
        }
        /*
        if(supplierSearch.getInvoiceAddress() != null && supplierSearch.getInvoiceAddress().compareTo("") != 0){
            criteria.andInvoiceAddressLike("%" + supplierSearch.getInvoiceAddress() + "%");
        }
        */
        if(supplierSearch.getAlipayAccount() != null && supplierSearch.getAlipayAccount().compareTo("") != 0){
            criteria.andAlipayAccountLike(supplierSearch.getAlipayAccount());
        }
        if(supplierSearch.getWepayAccount() != null && supplierSearch.getWepayAccount().compareTo("") != 0){
            criteria.andWepayAccountLike("%" + supplierSearch.getWepayAccount() + "%");
        }
        if(supplierSearch.getState() != null){
            if( supplierSearch.getState() == 100){
                criteria.andStateGreaterThan(1);
            }else{
                criteria.andStateEqualTo(supplierSearch.getState());
            }
            
        }
        if(supplierSearch.getComments() != null && supplierSearch.getComments().compareTo("") != 0){
            criteria.andCommentsLike("%" + supplierSearch.getComments() + "%");
        }
        supplierExample.setOrderByClause("id desc");
        PageHelper.startPage(supplierSearch.getPageNum(),supplierSearch.getPageSize());
        List<Supplier> supplierList = supplierMapper.selectByExample(supplierExample);
        SupplierSearchResult supplierSearchResult = new SupplierSearchResult();
        supplierSearchResult.setPageNum(supplierSearch.getPageNum());
        supplierSearchResult.setPageSize(supplierSearch.getPageSize());
        supplierSearchResult.setSupplierList(supplierList);
        int total = (int) supplierMapper.countByExample(supplierExample);
        supplierSearchResult.setTotal(total);
        return supplierSearchResult;
    }
    
    
    
    public int addSupplier(Supplier supplier) {
        return supplierMapper.insertSelective(supplier);
    }
    
    
    public int getAllCountByState(Integer state) {
        SupplierExample supplierExample = new SupplierExample();
        if(state == 100){
            supplierExample.createCriteria().andIdGreaterThan(0L).andStateGreaterThan(0);
        } else if(state == 200){
            supplierExample.createCriteria().andIdGreaterThan(0L).andStateGreaterThanOrEqualTo(0);
        }else{
            supplierExample.createCriteria().andIdGreaterThan(0L).andStateEqualTo(state);
        }
        //supplierExample.createCriteria().andStateEqualTo(state);
        return (int) supplierMapper.countByExample(supplierExample);
    }
    
    
    public int updateSupplierById(Supplier supplier){
        return supplierMapper.updateByPrimaryKeySelective(supplier);
    }
    
    public int changeSupplierStateById(Long id,int state){
        Supplier supplier = new Supplier();
        supplier.setId(id);
        supplier.setState(state);
        return supplierMapper.updateByPrimaryKeySelective(supplier);
    }
    
    
}
