/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/8/21
 * Time: 19:29
 **/
package com.aks.management.utils.supplier;

import com.aks.management.bean.SupplierContacts;
import lombok.Data;

@Data
public class SupplierContactsSearch extends SupplierContacts {
    
    private Integer pageNum;
    private Integer pageSize;
    private String createTimeStart;
    private String createTimeEnd;
    private String updateTimeStart;
    private String updateTimeEnd;
}
