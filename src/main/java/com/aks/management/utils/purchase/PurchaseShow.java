/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/9/18
 * Time: 19:24
 **/
package com.aks.management.utils.purchase;

import com.aks.management.bean.Purchase;
import lombok.Data;

@Data
public class PurchaseShow extends Purchase {
    
    private String contactsName;
    private String salesmanName;
    private String supplierName;
    private String operatorName;
    
    
}
