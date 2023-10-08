/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/10/8
 * Time: 11:03
 **/
package com.aks.management.utils.cargo;

import lombok.Data;

@Data
public class CargoSample {
    
    private Long id;
    private String cargoName;
    private String description;
    private String brand;
    private String cargoType;
    
}
