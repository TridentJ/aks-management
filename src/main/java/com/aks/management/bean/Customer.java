package com.aks.management.bean;

import java.time.LocalDateTime;

public class Customer {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.customer_number
     *
     * @mbg.generated
     */
    private String customerNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.customer_name
     *
     * @mbg.generated
     */
    private String customerName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.telephone
     *
     * @mbg.generated
     */
    private String telephone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.phone
     *
     * @mbg.generated
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.fax
     *
     * @mbg.generated
     */
    private String fax;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.address
     *
     * @mbg.generated
     */
    private String address;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.factory_address
     *
     * @mbg.generated
     */
    private String factoryAddress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.alipay_account
     *
     * @mbg.generated
     */
    private String alipayAccount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.wepay_account
     *
     * @mbg.generated
     */
    private String wepayAccount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.flag
     *
     * @mbg.generated
     */
    private String flag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.flag2
     *
     * @mbg.generated
     */
    private String flag2;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.state
     *
     * @mbg.generated
     */
    private Integer state;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.create_time
     *
     * @mbg.generated
     */
    private LocalDateTime createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.update_time
     *
     * @mbg.generated
     */
    private LocalDateTime updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer.comments
     *
     * @mbg.generated
     */
    private String comments;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.id
     *
     * @return the value of customer.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.id
     *
     * @param id the value for customer.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.customer_number
     *
     * @return the value of customer.customer_number
     *
     * @mbg.generated
     */
    public String getCustomerNumber() {
        return customerNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.customer_number
     *
     * @param customerNumber the value for customer.customer_number
     *
     * @mbg.generated
     */
    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.customer_name
     *
     * @return the value of customer.customer_name
     *
     * @mbg.generated
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.customer_name
     *
     * @param customerName the value for customer.customer_name
     *
     * @mbg.generated
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.telephone
     *
     * @return the value of customer.telephone
     *
     * @mbg.generated
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.telephone
     *
     * @param telephone the value for customer.telephone
     *
     * @mbg.generated
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.phone
     *
     * @return the value of customer.phone
     *
     * @mbg.generated
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.phone
     *
     * @param phone the value for customer.phone
     *
     * @mbg.generated
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.fax
     *
     * @return the value of customer.fax
     *
     * @mbg.generated
     */
    public String getFax() {
        return fax;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.fax
     *
     * @param fax the value for customer.fax
     *
     * @mbg.generated
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.address
     *
     * @return the value of customer.address
     *
     * @mbg.generated
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.address
     *
     * @param address the value for customer.address
     *
     * @mbg.generated
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.factory_address
     *
     * @return the value of customer.factory_address
     *
     * @mbg.generated
     */
    public String getFactoryAddress() {
        return factoryAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.factory_address
     *
     * @param factoryAddress the value for customer.factory_address
     *
     * @mbg.generated
     */
    public void setFactoryAddress(String factoryAddress) {
        this.factoryAddress = factoryAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.alipay_account
     *
     * @return the value of customer.alipay_account
     *
     * @mbg.generated
     */
    public String getAlipayAccount() {
        return alipayAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.alipay_account
     *
     * @param alipayAccount the value for customer.alipay_account
     *
     * @mbg.generated
     */
    public void setAlipayAccount(String alipayAccount) {
        this.alipayAccount = alipayAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.wepay_account
     *
     * @return the value of customer.wepay_account
     *
     * @mbg.generated
     */
    public String getWepayAccount() {
        return wepayAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.wepay_account
     *
     * @param wepayAccount the value for customer.wepay_account
     *
     * @mbg.generated
     */
    public void setWepayAccount(String wepayAccount) {
        this.wepayAccount = wepayAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.flag
     *
     * @return the value of customer.flag
     *
     * @mbg.generated
     */
    public String getFlag() {
        return flag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.flag
     *
     * @param flag the value for customer.flag
     *
     * @mbg.generated
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.flag2
     *
     * @return the value of customer.flag2
     *
     * @mbg.generated
     */
    public String getFlag2() {
        return flag2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.flag2
     *
     * @param flag2 the value for customer.flag2
     *
     * @mbg.generated
     */
    public void setFlag2(String flag2) {
        this.flag2 = flag2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.state
     *
     * @return the value of customer.state
     *
     * @mbg.generated
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.state
     *
     * @param state the value for customer.state
     *
     * @mbg.generated
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.create_time
     *
     * @return the value of customer.create_time
     *
     * @mbg.generated
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.create_time
     *
     * @param createTime the value for customer.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.update_time
     *
     * @return the value of customer.update_time
     *
     * @mbg.generated
     */
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.update_time
     *
     * @param updateTime the value for customer.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer.comments
     *
     * @return the value of customer.comments
     *
     * @mbg.generated
     */
    public String getComments() {
        return comments;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer.comments
     *
     * @param comments the value for customer.comments
     *
     * @mbg.generated
     */
    public void setComments(String comments) {
        this.comments = comments;
    }
}