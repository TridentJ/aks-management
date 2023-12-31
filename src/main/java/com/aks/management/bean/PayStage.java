package com.aks.management.bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PayStage {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pay_stage.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pay_stage.sale_id
     *
     * @mbg.generated
     */
    private Long saleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pay_stage.purchase_id
     *
     * @mbg.generated
     */
    private Long purchaseId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pay_stage.stage_id
     *
     * @mbg.generated
     */
    private Integer stageId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pay_stage.condition
     *
     * @mbg.generated
     */
    private String condition;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pay_stage.ratio
     *
     * @mbg.generated
     */
    private Double ratio;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pay_stage.money
     *
     * @mbg.generated
     */
    private Double money;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pay_stage.expect_date
     *
     * @mbg.generated
     */
    private String expectDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pay_stage.expect_pay_date
     *
     * @mbg.generated
     */
    private LocalDate expectPayDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pay_stage.real_pay_date
     *
     * @mbg.generated
     */
    private LocalDate realPayDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pay_stage.state
     *
     * @mbg.generated
     */
    private Integer state;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pay_stage.request_date
     *
     * @mbg.generated
     */
    private LocalDate requestDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pay_stage.create_time
     *
     * @mbg.generated
     */
    private LocalDateTime createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pay_stage.comments
     *
     * @mbg.generated
     */
    private String comments;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pay_stage.id
     *
     * @return the value of pay_stage.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pay_stage.id
     *
     * @param id the value for pay_stage.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pay_stage.sale_id
     *
     * @return the value of pay_stage.sale_id
     *
     * @mbg.generated
     */
    public Long getSaleId() {
        return saleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pay_stage.sale_id
     *
     * @param saleId the value for pay_stage.sale_id
     *
     * @mbg.generated
     */
    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pay_stage.purchase_id
     *
     * @return the value of pay_stage.purchase_id
     *
     * @mbg.generated
     */
    public Long getPurchaseId() {
        return purchaseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pay_stage.purchase_id
     *
     * @param purchaseId the value for pay_stage.purchase_id
     *
     * @mbg.generated
     */
    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pay_stage.stage_id
     *
     * @return the value of pay_stage.stage_id
     *
     * @mbg.generated
     */
    public Integer getStageId() {
        return stageId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pay_stage.stage_id
     *
     * @param stageId the value for pay_stage.stage_id
     *
     * @mbg.generated
     */
    public void setStageId(Integer stageId) {
        this.stageId = stageId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pay_stage.condition
     *
     * @return the value of pay_stage.condition
     *
     * @mbg.generated
     */
    public String getCondition() {
        return condition;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pay_stage.condition
     *
     * @param condition the value for pay_stage.condition
     *
     * @mbg.generated
     */
    public void setCondition(String condition) {
        this.condition = condition;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pay_stage.ratio
     *
     * @return the value of pay_stage.ratio
     *
     * @mbg.generated
     */
    public Double getRatio() {
        return ratio;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pay_stage.ratio
     *
     * @param ratio the value for pay_stage.ratio
     *
     * @mbg.generated
     */
    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pay_stage.money
     *
     * @return the value of pay_stage.money
     *
     * @mbg.generated
     */
    public Double getMoney() {
        return money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pay_stage.money
     *
     * @param money the value for pay_stage.money
     *
     * @mbg.generated
     */
    public void setMoney(Double money) {
        this.money = money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pay_stage.expect_date
     *
     * @return the value of pay_stage.expect_date
     *
     * @mbg.generated
     */
    public String getExpectDate() {
        return expectDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pay_stage.expect_date
     *
     * @param expectDate the value for pay_stage.expect_date
     *
     * @mbg.generated
     */
    public void setExpectDate(String expectDate) {
        this.expectDate = expectDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pay_stage.expect_pay_date
     *
     * @return the value of pay_stage.expect_pay_date
     *
     * @mbg.generated
     */
    public LocalDate getExpectPayDate() {
        return expectPayDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pay_stage.expect_pay_date
     *
     * @param expectPayDate the value for pay_stage.expect_pay_date
     *
     * @mbg.generated
     */
    public void setExpectPayDate(LocalDate expectPayDate) {
        this.expectPayDate = expectPayDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pay_stage.real_pay_date
     *
     * @return the value of pay_stage.real_pay_date
     *
     * @mbg.generated
     */
    public LocalDate getRealPayDate() {
        return realPayDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pay_stage.real_pay_date
     *
     * @param realPayDate the value for pay_stage.real_pay_date
     *
     * @mbg.generated
     */
    public void setRealPayDate(LocalDate realPayDate) {
        this.realPayDate = realPayDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pay_stage.state
     *
     * @return the value of pay_stage.state
     *
     * @mbg.generated
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pay_stage.state
     *
     * @param state the value for pay_stage.state
     *
     * @mbg.generated
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pay_stage.request_date
     *
     * @return the value of pay_stage.request_date
     *
     * @mbg.generated
     */
    public LocalDate getRequestDate() {
        return requestDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pay_stage.request_date
     *
     * @param requestDate the value for pay_stage.request_date
     *
     * @mbg.generated
     */
    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pay_stage.create_time
     *
     * @return the value of pay_stage.create_time
     *
     * @mbg.generated
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pay_stage.create_time
     *
     * @param createTime the value for pay_stage.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pay_stage.comments
     *
     * @return the value of pay_stage.comments
     *
     * @mbg.generated
     */
    public String getComments() {
        return comments;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pay_stage.comments
     *
     * @param comments the value for pay_stage.comments
     *
     * @mbg.generated
     */
    public void setComments(String comments) {
        this.comments = comments;
    }
}