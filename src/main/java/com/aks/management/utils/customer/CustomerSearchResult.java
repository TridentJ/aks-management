/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/9/1
 * Time: 18:24
 **/
package com.aks.management.utils.customer;

import com.aks.management.bean.Customer;
import com.aks.management.bean.Supplier;
import lombok.Data;

import java.util.List;

@Data
public class CustomerSearchResult {
    
    private Integer pageNum;
    private Integer pageSize;
    private Integer total;
    
    List<Customer> customerList;
}
