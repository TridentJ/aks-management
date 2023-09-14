package com.aks.management.dao;

import com.aks.management.bean.PurchaseSaleCargo;
import com.aks.management.bean.PurchaseSaleCargoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseSaleCargoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_sale_cargo
     *
     * @mbg.generated
     */
    long countByExample(PurchaseSaleCargoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_sale_cargo
     *
     * @mbg.generated
     */
    int deleteByExample(PurchaseSaleCargoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_sale_cargo
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_sale_cargo
     *
     * @mbg.generated
     */
    int insert(PurchaseSaleCargo row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_sale_cargo
     *
     * @mbg.generated
     */
    int insertSelective(PurchaseSaleCargo row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_sale_cargo
     *
     * @mbg.generated
     */
    List<PurchaseSaleCargo> selectByExample(PurchaseSaleCargoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_sale_cargo
     *
     * @mbg.generated
     */
    PurchaseSaleCargo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_sale_cargo
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("row") PurchaseSaleCargo row, @Param("example") PurchaseSaleCargoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_sale_cargo
     *
     * @mbg.generated
     */
    int updateByExample(@Param("row") PurchaseSaleCargo row, @Param("example") PurchaseSaleCargoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_sale_cargo
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(PurchaseSaleCargo row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_sale_cargo
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(PurchaseSaleCargo row);
}