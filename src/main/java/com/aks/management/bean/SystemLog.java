package com.aks.management.bean;

import java.time.LocalDateTime;

public class SystemLog {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_log.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_log.log_module
     *
     * @mbg.generated
     */
    private String logModule;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_log.method
     *
     * @mbg.generated
     */
    private String method;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_log.log_type
     *
     * @mbg.generated
     */
    private Integer logType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_log.msg
     *
     * @mbg.generated
     */
    private String msg;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_log.create_time
     *
     * @mbg.generated
     */
    private LocalDateTime createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column system_log.id
     *
     * @return the value of system_log.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column system_log.id
     *
     * @param id the value for system_log.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column system_log.log_module
     *
     * @return the value of system_log.log_module
     *
     * @mbg.generated
     */
    public String getLogModule() {
        return logModule;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column system_log.log_module
     *
     * @param logModule the value for system_log.log_module
     *
     * @mbg.generated
     */
    public void setLogModule(String logModule) {
        this.logModule = logModule;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column system_log.method
     *
     * @return the value of system_log.method
     *
     * @mbg.generated
     */
    public String getMethod() {
        return method;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column system_log.method
     *
     * @param method the value for system_log.method
     *
     * @mbg.generated
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column system_log.log_type
     *
     * @return the value of system_log.log_type
     *
     * @mbg.generated
     */
    public Integer getLogType() {
        return logType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column system_log.log_type
     *
     * @param logType the value for system_log.log_type
     *
     * @mbg.generated
     */
    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column system_log.msg
     *
     * @return the value of system_log.msg
     *
     * @mbg.generated
     */
    public String getMsg() {
        return msg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column system_log.msg
     *
     * @param msg the value for system_log.msg
     *
     * @mbg.generated
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column system_log.create_time
     *
     * @return the value of system_log.create_time
     *
     * @mbg.generated
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column system_log.create_time
     *
     * @param createTime the value for system_log.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}