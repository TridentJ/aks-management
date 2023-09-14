package com.aks.management.dao;

import com.aks.management.bean.Sale;
import com.aks.management.bean.SaleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SaleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sale
     *
     * @mbg.generated
     */
    long countByExample(SaleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sale
     *
     * @mbg.generated
     */
    int deleteByExample(SaleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sale
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sale
     *
     * @mbg.generated
     */
    int insert(Sale row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sale
     *
     * @mbg.generated
     */
    int insertSelective(Sale row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sale
     *
     * @mbg.generated
     */
    List<Sale> selectByExample(SaleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sale
     *
     * @mbg.generated
     */
    Sale selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sale
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("row") Sale row, @Param("example") SaleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sale
     *
     * @mbg.generated
     */
    int updateByExample(@Param("row") Sale row, @Param("example") SaleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sale
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Sale row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sale
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Sale row);
}