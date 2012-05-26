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
@Table(name="master_merchant_formula"
    ,schema="public"
)
@SequenceGenerator(name = "seq_master_merchant_formula_id_name", sequenceName = "seq_master_merchant_formula_id", allocationSize = 1)
public class MasterMerchantFormula implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_master_merchant_formula_id_name")
    @Column(name="master_merchant_formula_id", unique=true, nullable=false)
    private Long masterMerchantFormulaId;
    @Column(name = "formula_percentage_type")
    private Character formulaPercentageType;
    @Column(name = "merchant_share_percentage")
    private BigDecimal merchantSharePercentage;
    @Column(name = "master_merchant_share_percentage")
    private BigDecimal masterMerchantSharePercentage;
    @Column(name = "master_merchant_formula_status")
    private Boolean masterMerchantFormulaStatus;
    @Column(name = "master_merchant_formula_start_date")
    @Temporal(TemporalType.DATE)
    private Date masterMerchantFormulaStartDate;
    @Column(name = "master_merchant_formula_end_date")
    @Temporal(TemporalType.DATE)
    private Date masterMerchantFormulaEndDate;
    @OneToMany(mappedBy = "masterMerchantFormulaId", fetch = FetchType.LAZY)
    private Set<Transactions> transactionsCollection;
    @JoinColumn(name = "merchant_connector_id", referencedColumnName = "merchant_connector_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MerchantConnector merchantConnectorId;
    @JoinColumn(name = "payment_formula_id", referencedColumnName = "payment_formula_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private PaymentFormula paymentFormulaId;

    public MasterMerchantFormula() {
    }

    public MasterMerchantFormula(Long masterMerchantFormulaId) {
        this.masterMerchantFormulaId = masterMerchantFormulaId;
    }

    public Long getMasterMerchantFormulaId() {
        return masterMerchantFormulaId;
    }

    public void setMasterMerchantFormulaId(Long masterMerchantFormulaId) {
        this.masterMerchantFormulaId = masterMerchantFormulaId;
    }

    public Character getFormulaPercentageType() {
        return formulaPercentageType;
    }

    public void setFormulaPercentageType(Character formulaPercentageType) {
        this.formulaPercentageType = formulaPercentageType;
    }

    public BigDecimal getMerchantSharePercentage() {
        return merchantSharePercentage;
    }

    public void setMerchantSharePercentage(BigDecimal merchantSharePercentage) {
        this.merchantSharePercentage = merchantSharePercentage;
    }

    public BigDecimal getMasterMerchantSharePercentage() {
        return masterMerchantSharePercentage;
    }

    public void setMasterMerchantSharePercentage(BigDecimal masterMerchantSharePercentage) {
        this.masterMerchantSharePercentage = masterMerchantSharePercentage;
    }

    public Boolean getMasterMerchantFormulaStatus() {
        return masterMerchantFormulaStatus;
    }

    public void setMasterMerchantFormulaStatus(Boolean masterMerchantFormulaStatus) {
        this.masterMerchantFormulaStatus = masterMerchantFormulaStatus;
    }

    public Date getMasterMerchantFormulaStartDate() {
        return masterMerchantFormulaStartDate;
    }

    public void setMasterMerchantFormulaStartDate(Date masterMerchantFormulaStartDate) {
        this.masterMerchantFormulaStartDate = masterMerchantFormulaStartDate;
    }

    public Date getMasterMerchantFormulaEndDate() {
        return masterMerchantFormulaEndDate;
    }

    public void setMasterMerchantFormulaEndDate(Date masterMerchantFormulaEndDate) {
        this.masterMerchantFormulaEndDate = masterMerchantFormulaEndDate;
    }

    public Set<Transactions> getTransactionsCollection() {
        return transactionsCollection;
    }

    public void setTransactionsCollection(Set<Transactions> transactionsCollection) {
        this.transactionsCollection = transactionsCollection;
    }

    public MerchantConnector getMerchantConnectorId() {
        return merchantConnectorId;
    }

    public void setMerchantConnectorId(MerchantConnector merchantConnectorId) {
        this.merchantConnectorId = merchantConnectorId;
    }

    public PaymentFormula getPaymentFormulaId() {
        return paymentFormulaId;
    }

    public void setPaymentFormulaId(PaymentFormula paymentFormulaId) {
        this.paymentFormulaId = paymentFormulaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (masterMerchantFormulaId != null ? masterMerchantFormulaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MasterMerchantFormula)) {
            return false;
        }
        MasterMerchantFormula other = (MasterMerchantFormula) object;
        if ((this.masterMerchantFormulaId == null && other.masterMerchantFormulaId != null) || (this.masterMerchantFormulaId != null && !this.masterMerchantFormulaId.equals(other.masterMerchantFormulaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.escrowsys.db.dto.MasterMerchantFormula[masterMerchantFormulaId=" + masterMerchantFormulaId + "]";
    }

}
