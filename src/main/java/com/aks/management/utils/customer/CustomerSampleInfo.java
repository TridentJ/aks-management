/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/6/7
 * Time: 19:52
 **/
package com.aks.management.utils.customer;

import lombok.Data;

@Data
public class CustomerSampleInfo {

    private Long id;
    private String customerName;
    private String customerNumber;
    private String address;
    
    private String telephone;
    private Integer orderQuantity;
    private Integer state;
    private String createTime;
    
    
    
    
}
