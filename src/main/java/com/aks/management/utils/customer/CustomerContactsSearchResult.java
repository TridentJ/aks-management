/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/9/3
 * Time: 16:28
 **/
package com.aks.management.utils.customer;

import com.aks.management.bean.CustomerContacts;
import com.aks.management.bean.SupplierContacts;
import lombok.Data;

import java.util.List;

@Data
public class CustomerContactsSearchResult {
    
    private Integer pageNum;
    private Integer pageSize;
    private Integer total;
    
    private List<CustomerContacts> customerContactsList;
    
    
}
