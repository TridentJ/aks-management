/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/10/10
 * Time: 18:49
 **/
package com.aks.management.utils.purchaseCargo;

import com.aks.management.bean.PurchaseCargo;
import lombok.Data;

@Data
public class PurchaseCargoFull extends PurchaseCargo {
    
    private String cargoName;
    private String brand;
    private String description;
    private String cargoType;
    
}
