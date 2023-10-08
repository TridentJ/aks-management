/**
 * Created by IntelliJ IDEA.
 * User: trident
 * Date: 2023/10/8
 * Time: 10:40
 **/
package com.aks.management.service;

import com.aks.management.bean.Cargo;
import com.aks.management.bean.CargoExample;
import com.aks.management.bean.CustomerExample;
import com.aks.management.bean.SupplierExample;
import com.aks.management.dao.CargoMapper;
import com.github.pagehelper.PageHelper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class CargoService {
    
    @Resource
    private CargoMapper cargoMapper;
    
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    public Cargo getCargoById(Long id){
        return cargoMapper.selectByPrimaryKey(id);
    }
    
    public List<Cargo> getAllCargo(int pageNum,int pageSize){
        CargoExample cargoExample = new CargoExample();
        cargoExample.createCriteria().andIdGreaterThan(0L);
        cargoExample.setOrderByClause("id desc");
        PageHelper.startPage(pageNum,pageSize);
        return cargoMapper.selectByExample(cargoExample);
    }
    
    public List<Cargo> getCargoByState(int pageNum,int pageSize,int state){
        CargoExample cargoExample = new CargoExample();
        if(state == 100){
            cargoExample.createCriteria().andIdGreaterThan(0L).andStateGreaterThan(0);
        } else if(state == 200){
            cargoExample.createCriteria().andIdGreaterThan(0L).andStateGreaterThanOrEqualTo(0);
        }else{
            cargoExample.createCriteria().andIdGreaterThan(0L).andStateEqualTo(state);
        }
        cargoExample.setOrderByClause("id desc");
        PageHelper.startPage(pageNum,pageSize);
        return cargoMapper.selectByExample(cargoExample);
    }
    
    public int getAllCountByState(Integer state) {
        CargoExample cargoExample = new CargoExample();
        if(state == 100){
            cargoExample.createCriteria().andIdGreaterThan(0L).andStateGreaterThan(0);
        } else if(state == 200){
            cargoExample.createCriteria().andIdGreaterThan(0L).andStateGreaterThanOrEqualTo(0);
        }else{
            cargoExample.createCriteria().andIdGreaterThan(0L).andStateEqualTo(state);
        }
        //cargoExample.createCriteria().andStateEqualTo(state);
        return (int) cargoMapper.countByExample(cargoExample);
    }
    
    
}
