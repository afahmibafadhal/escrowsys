/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.escrowsys.db.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author kuuga
 */
@Entity
@Table(name="payment_formula"
    ,schema="public"
)
@SequenceGenerator(name = "seq_payment_formula_id_name", sequenceName = "seq_payment_formula_id", allocationSize = 1)
public class PaymentFormula implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_payment_formula_id_name")
    @Column(name="payment_formula_id", unique=true, nullable=false)
    private Integer paymentFormulaId;
    @Column(name = "formula_status")
    private Boolean formulaStatus;
    @Column(name = "formula_start_date")
    @Temporal(TemporalType.DATE)
    private Date formulaStartDate;
    @Column(name = "formula_end_date")
    @Temporal(TemporalType.DATE)
    private Date formulaEndDate;
    @Column(name = "payment_mdr_fee")
    private BigDecimal paymentMdrFee;
    @Column(name = "payment_debit_fee")
    private BigDecimal paymentDebitFee;
    @Column(name = "payment_escrow_fee")
    private BigDecimal paymentEscrowFee;
    @Column(name = "payment_payment_gateway_fee")
    private BigDecimal paymentPaymentGatewayFee;
    @Column(name = "payment_fraud_detection_fee")
    private BigDecimal paymentFraudDetectionFee;
    @Column(name = "payment_additional_fee_1")
    private BigDecimal paymentAdditionalFee1;
    @Column(name = "payment_additional_fee_2")
    private BigDecimal paymentAdditionalFee2;
    @Column(name = "payment_additional_fee_3")
    private BigDecimal paymentAdditionalFee3;
    @Column(name = "fee_charge_to")
    private Character feeChargeTo;
    @JoinColumn(name = "payment_channel_id", referencedColumnName = "payment_channel_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PaymentChannel paymentChannelId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paymentFormulaId", fetch = FetchType.LAZY)
    private Set<MasterMerchantFormula> masterMerchantFormulaCollection;

    public PaymentFormula() {
    }

    public PaymentFormula(Integer paymentFormulaId) {
        this.paymentFormulaId = paymentFormulaId;
    }

    public Integer getPaymentFormulaId() {
        return paymentFormulaId;
    }

    public void setPaymentFormulaId(Integer paymentFormulaId) {
        this.paymentFormulaId = paymentFormulaId;
    }

    public Boolean getFormulaStatus() {
        return formulaStatus;
    }

    public void setFormulaStatus(Boolean formulaStatus) {
        this.formulaStatus = formulaStatus;
    }

    public Date getFormulaStartDate() {
        return formulaStartDate;
    }

    public void setFormulaStartDate(Date formulaStartDate) {
        this.formulaStartDate = formulaStartDate;
    }

    public Date getFormulaEndDate() {
        return formulaEndDate;
    }

    public void setFormulaEndDate(Date formulaEndDate) {
        this.formulaEndDate = formulaEndDate;
    }

    public BigDecimal getPaymentMdrFee() {
        return paymentMdrFee;
    }

    public void setPaymentMdrFee(BigDecimal paymentMdrFee) {
        this.paymentMdrFee = paymentMdrFee;
    }

    public BigDecimal getPaymentDebitFee() {
        return paymentDebitFee;
    }

    public void setPaymentDebitFee(BigDecimal paymentDebitFee) {
        this.paymentDebitFee = paymentDebitFee;
    }

    public BigDecimal getPaymentEscrowFee() {
        return paymentEscrowFee;
    }

    public void setPaymentEscrowFee(BigDecimal paymentEscrowFee) {
        this.paymentEscrowFee = paymentEscrowFee;
    }

    public BigDecimal getPaymentPaymentGatewayFee() {
        return paymentPaymentGatewayFee;
    }

    public void setPaymentPaymentGatewayFee(BigDecimal paymentPaymentGatewayFee) {
        this.paymentPaymentGatewayFee = paymentPaymentGatewayFee;
    }

    public BigDecimal getPaymentFraudDetectionFee() {
        return paymentFraudDetectionFee;
    }

    public void setPaymentFraudDetectionFee(BigDecimal paymentFraudDetectionFee) {
        this.paymentFraudDetectionFee = paymentFraudDetectionFee;
    }

    public BigDecimal getPaymentAdditionalFee1() {
        return paymentAdditionalFee1;
    }

    public void setPaymentAdditionalFee1(BigDecimal paymentAdditionalFee1) {
        this.paymentAdditionalFee1 = paymentAdditionalFee1;
    }

    public BigDecimal getPaymentAdditionalFee2() {
        return paymentAdditionalFee2;
    }

    public void setPaymentAdditionalFee2(BigDecimal paymentAdditionalFee2) {
        this.paymentAdditionalFee2 = paymentAdditionalFee2;
    }

    public BigDecimal getPaymentAdditionalFee3() {
        return paymentAdditionalFee3;
    }

    public void setPaymentAdditionalFee3(BigDecimal paymentAdditionalFee3) {
        this.paymentAdditionalFee3 = paymentAdditionalFee3;
    }

    public Character getFeeChargeTo() {
        return feeChargeTo;
    }

    public void setFeeChargeTo(Character feeChargeTo) {
        this.feeChargeTo = feeChargeTo;
    }

    public PaymentChannel getPaymentChannelId() {
        return paymentChannelId;
    }

    public void setPaymentChannelId(PaymentChannel paymentChannelId) {
        this.paymentChannelId = paymentChannelId;
    }

    public Set<MasterMerchantFormula> getMasterMerchantFormulaCollection() {
        return masterMerchantFormulaCollection;
    }

    public void setMasterMerchantFormulaCollection(Set<MasterMerchantFormula> masterMerchantFormulaCollection) {
        this.masterMerchantFormulaCollection = masterMerchantFormulaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentFormulaId != null ? paymentFormulaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentFormula)) {
            return false;
        }
        PaymentFormula other = (PaymentFormula) object;
        if ((this.paymentFormulaId == null && other.paymentFormulaId != null) || (this.paymentFormulaId != null && !this.paymentFormulaId.equals(other.paymentFormulaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.escrowsys.db.dto.PaymentFormula[paymentFormulaId=" + paymentFormulaId + "]";
    }

}
