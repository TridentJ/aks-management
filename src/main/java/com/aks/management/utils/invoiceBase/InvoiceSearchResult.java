/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/9/3
 * Time: 15:49
 **/
package com.aks.management.utils.invoiceBase;

import com.aks.management.bean.InvoiceBase;
import lombok.Data;

import java.util.List;

@Data
public class InvoiceSearchResult {
    
    private Integer pageNum;
    private Integer pageSize;
    private Integer total;
    
    private List<InvoiceBase> invoiceBaseList;
    
}
