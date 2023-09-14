/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/6/20
 * Time: 20:31
 **/
package com.aks.management.utils.supplier;

import com.aks.management.bean.SupplierContacts;
import lombok.Data;

@Data
public class SupplierContactsShow  extends SupplierContacts {
    
    private String createTimeStr;
    private String updateTimeStr;
    private String supplierName;
    
}
