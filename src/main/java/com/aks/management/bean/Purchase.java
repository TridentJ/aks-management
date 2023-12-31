package com.aks.management.bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Purchase {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.purchase_name
     *
     * @mbg.generated
     */
    private String purchaseName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.supplier_id
     *
     * @mbg.generated
     */
    private Long supplierId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.purchase_self_id
     *
     * @mbg.generated
     */
    private String purchaseSelfId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.purchase_peer_id
     *
     * @mbg.generated
     */
    private String purchasePeerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.sign_time
     *
     * @mbg.generated
     */
    private LocalDate signTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.description
     *
     * @mbg.generated
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.attachment
     *
     * @mbg.generated
     */
    private String attachment;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.deliver_address
     *
     * @mbg.generated
     */
    private String deliverAddress;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.contract_deliver_date
     *
     * @mbg.generated
     */
    private LocalDate contractDeliverDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.expect_delivery_date
     *
     * @mbg.generated
     */
    private LocalDate expectDeliveryDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.real_delivery_date
     *
     * @mbg.generated
     */
    private LocalDate realDeliveryDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.price_including_tax
     *
     * @mbg.generated
     */
    private Double priceIncludingTax;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.tax_point
     *
     * @mbg.generated
     */
    private Double taxPoint;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.price_excluding_tax
     *
     * @mbg.generated
     */
    private Double priceExcludingTax;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.cargo_price_including_tax
     *
     * @mbg.generated
     */
    private Double cargoPriceIncludingTax;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.cost
     *
     * @mbg.generated
     */
    private Double cost;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.include_freight
     *
     * @mbg.generated
     */
    private Integer includeFreight;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.pay_method
     *
     * @mbg.generated
     */
    private Integer payMethod;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.pay_type
     *
     * @mbg.generated
     */
    private Integer payType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.deposit
     *
     * @mbg.generated
     */
    private Double deposit;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.deposit_back_date
     *
     * @mbg.generated
     */
    private LocalDate depositBackDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.deposit_flag
     *
     * @mbg.generated
     */
    private Integer depositFlag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.real_deposit_back_date
     *
     * @mbg.generated
     */
    private LocalDate realDepositBackDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.invoice_id
     *
     * @mbg.generated
     */
    private Long invoiceId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.invoice_sum
     *
     * @mbg.generated
     */
    private Double invoiceSum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.invoice_type
     *
     * @mbg.generated
     */
    private Integer invoiceType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.invoice
     *
     * @mbg.generated
     */
    private Integer invoice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.invoice_date
     *
     * @mbg.generated
     */
    private LocalDate invoiceDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.receive_invoice_date
     *
     * @mbg.generated
     */
    private LocalDate receiveInvoiceDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.contacts_id
     *
     * @mbg.generated
     */
    private Long contactsId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.salesman_id
     *
     * @mbg.generated
     */
    private Long salesmanId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.express_company
     *
     * @mbg.generated
     */
    private String expressCompany;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.express_id
     *
     * @mbg.generated
     */
    private String expressId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.flag
     *
     * @mbg.generated
     */
    private String flag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.flag2
     *
     * @mbg.generated
     */
    private String flag2;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.operator_id
     *
     * @mbg.generated
     */
    private Long operatorId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.purchase_state
     *
     * @mbg.generated
     */
    private Integer purchaseState;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.state
     *
     * @mbg.generated
     */
    private Integer state;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.create_time
     *
     * @mbg.generated
     */
    private LocalDateTime createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.update_time
     *
     * @mbg.generated
     */
    private LocalDateTime updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column purchase.comments
     *
     * @mbg.generated
     */
    private String comments;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.id
     *
     * @return the value of purchase.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.id
     *
     * @param id the value for purchase.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.purchase_name
     *
     * @return the value of purchase.purchase_name
     *
     * @mbg.generated
     */
    public String getPurchaseName() {
        return purchaseName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.purchase_name
     *
     * @param purchaseName the value for purchase.purchase_name
     *
     * @mbg.generated
     */
    public void setPurchaseName(String purchaseName) {
        this.purchaseName = purchaseName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.supplier_id
     *
     * @return the value of purchase.supplier_id
     *
     * @mbg.generated
     */
    public Long getSupplierId() {
        return supplierId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.supplier_id
     *
     * @param supplierId the value for purchase.supplier_id
     *
     * @mbg.generated
     */
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.purchase_self_id
     *
     * @return the value of purchase.purchase_self_id
     *
     * @mbg.generated
     */
    public String getPurchaseSelfId() {
        return purchaseSelfId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.purchase_self_id
     *
     * @param purchaseSelfId the value for purchase.purchase_self_id
     *
     * @mbg.generated
     */
    public void setPurchaseSelfId(String purchaseSelfId) {
        this.purchaseSelfId = purchaseSelfId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.purchase_peer_id
     *
     * @return the value of purchase.purchase_peer_id
     *
     * @mbg.generated
     */
    public String getPurchasePeerId() {
        return purchasePeerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.purchase_peer_id
     *
     * @param purchasePeerId the value for purchase.purchase_peer_id
     *
     * @mbg.generated
     */
    public void setPurchasePeerId(String purchasePeerId) {
        this.purchasePeerId = purchasePeerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.sign_time
     *
     * @return the value of purchase.sign_time
     *
     * @mbg.generated
     */
    public LocalDate getSignTime() {
        return signTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.sign_time
     *
     * @param signTime the value for purchase.sign_time
     *
     * @mbg.generated
     */
    public void setSignTime(LocalDate signTime) {
        this.signTime = signTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.description
     *
     * @return the value of purchase.description
     *
     * @mbg.generated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.description
     *
     * @param description the value for purchase.description
     *
     * @mbg.generated
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.attachment
     *
     * @return the value of purchase.attachment
     *
     * @mbg.generated
     */
    public String getAttachment() {
        return attachment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.attachment
     *
     * @param attachment the value for purchase.attachment
     *
     * @mbg.generated
     */
    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.deliver_address
     *
     * @return the value of purchase.deliver_address
     *
     * @mbg.generated
     */
    public String getDeliverAddress() {
        return deliverAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.deliver_address
     *
     * @param deliverAddress the value for purchase.deliver_address
     *
     * @mbg.generated
     */
    public void setDeliverAddress(String deliverAddress) {
        this.deliverAddress = deliverAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.contract_deliver_date
     *
     * @return the value of purchase.contract_deliver_date
     *
     * @mbg.generated
     */
    public LocalDate getContractDeliverDate() {
        return contractDeliverDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.contract_deliver_date
     *
     * @param contractDeliverDate the value for purchase.contract_deliver_date
     *
     * @mbg.generated
     */
    public void setContractDeliverDate(LocalDate contractDeliverDate) {
        this.contractDeliverDate = contractDeliverDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.expect_delivery_date
     *
     * @return the value of purchase.expect_delivery_date
     *
     * @mbg.generated
     */
    public LocalDate getExpectDeliveryDate() {
        return expectDeliveryDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.expect_delivery_date
     *
     * @param expectDeliveryDate the value for purchase.expect_delivery_date
     *
     * @mbg.generated
     */
    public void setExpectDeliveryDate(LocalDate expectDeliveryDate) {
        this.expectDeliveryDate = expectDeliveryDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.real_delivery_date
     *
     * @return the value of purchase.real_delivery_date
     *
     * @mbg.generated
     */
    public LocalDate getRealDeliveryDate() {
        return realDeliveryDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.real_delivery_date
     *
     * @param realDeliveryDate the value for purchase.real_delivery_date
     *
     * @mbg.generated
     */
    public void setRealDeliveryDate(LocalDate realDeliveryDate) {
        this.realDeliveryDate = realDeliveryDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.price_including_tax
     *
     * @return the value of purchase.price_including_tax
     *
     * @mbg.generated
     */
    public Double getPriceIncludingTax() {
        return priceIncludingTax;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.price_including_tax
     *
     * @param priceIncludingTax the value for purchase.price_including_tax
     *
     * @mbg.generated
     */
    public void setPriceIncludingTax(Double priceIncludingTax) {
        this.priceIncludingTax = priceIncludingTax;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.tax_point
     *
     * @return the value of purchase.tax_point
     *
     * @mbg.generated
     */
    public Double getTaxPoint() {
        return taxPoint;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.tax_point
     *
     * @param taxPoint the value for purchase.tax_point
     *
     * @mbg.generated
     */
    public void setTaxPoint(Double taxPoint) {
        this.taxPoint = taxPoint;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.price_excluding_tax
     *
     * @return the value of purchase.price_excluding_tax
     *
     * @mbg.generated
     */
    public Double getPriceExcludingTax() {
        return priceExcludingTax;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.price_excluding_tax
     *
     * @param priceExcludingTax the value for purchase.price_excluding_tax
     *
     * @mbg.generated
     */
    public void setPriceExcludingTax(Double priceExcludingTax) {
        this.priceExcludingTax = priceExcludingTax;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.cargo_price_including_tax
     *
     * @return the value of purchase.cargo_price_including_tax
     *
     * @mbg.generated
     */
    public Double getCargoPriceIncludingTax() {
        return cargoPriceIncludingTax;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.cargo_price_including_tax
     *
     * @param cargoPriceIncludingTax the value for purchase.cargo_price_including_tax
     *
     * @mbg.generated
     */
    public void setCargoPriceIncludingTax(Double cargoPriceIncludingTax) {
        this.cargoPriceIncludingTax = cargoPriceIncludingTax;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.cost
     *
     * @return the value of purchase.cost
     *
     * @mbg.generated
     */
    public Double getCost() {
        return cost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.cost
     *
     * @param cost the value for purchase.cost
     *
     * @mbg.generated
     */
    public void setCost(Double cost) {
        this.cost = cost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.include_freight
     *
     * @return the value of purchase.include_freight
     *
     * @mbg.generated
     */
    public Integer getIncludeFreight() {
        return includeFreight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.include_freight
     *
     * @param includeFreight the value for purchase.include_freight
     *
     * @mbg.generated
     */
    public void setIncludeFreight(Integer includeFreight) {
        this.includeFreight = includeFreight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.pay_method
     *
     * @return the value of purchase.pay_method
     *
     * @mbg.generated
     */
    public Integer getPayMethod() {
        return payMethod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.pay_method
     *
     * @param payMethod the value for purchase.pay_method
     *
     * @mbg.generated
     */
    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.pay_type
     *
     * @return the value of purchase.pay_type
     *
     * @mbg.generated
     */
    public Integer getPayType() {
        return payType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.pay_type
     *
     * @param payType the value for purchase.pay_type
     *
     * @mbg.generated
     */
    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.deposit
     *
     * @return the value of purchase.deposit
     *
     * @mbg.generated
     */
    public Double getDeposit() {
        return deposit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.deposit
     *
     * @param deposit the value for purchase.deposit
     *
     * @mbg.generated
     */
    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.deposit_back_date
     *
     * @return the value of purchase.deposit_back_date
     *
     * @mbg.generated
     */
    public LocalDate getDepositBackDate() {
        return depositBackDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.deposit_back_date
     *
     * @param depositBackDate the value for purchase.deposit_back_date
     *
     * @mbg.generated
     */
    public void setDepositBackDate(LocalDate depositBackDate) {
        this.depositBackDate = depositBackDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.deposit_flag
     *
     * @return the value of purchase.deposit_flag
     *
     * @mbg.generated
     */
    public Integer getDepositFlag() {
        return depositFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.deposit_flag
     *
     * @param depositFlag the value for purchase.deposit_flag
     *
     * @mbg.generated
     */
    public void setDepositFlag(Integer depositFlag) {
        this.depositFlag = depositFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.real_deposit_back_date
     *
     * @return the value of purchase.real_deposit_back_date
     *
     * @mbg.generated
     */
    public LocalDate getRealDepositBackDate() {
        return realDepositBackDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.real_deposit_back_date
     *
     * @param realDepositBackDate the value for purchase.real_deposit_back_date
     *
     * @mbg.generated
     */
    public void setRealDepositBackDate(LocalDate realDepositBackDate) {
        this.realDepositBackDate = realDepositBackDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.invoice_id
     *
     * @return the value of purchase.invoice_id
     *
     * @mbg.generated
     */
    public Long getInvoiceId() {
        return invoiceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.invoice_id
     *
     * @param invoiceId the value for purchase.invoice_id
     *
     * @mbg.generated
     */
    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.invoice_sum
     *
     * @return the value of purchase.invoice_sum
     *
     * @mbg.generated
     */
    public Double getInvoiceSum() {
        return invoiceSum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.invoice_sum
     *
     * @param invoiceSum the value for purchase.invoice_sum
     *
     * @mbg.generated
     */
    public void setInvoiceSum(Double invoiceSum) {
        this.invoiceSum = invoiceSum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.invoice_type
     *
     * @return the value of purchase.invoice_type
     *
     * @mbg.generated
     */
    public Integer getInvoiceType() {
        return invoiceType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.invoice_type
     *
     * @param invoiceType the value for purchase.invoice_type
     *
     * @mbg.generated
     */
    public void setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.invoice
     *
     * @return the value of purchase.invoice
     *
     * @mbg.generated
     */
    public Integer getInvoice() {
        return invoice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.invoice
     *
     * @param invoice the value for purchase.invoice
     *
     * @mbg.generated
     */
    public void setInvoice(Integer invoice) {
        this.invoice = invoice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.invoice_date
     *
     * @return the value of purchase.invoice_date
     *
     * @mbg.generated
     */
    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.invoice_date
     *
     * @param invoiceDate the value for purchase.invoice_date
     *
     * @mbg.generated
     */
    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.receive_invoice_date
     *
     * @return the value of purchase.receive_invoice_date
     *
     * @mbg.generated
     */
    public LocalDate getReceiveInvoiceDate() {
        return receiveInvoiceDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.receive_invoice_date
     *
     * @param receiveInvoiceDate the value for purchase.receive_invoice_date
     *
     * @mbg.generated
     */
    public void setReceiveInvoiceDate(LocalDate receiveInvoiceDate) {
        this.receiveInvoiceDate = receiveInvoiceDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.contacts_id
     *
     * @return the value of purchase.contacts_id
     *
     * @mbg.generated
     */
    public Long getContactsId() {
        return contactsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.contacts_id
     *
     * @param contactsId the value for purchase.contacts_id
     *
     * @mbg.generated
     */
    public void setContactsId(Long contactsId) {
        this.contactsId = contactsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.salesman_id
     *
     * @return the value of purchase.salesman_id
     *
     * @mbg.generated
     */
    public Long getSalesmanId() {
        return salesmanId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.salesman_id
     *
     * @param salesmanId the value for purchase.salesman_id
     *
     * @mbg.generated
     */
    public void setSalesmanId(Long salesmanId) {
        this.salesmanId = salesmanId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.express_company
     *
     * @return the value of purchase.express_company
     *
     * @mbg.generated
     */
    public String getExpressCompany() {
        return expressCompany;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.express_company
     *
     * @param expressCompany the value for purchase.express_company
     *
     * @mbg.generated
     */
    public void setExpressCompany(String expressCompany) {
        this.expressCompany = expressCompany;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.express_id
     *
     * @return the value of purchase.express_id
     *
     * @mbg.generated
     */
    public String getExpressId() {
        return expressId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.express_id
     *
     * @param expressId the value for purchase.express_id
     *
     * @mbg.generated
     */
    public void setExpressId(String expressId) {
        this.expressId = expressId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.flag
     *
     * @return the value of purchase.flag
     *
     * @mbg.generated
     */
    public String getFlag() {
        return flag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.flag
     *
     * @param flag the value for purchase.flag
     *
     * @mbg.generated
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.flag2
     *
     * @return the value of purchase.flag2
     *
     * @mbg.generated
     */
    public String getFlag2() {
        return flag2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.flag2
     *
     * @param flag2 the value for purchase.flag2
     *
     * @mbg.generated
     */
    public void setFlag2(String flag2) {
        this.flag2 = flag2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.operator_id
     *
     * @return the value of purchase.operator_id
     *
     * @mbg.generated
     */
    public Long getOperatorId() {
        return operatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.operator_id
     *
     * @param operatorId the value for purchase.operator_id
     *
     * @mbg.generated
     */
    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.purchase_state
     *
     * @return the value of purchase.purchase_state
     *
     * @mbg.generated
     */
    public Integer getPurchaseState() {
        return purchaseState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.purchase_state
     *
     * @param purchaseState the value for purchase.purchase_state
     *
     * @mbg.generated
     */
    public void setPurchaseState(Integer purchaseState) {
        this.purchaseState = purchaseState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.state
     *
     * @return the value of purchase.state
     *
     * @mbg.generated
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.state
     *
     * @param state the value for purchase.state
     *
     * @mbg.generated
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.create_time
     *
     * @return the value of purchase.create_time
     *
     * @mbg.generated
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.create_time
     *
     * @param createTime the value for purchase.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.update_time
     *
     * @return the value of purchase.update_time
     *
     * @mbg.generated
     */
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.update_time
     *
     * @param updateTime the value for purchase.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column purchase.comments
     *
     * @return the value of purchase.comments
     *
     * @mbg.generated
     */
    public String getComments() {
        return comments;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column purchase.comments
     *
     * @param comments the value for purchase.comments
     *
     * @mbg.generated
     */
    public void setComments(String comments) {
        this.comments = comments;
    }
}