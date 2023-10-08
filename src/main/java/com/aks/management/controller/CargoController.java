/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/10/8
 * Time: 10:56
 **/
package com.aks.management.controller;

import com.aks.management.bean.Cargo;
import com.aks.management.service.CargoService;
import com.aks.management.utils.AjaxResponseList;
import com.aks.management.utils.cargo.CargoSample;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Tag(name="货物接口",description = "货物的接口清单")
@RequestMapping(value="/api/cargo")
public class CargoController {
    
    @Resource
    private CargoService cargoService;
    
    
    @Operation(
            summary = "货物基础信息清单",
            description = "货物基础，用于列表展示",
            parameters = {
                    @Parameter(name="pageNum", description = "页码",required = true),
                    @Parameter(name="pageSize", description = "页数",required = true)
            }
    )
    @GetMapping(value = "/list")
    public AjaxResponseList listCargo(Integer pageNum, Integer pageSize){
        AjaxResponseList ajaxResponseList = new AjaxResponseList();
        if(pageNum == null || pageNum < 0 || pageSize == null || pageSize < 0){
            ajaxResponseList.setCode(1030);
            ajaxResponseList.setMessage("页数或页码错误");
            return ajaxResponseList;
        }
        List<Cargo> cargoList = cargoService.getCargoByState(pageNum,pageSize,100);
        if( cargoList == null || cargoList.isEmpty()){
            ajaxResponseList.setCode(1310);
            ajaxResponseList.setMessage("查询的货物为空");
            return ajaxResponseList;
        }
        int totalNum = cargoService.getAllCountByState(100);
        if(totalNum > 0){
            ajaxResponseList.setTotal(totalNum);
        }else{
            ajaxResponseList.setTotal(0);
        }
        ajaxResponseList.setPageSize(pageSize);
        ajaxResponseList.setPageNum(pageNum);
        ajaxResponseList.setCode(0);
        ajaxResponseList.setMessage("成功");
        ajaxResponseList.setData(cargoList);
        return ajaxResponseList;
    }
    
    @Operation(
            summary = "货物基础信息清单",
            description = "货物基础信息，用于采购单中选择货物"
    )
    @GetMapping(value = "selectList")
    public AjaxResponseList getSelectList(){
        AjaxResponseList ajaxResponseList = new AjaxResponseList();
        List<Cargo> cargoList = cargoService.getCargoByState(100,1,0);
        if(cargoList == null || cargoList.isEmpty()){
            ajaxResponseList.setCode(1310);
            ajaxResponseList.setMessage("查询的货物为空");
            return ajaxResponseList;
        }
        List<CargoSample> cargoSampleList = new ArrayList<CargoSample>();
        cargoList.forEach( cargo -> {
            CargoSample cargoSample = new CargoSample();
            cargoSample.setId(cargo.getId());
            cargoSample.setCargoName(cargo.getCargoName());
            cargoSample.setCargoType(cargo.getCargoType());
            cargoSample.setBrand(cargo.getBrand());
            cargoSample.setDescription(cargo.getDescription());
            cargoSampleList.add(cargoSample);
        });
        int totalNum = cargoService.getAllCountByState(100);
        if(totalNum > 0){
            ajaxResponseList.setTotal(totalNum);
        }else{
            ajaxResponseList.setTotal(0);
        }
        ajaxResponseList.setPageSize(0);
        ajaxResponseList.setPageNum(1);
        ajaxResponseList.setCode(0);
        ajaxResponseList.setMessage("成功");
        ajaxResponseList.setData(cargoSampleList);
        return ajaxResponseList;
    }
    
    
}
