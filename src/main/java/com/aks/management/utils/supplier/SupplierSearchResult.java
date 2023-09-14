/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/9/1
 * Time: 18:24
 **/
package com.aks.management.utils.supplier;

import com.aks.management.bean.Supplier;
import lombok.Data;

import java.util.List;
@Data
public class SupplierSearchResult {
    
    private Integer pageNum;
    private Integer pageSize;
    private Integer total;
    
    List<Supplier> supplierList;
}
