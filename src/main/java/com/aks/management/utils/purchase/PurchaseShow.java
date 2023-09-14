/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/9/13
 * Time: 20:08
 **/
package com.aks.management.utils.purchase;

import com.aks.management.bean.Purchase;
import lombok.Data;

@Data
public class PurchaseShow extends Purchase {
    
    private String contractDeliveryDateStr;
    private String expectDeliveryDateStr;
    private String realDeliveryDateStr;
    private String depositBackDateStr;
    private String realDepositBackDateStr;
    private String invoiceDateStr;
    private String receiveInvoiceDateStr;
    private String createTimeStr;
    private String updateTimeStr;
}
