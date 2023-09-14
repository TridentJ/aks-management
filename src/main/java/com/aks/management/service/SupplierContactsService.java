/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/6/20
 * Time: 20:22
 **/
package com.aks.management.service;

import com.aks.management.bean.InvoiceBase;
import com.aks.management.bean.SupplierContactsExample;
import com.aks.management.bean.SupplierContacts;
import com.aks.management.bean.SupplierContactsExample;
import com.aks.management.dao.SupplierContactsMapper;
import com.aks.management.utils.AjaxResponseList;
import com.aks.management.utils.invoiceBase.InvoiceSearchResult;
import com.aks.management.utils.supplier.SupplierContactsSearch;
import com.aks.management.utils.supplier.SupplierContactsSearchResult;
import com.github.pagehelper.PageHelper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class SupplierContactsService {
    
    @Resource
    private SupplierContactsMapper supplierContactsMapper;
    
    public SupplierContacts getSupplierContactsById(Long id){
        return supplierContactsMapper.selectByPrimaryKey(id);
    }
    
    public int checkSupplierContactsIsExists(Long id){
        SupplierContacts supplierContacts = supplierContactsMapper.selectByPrimaryKey(id);
        if(supplierContacts == null){
            return 0;
        }
        return 1;
    }
    
    public List<SupplierContacts> getSupplierContactsBySupplierId(Long supplierId){
        SupplierContactsExample supplierContactsExample = new SupplierContactsExample();
        supplierContactsExample.createCriteria().andSupplierIdEqualTo(supplierId).andStateGreaterThan(0);
        supplierContactsExample.setOrderByClause("id desc");
        return supplierContactsMapper.selectByExample(supplierContactsExample);
    }
    
    public int addSupplierContacts(SupplierContacts supplierContacts){
        return supplierContactsMapper.insertSelective(supplierContacts);
        
    }
    
    public int updateSupplierContactsById(SupplierContacts supplierContacts){
        return supplierContactsMapper.updateByPrimaryKeySelective(supplierContacts);
    }
    
    public int changeSupplierContactsStateById(Long id,int state){
        SupplierContacts supplierContacts = new SupplierContacts();
        supplierContacts.setId(id);
        supplierContacts.setState(state);
        return supplierContactsMapper.updateByPrimaryKeySelective(supplierContacts);
    }
    
    public SupplierContactsSearchResult searchSupplierContacts(@RequestBody SupplierContactsSearch supplierContactsSearch){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SupplierContactsExample supplierContactsExample = new SupplierContactsExample();
        SupplierContactsExample.Criteria criteria = supplierContactsExample.createCriteria();
        /*if(supplierContactsSearch.getCreateTimeStart() != null && supplierContactsSearch.getCreateTimeEnd() != null){
            if(supplierContactsSearch.getCreateTimeStart().compareTo(supplierContactsSearch.getCreateTimeEnd()) < 0){
                try {
                    Date createTimeStart = sdf.parse(supplierContactsSearch.getCreateTimeStart() + " 00:00:00");
                    Date createTimeEnd = sdf.parse(supplierContactsSearch.getCreateTimeEnd() + "23:59:59");
                    criteria.andCreateTimeBetween(createTimeStart,createTimeEnd);
                } catch (ParseException e) {
                    return null;
                }
            
            }
        }
        if(supplierContactsSearch.getUpdateTimeStart() != null && supplierContactsSearch.getUpdateTimeEnd() != null){
            if(supplierContactsSearch.getUpdateTimeStart().compareTo(supplierContactsSearch.getUpdateTimeEnd()) < 0){
                try {
                    Date updateTimeStart = sdf.parse(supplierContactsSearch.getUpdateTimeStart() + " 00:00:00");
                    Date updateTimeEnd = sdf.parse(supplierContactsSearch.getCreateTimeEnd() + "23:59:59");
                    criteria.andUpdateTimeBetween(updateTimeStart,updateTimeEnd);
                } catch (ParseException e) {
                    return null;
                }
            }
        }*/
        if(supplierContactsSearch.getScName() != null && supplierContactsSearch.getScName().compareTo("") != 0){
            criteria.andScNameLike("%" + supplierContactsSearch.getScName() + "%");
        }
        if(supplierContactsSearch.getDepartment() != null && supplierContactsSearch.getDepartment().compareTo("") != 0){
            criteria.andDepartmentLike("%" + supplierContactsSearch.getDepartment() + "%");
        }
        if(supplierContactsSearch.getJob() != null && supplierContactsSearch.getJob().compareTo("") != 0){
            criteria.andJobLike("%" + supplierContactsSearch.getJob() + "%");
        }
        if(supplierContactsSearch.getTelephone() != null && supplierContactsSearch.getTelephone().compareTo("") != 0){
            criteria.andTelephoneLike("%" + supplierContactsSearch.getTelephone() + "%");
        }
        if(supplierContactsSearch.getPhone() != null && supplierContactsSearch.getPhone().compareTo("") != 0){
            criteria.andPhoneLike("%" + supplierContactsSearch.getPhone() + "%");
        }
        if(supplierContactsSearch.getMail() != null && supplierContactsSearch.getPhone().compareTo("") != 0){
            criteria.andMailLike("%" + supplierContactsSearch.getMail() + "%");
        }
        if(supplierContactsSearch.getBaseLocation() != null && supplierContactsSearch.getBaseLocation().compareTo("") != 0){
            criteria.andBaseLocationLike("%" + supplierContactsSearch.getBaseLocation() + "%");
        }
        if(supplierContactsSearch.getQq() != null && supplierContactsSearch.getQq().compareTo("") != 0){
            criteria.andQqLike("%" + supplierContactsSearch.getQq() + "%");
        }
        if(supplierContactsSearch.getWechat() != null && supplierContactsSearch.getWechat().compareTo("") != 0){
            criteria.andWechatLike("%" + supplierContactsSearch.getWechat() + "%");
        }
        if(supplierContactsSearch.getState() != null){
            if( supplierContactsSearch.getState() == 100){
                criteria.andStateGreaterThan(1);
            }else{
                criteria.andStateEqualTo(supplierContactsSearch.getState());
            }
        
        }
        if(supplierContactsSearch.getComments() != null && supplierContactsSearch.getComments().compareTo("") != 0){
            criteria.andCommentsLike("%" + supplierContactsSearch.getComments() + "%");
        }
        PageHelper.startPage(supplierContactsSearch.getPageNum(),supplierContactsSearch.getPageSize());
        List<SupplierContacts> supplierContactsList = supplierContactsMapper.selectByExample(supplierContactsExample);
        SupplierContactsSearchResult supplierContactsSearchResult = new SupplierContactsSearchResult();
        supplierContactsSearchResult.setSupplierContactsList(supplierContactsList);
        supplierContactsSearchResult.setPageNum(supplierContactsSearch.getPageNum());
        supplierContactsSearchResult.setPageSize(supplierContactsSearch.getPageSize());
        int total = (int) supplierContactsMapper.countByExample(supplierContactsExample);
        supplierContactsSearchResult.setTotal(total);
    
        return supplierContactsSearchResult;
    }
    
    
}
