/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/9/12
 * Time: 19:29
 **/
package com.aks.management.utils.purchase;

import lombok.Data;

@Data
public class PurchaseSampleList {

    private Long id;
    private String purchaseName;
    private String supplierName;
    private String purchaseSelfId;
    private String purchasePeerId;
    private String signTime;
    private String contractDeliverDate;
    private Double priceIncludingTax;
    private Double deposit;
    private Integer depositFlag;
    private Integer purchaseState;
    
}
