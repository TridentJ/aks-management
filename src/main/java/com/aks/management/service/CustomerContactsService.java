/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/6/20
 * Time: 20:22
 **/
package com.aks.management.service;

import com.aks.management.bean.CustomerContacts;
import com.aks.management.bean.CustomerContactsExample;
import com.aks.management.dao.CustomerContactsMapper;
import com.aks.management.utils.customer.CustomerContactsSearch;
import com.aks.management.utils.customer.CustomerContactsSearchResult;
import com.github.pagehelper.PageHelper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class CustomerContactsService {
    
    @Resource
    private CustomerContactsMapper customerContactsMapper;
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    public CustomerContacts getCustomerContactsById(Long id){
        return customerContactsMapper.selectByPrimaryKey(id);
    }
    
    public int checkCustomerContactsIsExists(Long id){
        CustomerContacts customerContacts = customerContactsMapper.selectByPrimaryKey(id);
        if(customerContacts == null){
            return 0;
        }
        return 1;
    }
    
    public List<CustomerContacts> getCustomerContactsByCustomerId(Long customerId){
        CustomerContactsExample customerContactsExample = new CustomerContactsExample();
        customerContactsExample.createCriteria().andCustomerIdEqualTo(customerId).andStateGreaterThan(0);
        customerContactsExample.setOrderByClause("id desc");
        return customerContactsMapper.selectByExample(customerContactsExample);
    }
    
    public int addCustomerContacts(CustomerContacts customerContacts){
        return customerContactsMapper.insertSelective(customerContacts);
        
    }
    
    public int updateCustomerContactsById(CustomerContacts customerContacts){
        return customerContactsMapper.updateByPrimaryKeySelective(customerContacts);
    }
    
    public int changeCustomerContactsStateById(Long id,int state){
        CustomerContacts customerContacts = new CustomerContacts();
        customerContacts.setId(id);
        customerContacts.setState(state);
        return customerContactsMapper.updateByPrimaryKeySelective(customerContacts);
    }
    
    public CustomerContactsSearchResult searchCustomerContacts(@RequestBody CustomerContactsSearch customerContactsSearch){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        CustomerContactsExample customerContactsExample = new CustomerContactsExample();
        CustomerContactsExample.Criteria criteria = customerContactsExample.createCriteria();
        if(customerContactsSearch.getCreateTimeStart() != null && customerContactsSearch.getCreateTimeEnd() != null){
            if(customerContactsSearch.getCreateTimeStart().compareTo(customerContactsSearch.getCreateTimeEnd()) < 0){
                try {
                    LocalDateTime createTimeStart = LocalDateTime.parse(customerContactsSearch.getCreateTimeStart() + " 00:00:00",DATE_TIME_FORMATTER);
                    LocalDateTime createTimeEnd = LocalDateTime.parse(customerContactsSearch.getCreateTimeEnd() + " 23:59:59",DATE_TIME_FORMATTER);
                    criteria.andCreateTimeBetween(createTimeStart,createTimeEnd);
                } catch (Exception e) {
                    return null;
                }
            
            }
        }
        if(customerContactsSearch.getUpdateTimeStart() != null && customerContactsSearch.getUpdateTimeEnd() != null){
            if(customerContactsSearch.getUpdateTimeStart().compareTo(customerContactsSearch.getUpdateTimeEnd()) < 0){
                try {
                    LocalDateTime updateTimeStart = LocalDateTime.parse(customerContactsSearch.getUpdateTimeStart() + " 00:00:00",DATE_TIME_FORMATTER);
                    LocalDateTime updateTimeEnd = LocalDateTime.parse(customerContactsSearch.getCreateTimeEnd() + " 23:59:59",DATE_TIME_FORMATTER);
                    criteria.andUpdateTimeBetween(updateTimeStart,updateTimeEnd);
                } catch (Exception e) {
                    return null;
                }
            }
        }
        if(customerContactsSearch.getCcName() != null && customerContactsSearch.getCcName().compareTo("") != 0){
            criteria.andCcNameLike("%" + customerContactsSearch.getCcName() + "%");
        }
        if(customerContactsSearch.getDepartment() != null && customerContactsSearch.getDepartment().compareTo("") != 0){
            criteria.andDepartmentLike("%" + customerContactsSearch.getDepartment() + "%");
        }
        if(customerContactsSearch.getJob() != null && customerContactsSearch.getJob().compareTo("") != 0){
            criteria.andJobLike("%" + customerContactsSearch.getJob() + "%");
        }
        if(customerContactsSearch.getTelephone() != null && customerContactsSearch.getTelephone().compareTo("") != 0){
            criteria.andTelephoneLike("%" + customerContactsSearch.getTelephone() + "%");
        }
        if(customerContactsSearch.getPhone() != null && customerContactsSearch.getPhone().compareTo("") != 0){
            criteria.andPhoneLike("%" + customerContactsSearch.getPhone() + "%");
        }
        if(customerContactsSearch.getMail() != null && customerContactsSearch.getPhone().compareTo("") != 0){
            criteria.andMailLike("%" + customerContactsSearch.getMail() + "%");
        }
        if(customerContactsSearch.getBaseLocation() != null && customerContactsSearch.getBaseLocation().compareTo("") != 0){
            criteria.andBaseLocationLike("%" + customerContactsSearch.getBaseLocation() + "%");
        }
        if(customerContactsSearch.getQq() != null && customerContactsSearch.getQq().compareTo("") != 0){
            criteria.andQqLike("%" + customerContactsSearch.getQq() + "%");
        }
        if(customerContactsSearch.getWechat() != null && customerContactsSearch.getWechat().compareTo("") != 0){
            criteria.andWechatLike("%" + customerContactsSearch.getWechat() + "%");
        }
        if(customerContactsSearch.getState() != null){
            if( customerContactsSearch.getState() == 100){
                criteria.andStateGreaterThan(1);
            }else{
                criteria.andStateEqualTo(customerContactsSearch.getState());
            }
        
        }
        if(customerContactsSearch.getComments() != null && customerContactsSearch.getComments().compareTo("") != 0){
            criteria.andCommentsLike("%" + customerContactsSearch.getComments() + "%");
        }
        PageHelper.startPage(customerContactsSearch.getPageNum(),customerContactsSearch.getPageSize());
        List<CustomerContacts> customerContactsList = customerContactsMapper.selectByExample(customerContactsExample);
        CustomerContactsSearchResult customerContactsSearchResult = new CustomerContactsSearchResult();
        customerContactsSearchResult.setCustomerContactsList(customerContactsList);
        customerContactsSearchResult.setPageNum(customerContactsSearch.getPageNum());
        customerContactsSearchResult.setPageSize(customerContactsSearch.getPageSize());
        int total = (int) customerContactsMapper.countByExample(customerContactsExample);
        customerContactsSearchResult.setTotal(total);
    
        return customerContactsSearchResult;
    }
    
    
}
