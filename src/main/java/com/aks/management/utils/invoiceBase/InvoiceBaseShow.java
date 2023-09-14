/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/6/20
 * Time: 20:04
 **/
package com.aks.management.utils.invoiceBase;

import com.aks.management.bean.InvoiceBase;
import lombok.Data;

@Data
public class InvoiceBaseShow extends InvoiceBase {
    
    private String createTimeStr;
    private String updateTimeStr;
    private String supplierName;
    private String customerName;
    
}
