package com.aks.management.dao;

import com.aks.management.bean.PurchaseCargo;
import com.aks.management.bean.PurchaseCargoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseCargoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_cargo
     *
     * @mbg.generated
     */
    long countByExample(PurchaseCargoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_cargo
     *
     * @mbg.generated
     */
    int deleteByExample(PurchaseCargoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_cargo
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_cargo
     *
     * @mbg.generated
     */
    int insert(PurchaseCargo row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_cargo
     *
     * @mbg.generated
     */
    int insertSelective(PurchaseCargo row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_cargo
     *
     * @mbg.generated
     */
    List<PurchaseCargo> selectByExample(PurchaseCargoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_cargo
     *
     * @mbg.generated
     */
    PurchaseCargo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_cargo
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("row") PurchaseCargo row, @Param("example") PurchaseCargoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_cargo
     *
     * @mbg.generated
     */
    int updateByExample(@Param("row") PurchaseCargo row, @Param("example") PurchaseCargoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_cargo
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(PurchaseCargo row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_cargo
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(PurchaseCargo row);
}