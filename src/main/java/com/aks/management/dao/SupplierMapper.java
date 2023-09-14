package com.aks.management.dao;

import com.aks.management.bean.Supplier;
import com.aks.management.bean.SupplierExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupplierMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supplier
     *
     * @mbg.generated
     */
    long countByExample(SupplierExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supplier
     *
     * @mbg.generated
     */
    int deleteByExample(SupplierExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supplier
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supplier
     *
     * @mbg.generated
     */
    int insert(Supplier row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supplier
     *
     * @mbg.generated
     */
    int insertSelective(Supplier row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supplier
     *
     * @mbg.generated
     */
    List<Supplier> selectByExample(SupplierExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supplier
     *
     * @mbg.generated
     */
    Supplier selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supplier
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("row") Supplier row, @Param("example") SupplierExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supplier
     *
     * @mbg.generated
     */
    int updateByExample(@Param("row") Supplier row, @Param("example") SupplierExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supplier
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Supplier row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table supplier
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Supplier row);
}