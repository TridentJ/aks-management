/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/6/7
 * Time: 19:52
 **/
package com.aks.management.utils.supplier;

import lombok.Data;

@Data
public class SupplierSampleInfo {

    private Long id;
    private String supplierName;
    private String supplierNumber;
    private String address;
    
    private String telephone;
    private Integer orderQuantity;
    private Integer state;
    private String createTime;
    
    
    
    
}
