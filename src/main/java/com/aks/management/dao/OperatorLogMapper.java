package com.aks.management.dao;

import com.aks.management.bean.OperatorLog;
import com.aks.management.bean.OperatorLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperatorLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table operator_log
     *
     * @mbg.generated
     */
    long countByExample(OperatorLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table operator_log
     *
     * @mbg.generated
     */
    int deleteByExample(OperatorLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table operator_log
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table operator_log
     *
     * @mbg.generated
     */
    int insert(OperatorLog row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table operator_log
     *
     * @mbg.generated
     */
    int insertSelective(OperatorLog row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table operator_log
     *
     * @mbg.generated
     */
    List<OperatorLog> selectByExample(OperatorLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table operator_log
     *
     * @mbg.generated
     */
    OperatorLog selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table operator_log
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("row") OperatorLog row, @Param("example") OperatorLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table operator_log
     *
     * @mbg.generated
     */
    int updateByExample(@Param("row") OperatorLog row, @Param("example") OperatorLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table operator_log
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(OperatorLog row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table operator_log
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(OperatorLog row);
}