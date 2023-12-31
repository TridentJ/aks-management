package com.aks.management.dao;

import com.aks.management.bean.SystemLog;
import com.aks.management.bean.SystemLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_log
     *
     * @mbg.generated
     */
    long countByExample(SystemLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_log
     *
     * @mbg.generated
     */
    int deleteByExample(SystemLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_log
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_log
     *
     * @mbg.generated
     */
    int insert(SystemLog row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_log
     *
     * @mbg.generated
     */
    int insertSelective(SystemLog row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_log
     *
     * @mbg.generated
     */
    List<SystemLog> selectByExample(SystemLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_log
     *
     * @mbg.generated
     */
    SystemLog selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_log
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("row") SystemLog row, @Param("example") SystemLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_log
     *
     * @mbg.generated
     */
    int updateByExample(@Param("row") SystemLog row, @Param("example") SystemLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_log
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SystemLog row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_log
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SystemLog row);
}