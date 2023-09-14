/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/8/21
 * Time: 19:29
 **/
package com.aks.management.utils.invoiceBase;

import com.aks.management.bean.InvoiceBase;
import lombok.Data;

@Data
public class InvoiceSearch extends InvoiceBase {
    
    private Integer pageNum;
    private Integer pageSize;
    private String createTimeStart;
    private String createTimeEnd;
    private String updateTimeStart;
    private String updateTimeEnd;
    private Integer searchType;
    
}
