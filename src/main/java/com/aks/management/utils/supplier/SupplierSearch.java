/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/8/21
 * Time: 19:28
 **/
package com.aks.management.utils.supplier;

import com.aks.management.bean.Supplier;
import lombok.Data;

@Data
public class SupplierSearch extends Supplier {
    
    private Integer pageNum;
    private Integer pageSize;
    private String createTimeStart;
    private String createTimeEnd;
    private String updateTimeStart;
    private String updateTimeEnd;
    
    
}
