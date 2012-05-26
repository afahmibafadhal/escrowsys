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
@Table(name="transactions"
    ,schema="public"
)
@SequenceGenerator(name = "seq_transactions_id_name", sequenceName = "seq_transactions_id", allocationSize = 1)
public class Transactions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_transactions_id_name")
    @Column(name="transactions_id", unique=true, nullable=false)
    private Long transactionsId;
    @Column(name = "transactions_state")
    private Character transactionsState;
    @Column(name = "transactions_status")
    private Character transactionsStatus;
    @Column(name = "transactions_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionsTime;
    @Column(name = "transactions_done_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionsDoneTime;
    @Column(name = "transactions_amount")
    private BigDecimal transactionsAmount;
    @Column(name = "user_account_or_cardnumber")
    private String userAccountOrCardnumber;
    @Column(name = "credit_card_no")
    private String creditCardNo;
    @Column(name = "card_holder_name")
    private String cardHolderName;
    @Column(name = "card_holder_email")
    private String cardHolderEmail;
    @Column(name = "card_holder_city")
    private String cardHolderCity;
    @Column(name = "card_holder_region")
    private String cardHolderRegion;
    @Column(name = "card_holder_country")
    private String cardHolderCountry;
    @Column(name = "card_holder_phone_no")
    private String cardHolderPhoneNo;
    @Column(name = "card_holder_postal_code")
    private String cardHolderPostalCode;
    @Column(name = "transactions_vat_amount")
    private BigDecimal transactionsVatAmount;
    @Column(name = "transactions_nett_goods")
    private BigDecimal transactionsNettGoods;
    @Column(name = "transactions_nett_margins")
    private BigDecimal transactionsNettMargins;
    @Column(name = "transactions_amount_1")
    private BigDecimal transactionsAmount1;
    @Column(name = "transactions_amount_2")
    private BigDecimal transactionsAmount2;
    @Column(name = "transactions_amount_3")
    private BigDecimal transactionsAmount3;
    @JoinColumn(name = "batch_id", referencedColumnName = "batch_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Batch batchId;
    @JoinColumn(name = "master_merchant_formula_id", referencedColumnName = "master_merchant_formula_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private MasterMerchantFormula masterMerchantFormulaId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transactionsId", fetch = FetchType.LAZY)
    private Set<TransactionsShareData> transactionsShareDataCollection;

    public Transactions() {
    }

    public Transactions(Long transactionsId) {
        this.transactionsId = transactionsId;
    }

    public Long getTransactionsId() {
        return transactionsId;
    }

    public void setTransactionsId(Long transactionsId) {
        this.transactionsId = transactionsId;
    }

    public Character getTransactionsState() {
        return transactionsState;
    }

    public void setTransactionsState(Character transactionsState) {
        this.transactionsState = transactionsState;
    }

    public Character getTransactionsStatus() {
        return transactionsStatus;
    }

    public void setTransactionsStatus(Character transactionsStatus) {
        this.transactionsStatus = transactionsStatus;
    }

    public Date getTransactionsTime() {
        return transactionsTime;
    }

    public void setTransactionsTime(Date transactionsTime) {
        this.transactionsTime = transactionsTime;
    }

    public Date getTransactionsDoneTime() {
        return transactionsDoneTime;
    }

    public void setTransactionsDoneTime(Date transactionsDoneTime) {
        this.transactionsDoneTime = transactionsDoneTime;
    }

    public BigDecimal getTransactionsAmount() {
        return transactionsAmount;
    }

    public void setTransactionsAmount(BigDecimal transactionsAmount) {
        this.transactionsAmount = transactionsAmount;
    }

    public String getUserAccountOrCardnumber() {
        return userAccountOrCardnumber;
    }

    public void setUserAccountOrCardnumber(String userAccountOrCardnumber) {
        this.userAccountOrCardnumber = userAccountOrCardnumber;
    }

    public String getCreditCardNo() {
        return creditCardNo;
    }

    public void setCreditCardNo(String creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardHolderEmail() {
        return cardHolderEmail;
    }

    public void setCardHolderEmail(String cardHolderEmail) {
        this.cardHolderEmail = cardHolderEmail;
    }

    public String getCardHolderCity() {
        return cardHolderCity;
    }

    public void setCardHolderCity(String cardHolderCity) {
        this.cardHolderCity = cardHolderCity;
    }

    public String getCardHolderRegion() {
        return cardHolderRegion;
    }

    public void setCardHolderRegion(String cardHolderRegion) {
        this.cardHolderRegion = cardHolderRegion;
    }

    public String getCardHolderCountry() {
        return cardHolderCountry;
    }

    public void setCardHolderCountry(String cardHolderCountry) {
        this.cardHolderCountry = cardHolderCountry;
    }

    public String getCardHolderPhoneNo() {
        return cardHolderPhoneNo;
    }

    public void setCardHolderPhoneNo(String cardHolderPhoneNo) {
        this.cardHolderPhoneNo = cardHolderPhoneNo;
    }

    public String getCardHolderPostalCode() {
        return cardHolderPostalCode;
    }

    public void setCardHolderPostalCode(String cardHolderPostalCode) {
        this.cardHolderPostalCode = cardHolderPostalCode;
    }

    public BigDecimal getTransactionsVatAmount() {
        return transactionsVatAmount;
    }

    public void setTransactionsVatAmount(BigDecimal transactionsVatAmount) {
        this.transactionsVatAmount = transactionsVatAmount;
    }

    public BigDecimal getTransactionsNettGoods() {
        return transactionsNettGoods;
    }

    public void setTransactionsNettGoods(BigDecimal transactionsNettGoods) {
        this.transactionsNettGoods = transactionsNettGoods;
    }

    public BigDecimal getTransactionsNettMargins() {
        return transactionsNettMargins;
    }

    public void setTransactionsNettMargins(BigDecimal transactionsNettMargins) {
        this.transactionsNettMargins = transactionsNettMargins;
    }

    public BigDecimal getTransactionsAmount1() {
        return transactionsAmount1;
    }

    public void setTransactionsAmount1(BigDecimal transactionsAmount1) {
        this.transactionsAmount1 = transactionsAmount1;
    }

    public BigDecimal getTransactionsAmount2() {
        return transactionsAmount2;
    }

    public void setTransactionsAmount2(BigDecimal transactionsAmount2) {
        this.transactionsAmount2 = transactionsAmount2;
    }

    public BigDecimal getTransactionsAmount3() {
        return transactionsAmount3;
    }

    public void setTransactionsAmount3(BigDecimal transactionsAmount3) {
        this.transactionsAmount3 = transactionsAmount3;
    }

    public Batch getBatchId() {
        return batchId;
    }

    public void setBatchId(Batch batchId) {
        this.batchId = batchId;
    }

    public MasterMerchantFormula getMasterMerchantFormulaId() {
        return masterMerchantFormulaId;
    }

    public void setMasterMerchantFormulaId(MasterMerchantFormula masterMerchantFormulaId) {
        this.masterMerchantFormulaId = masterMerchantFormulaId;
    }

    public Set<TransactionsShareData> getTransactionsShareDataCollection() {
        return transactionsShareDataCollection;
    }

    public void setTransactionsShareDataCollection(Set<TransactionsShareData> transactionsShareDataCollection) {
        this.transactionsShareDataCollection = transactionsShareDataCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionsId != null ? transactionsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transactions)) {
            return false;
        }
        Transactions other = (Transactions) object;
        if ((this.transactionsId == null && other.transactionsId != null) || (this.transactionsId != null && !this.transactionsId.equals(other.transactionsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.escrowsys.db.dto.Transactions[transactionsId=" + transactionsId + "]";
    }

}
