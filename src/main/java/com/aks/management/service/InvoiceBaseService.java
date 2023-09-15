/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/6/20
 * Time: 19:52
 **/
package com.aks.management.service;

import com.aks.management.bean.InvoiceBase;
import com.aks.management.bean.InvoiceBaseExample;
import com.aks.management.dao.InvoiceBaseMapper;
import com.aks.management.utils.AjaxResponse;
import com.aks.management.utils.invoiceBase.InvoiceSearch;
import com.aks.management.utils.invoiceBase.InvoiceSearchResult;
import com.github.pagehelper.PageHelper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class InvoiceBaseService {
    
    @Resource
    private InvoiceBaseMapper invoiceBaseMapper;
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    public List<InvoiceBase> getAllInvoiceBase(Integer pageNum,Integer pageSize){
        InvoiceBaseExample invoiceBaseExample = new InvoiceBaseExample();
        invoiceBaseExample.createCriteria().andIdGreaterThan(0L);
        invoiceBaseExample.setOrderByClause("id desc");
        PageHelper.startPage(pageNum,pageSize);
        return invoiceBaseMapper.selectByExample(invoiceBaseExample);
    }
    
    public List<InvoiceBase> getInvoiceBaseByState(Integer state, Integer pageNum,Integer pageSize){
        InvoiceBaseExample invoiceBaseExample = new InvoiceBaseExample();
        invoiceBaseExample.createCriteria().andIdGreaterThan(0L).andStateEqualTo(state);
        invoiceBaseExample.setOrderByClause("id desc");
        PageHelper.startPage(pageNum,pageSize);
        return invoiceBaseMapper.selectByExample(invoiceBaseExample);
    }
    
    public InvoiceBase getInvoiceBaseById(Long id){
        return invoiceBaseMapper.selectByPrimaryKey(id);
    }
    
    
    public int checkInvoiceBaseIsExists(Long id){
        InvoiceBase invoiceBase = invoiceBaseMapper.selectByPrimaryKey(id);
        if(invoiceBase == null){
            return 0;
        }
        return 1;
    }
    
    public List<InvoiceBase> getInvoiceBaseBySupplierId(Long supplierId){
        InvoiceBaseExample invoiceBaseExample = new InvoiceBaseExample();
        invoiceBaseExample.createCriteria().andSupplierIdEqualTo(supplierId).andStateGreaterThan(0);
        invoiceBaseExample.setOrderByClause("id desc");
        return invoiceBaseMapper.selectByExample(invoiceBaseExample);
    }
    
    public List<InvoiceBase> getInvoiceBaseByCustomerId(Long customerId){
        InvoiceBaseExample invoiceBaseExample = new InvoiceBaseExample();
        invoiceBaseExample.createCriteria().andCustomerIdEqualTo(customerId).andStateGreaterThan(0);
        invoiceBaseExample.setOrderByClause("id desc");
        return invoiceBaseMapper.selectByExample(invoiceBaseExample);
    }
    
    public int addInvoiceBase(InvoiceBase invoiceBase){
        return invoiceBaseMapper.insertSelective(invoiceBase);
        
    }
    
    public int updateInvoiceBase(InvoiceBase invoiceBase){
        return invoiceBaseMapper.updateByPrimaryKeySelective(invoiceBase);
    }
    
    public int changeInvoiceBaseStateById(Long id,int state){
        InvoiceBase invoiceBase = new InvoiceBase();
        invoiceBase.setId(id);
        invoiceBase.setState(state);
        return invoiceBaseMapper.updateByPrimaryKeySelective(invoiceBase);
    }
    
    public InvoiceSearchResult searchInvoiceBase(InvoiceSearch invoiceSearch){
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        InvoiceBaseExample invoiceBaseExample = new InvoiceBaseExample();
        InvoiceBaseExample.Criteria criteria = invoiceBaseExample.createCriteria();
        if(invoiceSearch.getSearchType() == 1){
            criteria.andSupplierIdGreaterThan(0L);
        }else{
            criteria.andCustomerIdGreaterThan(0L);
        }
        if(invoiceSearch.getCreateTimeStart() != null && invoiceSearch.getCreateTimeEnd() != null){
            if(invoiceSearch.getCreateTimeStart().compareTo(invoiceSearch.getCreateTimeEnd()) < 0){
                try {
                    LocalDateTime createTimeStart = LocalDateTime.parse(invoiceSearch.getCreateTimeStart() + " 00:00:00",DATE_TIME_FORMATTER);
                    LocalDateTime createTimeEnd = LocalDateTime.parse(invoiceSearch.getCreateTimeEnd() + " 23:59:59",DATE_TIME_FORMATTER);
                    criteria.andCreateTimeBetween(createTimeStart,createTimeEnd);
                } catch (Exception e) {
                    return null;
                }
            
            }
        }
        if(invoiceSearch.getUpdateTimeStart() != null && invoiceSearch.getUpdateTimeEnd() != null){
            if(invoiceSearch.getUpdateTimeStart().compareTo(invoiceSearch.getUpdateTimeEnd()) < 0){
                try {
                    LocalDateTime updateTimeStart = LocalDateTime.parse(invoiceSearch.getUpdateTimeStart() + " 00:00:00",DATE_TIME_FORMATTER);
                    LocalDateTime updateTimeEnd = LocalDateTime.parse(invoiceSearch.getCreateTimeEnd() + " 23:59:59",DATE_TIME_FORMATTER);
                    criteria.andUpdateTimeBetween(updateTimeStart,updateTimeEnd);
                } catch (Exception e) {
                    return null;
                }
            }
        }
        if(invoiceSearch.getCompany() != null && invoiceSearch.getCompany().compareTo("") != 0){
            criteria.andCompanyLike("%" + invoiceSearch.getCompany() + "%");
        }
        if(invoiceSearch.getBank() != null && invoiceSearch.getBank().compareTo("") != 0){
            criteria.andBankLike("%" + invoiceSearch.getBank() + "%");
        }
        if(invoiceSearch.getBankAccount() != null && invoiceSearch.getBankAccount().compareTo("") != 0){
            criteria.andBankAccountLike("%" + invoiceSearch.getBankAccount() + "%");
        }
        if(invoiceSearch.getTaxAccount() != null && invoiceSearch.getTaxAccount().compareTo("") != 0){
            criteria.andTaxAccountLike("%" + invoiceSearch.getTaxAccount() + "%");
        }
        if(invoiceSearch.getAddress() != null && invoiceSearch.getAddress().compareTo("") != 0){
            criteria.andAddressLike("%" + invoiceSearch.getAddress() + "%");
        }
        if(invoiceSearch.getPhone() != null && invoiceSearch.getPhone().compareTo("") != 0){
            criteria.andPhoneLike("%" + invoiceSearch.getPhone() + "%");
        }
        if(invoiceSearch.getState() != null){
            if( invoiceSearch.getState() == 100){
                criteria.andStateGreaterThan(1);
            }else{
                criteria.andStateEqualTo(invoiceSearch.getState());
            }
        
        }
        if(invoiceSearch.getComments() != null && invoiceSearch.getComments().compareTo("") != 0){
            criteria.andCommentsLike("%" + invoiceSearch.getComments() + "%");
        }
        PageHelper.startPage(invoiceSearch.getPageNum(),invoiceSearch.getPageSize());
        List<InvoiceBase> invoiceBaseList = invoiceBaseMapper.selectByExample(invoiceBaseExample);
        InvoiceSearchResult invoiceSearchResult = new InvoiceSearchResult();
        invoiceSearchResult.setInvoiceBaseList(invoiceBaseList);
        invoiceSearchResult.setPageNum(invoiceSearch.getPageNum());
        invoiceSearchResult.setPageSize(invoiceSearch.getPageSize());
        int total = (int) invoiceBaseMapper.countByExample(invoiceBaseExample);
        invoiceSearchResult.setTotal(total);
        
        return invoiceSearchResult;
    }
    
}
