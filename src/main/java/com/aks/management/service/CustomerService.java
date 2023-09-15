/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/9/5
 * Time: 20:21
 **/
package com.aks.management.service;

import com.aks.management.bean.Customer;
import com.aks.management.bean.CustomerExample;
import com.aks.management.dao.CustomerMapper;
import com.aks.management.utils.customer.CustomerSearch;
import com.aks.management.utils.customer.CustomerSearchResult;
import com.github.pagehelper.PageHelper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import javax.swing.text.DateFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class CustomerService {
    
    @Resource
    private CustomerMapper customerMapper;
    
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    public Customer getCustomerById(Long id) {
        
        return customerMapper.selectByPrimaryKey(id);
    }
    
    public int checkCustomerIsExists(Long id){
        Customer customer = customerMapper.selectByPrimaryKey(id);
        if(customer == null){
            return 0;
        }
        return 1;
    }
    
    public List<Customer> getAllCustomer(int pageNum, int pageSize) {
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andIdGreaterThan(0L);
        customerExample.setOrderByClause("id desc");
        PageHelper.startPage(pageNum,pageSize);
        return customerMapper.selectByExample(customerExample);
    }
    
    public List<Customer> getCustomerByState(int state, int pageNum, int pageSize){
        CustomerExample customerExample = new CustomerExample();
        if(state == 100){
            customerExample.createCriteria().andIdGreaterThan(0L).andStateGreaterThan(0);
        } else if(state == 200){
            customerExample.createCriteria().andIdGreaterThan(0L).andStateGreaterThanOrEqualTo(0);
        }else{
            customerExample.createCriteria().andIdGreaterThan(0L).andStateEqualTo(state);
        }
        customerExample.setOrderByClause("id desc");
        PageHelper.startPage(pageNum,pageSize);
        return customerMapper.selectByExample(customerExample);
    }
    
    
    
    
    public CustomerSearchResult searchCustomer(CustomerSearch customerSearch) {
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        CustomerExample customerExample = new CustomerExample();
        CustomerExample.Criteria criteria = customerExample.createCriteria();
        if(customerSearch.getCreateTimeStart() != null && customerSearch.getCreateTimeEnd() != null){
            if(customerSearch.getCreateTimeStart().compareTo(customerSearch.getCreateTimeEnd()) < 0){
                try {
                    //Date createTimeStart = sdf.parse(customerSearch.getCreateTimeStart() + " 00:00:00");
                    //Date createTimeEnd = sdf.parse(customerSearch.getCreateTimeEnd() + "23:59:59");
                    LocalDateTime createTimeStart = LocalDateTime.parse(customerSearch.getCreateTimeStart() + " 00:00:00",DATE_TIME_FORMATTER);
                    LocalDateTime createTimeEnd = LocalDateTime.parse(customerSearch.getCreateTimeEnd() + " 23:59:59",DATE_TIME_FORMATTER);
                    criteria.andCreateTimeBetween(createTimeStart,createTimeEnd);
                } catch (Exception e) {
                    return null;
                }
                
            }
        }
        if(customerSearch.getUpdateTimeStart() != null && customerSearch.getUpdateTimeEnd() != null){
            if(customerSearch.getUpdateTimeStart().compareTo(customerSearch.getUpdateTimeEnd()) < 0){
                try {
                    LocalDateTime updateTimeStart = LocalDateTime.parse(customerSearch.getUpdateTimeStart() + " 00:00:00", DATE_TIME_FORMATTER);
                    LocalDateTime updateTimeEnd = LocalDateTime.parse(customerSearch.getCreateTimeEnd() + "23:59:59", DATE_TIME_FORMATTER);
                    criteria.andUpdateTimeBetween(updateTimeStart,updateTimeEnd);
                } catch (Exception e) {
                    return null;
                }
            }
        }
        if(customerSearch.getCustomerName() != null && customerSearch.getCustomerName().compareTo("") != 0){
            criteria.andCustomerNameLike("%" + customerSearch.getCustomerName() + "%");
        }
        if(customerSearch.getCustomerNumber() != null && customerSearch.getCustomerNumber().compareTo("") != 0){
            criteria.andCustomerNumberLike("%" + customerSearch.getCustomerNumber() + "%");
        }
        if(customerSearch.getTelephone() != null && customerSearch.getTelephone().compareTo("") != 0){
            criteria.andTelephoneLike("%" + customerSearch.getTelephone() + "%");
        }
        if(customerSearch.getPhone() != null && customerSearch.getPhone().compareTo("") != 0){
            criteria.andPhoneLike("%" + customerSearch.getPhone() + "%");
        }
        if(customerSearch.getFax() != null && customerSearch.getFax().compareTo("") != 0){
            criteria.andFaxLike("%" + customerSearch.getFax() + "%");
        }
        if(customerSearch.getAddress() != null && customerSearch.getAddress().compareTo("") != 0){
            criteria.andAddressLike("%" + customerSearch.getAddress() + "%");
        }
        if(customerSearch.getFactoryAddress() != null && customerSearch.getFactoryAddress().compareTo("") != 0){
            criteria.andFactoryAddressLike("%" + customerSearch.getFactoryAddress() + "%");
        }
        if(customerSearch.getAlipayAccount() != null && customerSearch.getAlipayAccount().compareTo("") != 0){
            criteria.andAlipayAccountLike(customerSearch.getAlipayAccount());
        }
        if(customerSearch.getWepayAccount() != null && customerSearch.getWepayAccount().compareTo("") != 0){
            criteria.andWepayAccountLike("%" + customerSearch.getWepayAccount() + "%");
        }
        if(customerSearch.getState() != null){
            if( customerSearch.getState() == 100){
                criteria.andStateGreaterThan(1);
            }else{
                criteria.andStateEqualTo(customerSearch.getState());
            }
            
        }
        if(customerSearch.getComments() != null && customerSearch.getComments().compareTo("") != 0){
            criteria.andCommentsLike("%" + customerSearch.getComments() + "%");
        }
        PageHelper.startPage(customerSearch.getPageNum(),customerSearch.getPageSize());
        List<Customer> customerList = customerMapper.selectByExample(customerExample);
        CustomerSearchResult customerSearchResult = new CustomerSearchResult();
        customerSearchResult.setPageNum(customerSearch.getPageNum());
        customerSearchResult.setPageSize(customerSearch.getPageSize());
        customerSearchResult.setCustomerList(customerList);
        int total = (int) customerMapper.countByExample(customerExample);
        customerSearchResult.setTotal(total);
        return customerSearchResult;
    }
    
    
    
    public int addCustomer(Customer customer) {
        return customerMapper.insertSelective(customer);
    }
    
    public int editCustomer(Customer customer) {
        return customerMapper.updateByPrimaryKeySelective(customer);
    }
    
    public int getAllCountByState(Integer state) {
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andStateEqualTo(state);
        return (int) customerMapper.countByExample(customerExample);
    }
    
    
    public int updateCustomerById(Customer customer){
        return customerMapper.updateByPrimaryKeySelective(customer);
    }
    
    public int changeCustomerStateById(Long id,int state){
        Customer customer = new Customer();
        customer.setId(id);
        customer.setState(state);
        return customerMapper.updateByPrimaryKeySelective(customer);
    }
    
}
