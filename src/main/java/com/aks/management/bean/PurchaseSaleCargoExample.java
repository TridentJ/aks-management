package com.aks.management.bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PurchaseSaleCargoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table purchase_sale_cargo
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table purchase_sale_cargo
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table purchase_sale_cargo
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_sale_cargo
     *
     * @mbg.generated
     */
    public PurchaseSaleCargoExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_sale_cargo
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_sale_cargo
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_sale_cargo
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_sale_cargo
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_sale_cargo
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_sale_cargo
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_sale_cargo
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_sale_cargo
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_sale_cargo
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table purchase_sale_cargo
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table purchase_sale_cargo
     *
     * @mbg.generated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPurchaseSaleIdIsNull() {
            addCriterion("purchase_sale_id is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseSaleIdIsNotNull() {
            addCriterion("purchase_sale_id is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseSaleIdEqualTo(Long value) {
            addCriterion("purchase_sale_id =", value, "purchaseSaleId");
            return (Criteria) this;
        }

        public Criteria andPurchaseSaleIdNotEqualTo(Long value) {
            addCriterion("purchase_sale_id <>", value, "purchaseSaleId");
            return (Criteria) this;
        }

        public Criteria andPurchaseSaleIdGreaterThan(Long value) {
            addCriterion("purchase_sale_id >", value, "purchaseSaleId");
            return (Criteria) this;
        }

        public Criteria andPurchaseSaleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("purchase_sale_id >=", value, "purchaseSaleId");
            return (Criteria) this;
        }

        public Criteria andPurchaseSaleIdLessThan(Long value) {
            addCriterion("purchase_sale_id <", value, "purchaseSaleId");
            return (Criteria) this;
        }

        public Criteria andPurchaseSaleIdLessThanOrEqualTo(Long value) {
            addCriterion("purchase_sale_id <=", value, "purchaseSaleId");
            return (Criteria) this;
        }

        public Criteria andPurchaseSaleIdIn(List<Long> values) {
            addCriterion("purchase_sale_id in", values, "purchaseSaleId");
            return (Criteria) this;
        }

        public Criteria andPurchaseSaleIdNotIn(List<Long> values) {
            addCriterion("purchase_sale_id not in", values, "purchaseSaleId");
            return (Criteria) this;
        }

        public Criteria andPurchaseSaleIdBetween(Long value1, Long value2) {
            addCriterion("purchase_sale_id between", value1, value2, "purchaseSaleId");
            return (Criteria) this;
        }

        public Criteria andPurchaseSaleIdNotBetween(Long value1, Long value2) {
            addCriterion("purchase_sale_id not between", value1, value2, "purchaseSaleId");
            return (Criteria) this;
        }

        public Criteria andCargoIdIsNull() {
            addCriterion("cargo_id is null");
            return (Criteria) this;
        }

        public Criteria andCargoIdIsNotNull() {
            addCriterion("cargo_id is not null");
            return (Criteria) this;
        }

        public Criteria andCargoIdEqualTo(Long value) {
            addCriterion("cargo_id =", value, "cargoId");
            return (Criteria) this;
        }

        public Criteria andCargoIdNotEqualTo(Long value) {
            addCriterion("cargo_id <>", value, "cargoId");
            return (Criteria) this;
        }

        public Criteria andCargoIdGreaterThan(Long value) {
            addCriterion("cargo_id >", value, "cargoId");
            return (Criteria) this;
        }

        public Criteria andCargoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("cargo_id >=", value, "cargoId");
            return (Criteria) this;
        }

        public Criteria andCargoIdLessThan(Long value) {
            addCriterion("cargo_id <", value, "cargoId");
            return (Criteria) this;
        }

        public Criteria andCargoIdLessThanOrEqualTo(Long value) {
            addCriterion("cargo_id <=", value, "cargoId");
            return (Criteria) this;
        }

        public Criteria andCargoIdIn(List<Long> values) {
            addCriterion("cargo_id in", values, "cargoId");
            return (Criteria) this;
        }

        public Criteria andCargoIdNotIn(List<Long> values) {
            addCriterion("cargo_id not in", values, "cargoId");
            return (Criteria) this;
        }

        public Criteria andCargoIdBetween(Long value1, Long value2) {
            addCriterion("cargo_id between", value1, value2, "cargoId");
            return (Criteria) this;
        }

        public Criteria andCargoIdNotBetween(Long value1, Long value2) {
            addCriterion("cargo_id not between", value1, value2, "cargoId");
            return (Criteria) this;
        }

        public Criteria andPurchaseCargoIdIsNull() {
            addCriterion("purchase_cargo_id is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseCargoIdIsNotNull() {
            addCriterion("purchase_cargo_id is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseCargoIdEqualTo(Long value) {
            addCriterion("purchase_cargo_id =", value, "purchaseCargoId");
            return (Criteria) this;
        }

        public Criteria andPurchaseCargoIdNotEqualTo(Long value) {
            addCriterion("purchase_cargo_id <>", value, "purchaseCargoId");
            return (Criteria) this;
        }

        public Criteria andPurchaseCargoIdGreaterThan(Long value) {
            addCriterion("purchase_cargo_id >", value, "purchaseCargoId");
            return (Criteria) this;
        }

        public Criteria andPurchaseCargoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("purchase_cargo_id >=", value, "purchaseCargoId");
            return (Criteria) this;
        }

        public Criteria andPurchaseCargoIdLessThan(Long value) {
            addCriterion("purchase_cargo_id <", value, "purchaseCargoId");
            return (Criteria) this;
        }

        public Criteria andPurchaseCargoIdLessThanOrEqualTo(Long value) {
            addCriterion("purchase_cargo_id <=", value, "purchaseCargoId");
            return (Criteria) this;
        }

        public Criteria andPurchaseCargoIdIn(List<Long> values) {
            addCriterion("purchase_cargo_id in", values, "purchaseCargoId");
            return (Criteria) this;
        }

        public Criteria andPurchaseCargoIdNotIn(List<Long> values) {
            addCriterion("purchase_cargo_id not in", values, "purchaseCargoId");
            return (Criteria) this;
        }

        public Criteria andPurchaseCargoIdBetween(Long value1, Long value2) {
            addCriterion("purchase_cargo_id between", value1, value2, "purchaseCargoId");
            return (Criteria) this;
        }

        public Criteria andPurchaseCargoIdNotBetween(Long value1, Long value2) {
            addCriterion("purchase_cargo_id not between", value1, value2, "purchaseCargoId");
            return (Criteria) this;
        }

        public Criteria andSaleCargoIdIsNull() {
            addCriterion("sale_cargo_id is null");
            return (Criteria) this;
        }

        public Criteria andSaleCargoIdIsNotNull() {
            addCriterion("sale_cargo_id is not null");
            return (Criteria) this;
        }

        public Criteria andSaleCargoIdEqualTo(Long value) {
            addCriterion("sale_cargo_id =", value, "saleCargoId");
            return (Criteria) this;
        }

        public Criteria andSaleCargoIdNotEqualTo(Long value) {
            addCriterion("sale_cargo_id <>", value, "saleCargoId");
            return (Criteria) this;
        }

        public Criteria andSaleCargoIdGreaterThan(Long value) {
            addCriterion("sale_cargo_id >", value, "saleCargoId");
            return (Criteria) this;
        }

        public Criteria andSaleCargoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sale_cargo_id >=", value, "saleCargoId");
            return (Criteria) this;
        }

        public Criteria andSaleCargoIdLessThan(Long value) {
            addCriterion("sale_cargo_id <", value, "saleCargoId");
            return (Criteria) this;
        }

        public Criteria andSaleCargoIdLessThanOrEqualTo(Long value) {
            addCriterion("sale_cargo_id <=", value, "saleCargoId");
            return (Criteria) this;
        }

        public Criteria andSaleCargoIdIn(List<Long> values) {
            addCriterion("sale_cargo_id in", values, "saleCargoId");
            return (Criteria) this;
        }

        public Criteria andSaleCargoIdNotIn(List<Long> values) {
            addCriterion("sale_cargo_id not in", values, "saleCargoId");
            return (Criteria) this;
        }

        public Criteria andSaleCargoIdBetween(Long value1, Long value2) {
            addCriterion("sale_cargo_id between", value1, value2, "saleCargoId");
            return (Criteria) this;
        }

        public Criteria andSaleCargoIdNotBetween(Long value1, Long value2) {
            addCriterion("sale_cargo_id not between", value1, value2, "saleCargoId");
            return (Criteria) this;
        }

        public Criteria andNumIsNull() {
            addCriterion("num is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("num is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(Double value) {
            addCriterion("num =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(Double value) {
            addCriterion("num <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(Double value) {
            addCriterion("num >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(Double value) {
            addCriterion("num >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(Double value) {
            addCriterion("num <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(Double value) {
            addCriterion("num <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<Double> values) {
            addCriterion("num in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<Double> values) {
            addCriterion("num not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(Double value1, Double value2) {
            addCriterion("num between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(Double value1, Double value2) {
            addCriterion("num not between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyIsNull() {
            addCriterion("express_company is null");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyIsNotNull() {
            addCriterion("express_company is not null");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyEqualTo(String value) {
            addCriterion("express_company =", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyNotEqualTo(String value) {
            addCriterion("express_company <>", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyGreaterThan(String value) {
            addCriterion("express_company >", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("express_company >=", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyLessThan(String value) {
            addCriterion("express_company <", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyLessThanOrEqualTo(String value) {
            addCriterion("express_company <=", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyLike(String value) {
            addCriterion("express_company like", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyNotLike(String value) {
            addCriterion("express_company not like", value, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyIn(List<String> values) {
            addCriterion("express_company in", values, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyNotIn(List<String> values) {
            addCriterion("express_company not in", values, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyBetween(String value1, String value2) {
            addCriterion("express_company between", value1, value2, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressCompanyNotBetween(String value1, String value2) {
            addCriterion("express_company not between", value1, value2, "expressCompany");
            return (Criteria) this;
        }

        public Criteria andExpressIdIsNull() {
            addCriterion("express_id is null");
            return (Criteria) this;
        }

        public Criteria andExpressIdIsNotNull() {
            addCriterion("express_id is not null");
            return (Criteria) this;
        }

        public Criteria andExpressIdEqualTo(String value) {
            addCriterion("express_id =", value, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdNotEqualTo(String value) {
            addCriterion("express_id <>", value, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdGreaterThan(String value) {
            addCriterion("express_id >", value, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdGreaterThanOrEqualTo(String value) {
            addCriterion("express_id >=", value, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdLessThan(String value) {
            addCriterion("express_id <", value, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdLessThanOrEqualTo(String value) {
            addCriterion("express_id <=", value, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdLike(String value) {
            addCriterion("express_id like", value, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdNotLike(String value) {
            addCriterion("express_id not like", value, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdIn(List<String> values) {
            addCriterion("express_id in", values, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdNotIn(List<String> values) {
            addCriterion("express_id not in", values, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdBetween(String value1, String value2) {
            addCriterion("express_id between", value1, value2, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdNotBetween(String value1, String value2) {
            addCriterion("express_id not between", value1, value2, "expressId");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(LocalDateTime value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(LocalDateTime value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(LocalDateTime value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(LocalDateTime value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<LocalDateTime> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<LocalDateTime> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCommentsIsNull() {
            addCriterion("comments is null");
            return (Criteria) this;
        }

        public Criteria andCommentsIsNotNull() {
            addCriterion("comments is not null");
            return (Criteria) this;
        }

        public Criteria andCommentsEqualTo(String value) {
            addCriterion("comments =", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotEqualTo(String value) {
            addCriterion("comments <>", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsGreaterThan(String value) {
            addCriterion("comments >", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsGreaterThanOrEqualTo(String value) {
            addCriterion("comments >=", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLessThan(String value) {
            addCriterion("comments <", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLessThanOrEqualTo(String value) {
            addCriterion("comments <=", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLike(String value) {
            addCriterion("comments like", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotLike(String value) {
            addCriterion("comments not like", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsIn(List<String> values) {
            addCriterion("comments in", values, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotIn(List<String> values) {
            addCriterion("comments not in", values, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsBetween(String value1, String value2) {
            addCriterion("comments between", value1, value2, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotBetween(String value1, String value2) {
            addCriterion("comments not between", value1, value2, "comments");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table purchase_sale_cargo
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table purchase_sale_cargo
     *
     * @mbg.generated
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}