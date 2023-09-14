/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/6/20
 * Time: 19:44
 **/
package com.aks.management.utils.customer;

import com.aks.management.bean.Customer;
import com.aks.management.bean.Supplier;
import lombok.Data;

@Data
public class CustomerShow extends Customer {
    /*
    private Long id;
    private String supplierName;
    private String supplierNumber;
    private String telephone;
    private String phone;
    private String fax;
    private String companyAddress;
    private String deliveryAddress;
    private String alipayAccount;
    private String wepayAccount;
    private Integer state;
    private String createTime;
    private String updateTime;
    private String comments;
    */
    private String createTimeStr;
    private String updateTimeStr;
    
}
