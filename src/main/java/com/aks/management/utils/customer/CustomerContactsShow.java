/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/6/20
 * Time: 20:31
 **/
package com.aks.management.utils.customer;

import com.aks.management.bean.CustomerContacts;
import com.aks.management.bean.SupplierContacts;
import lombok.Data;

@Data
public class CustomerContactsShow extends CustomerContacts {
    
    private String createTimeStr;
    private String updateTimeStr;
    private String customerName;
    
}
