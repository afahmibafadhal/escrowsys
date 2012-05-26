/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.escrowsys.db.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author kuuga
 */
@Entity
@Table(name="general_account"
    ,schema="public"
)
@SequenceGenerator(name = "seq_general_account_id_name", sequenceName = "seq_general_account_id", allocationSize = 1)
public class GeneralAccount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_general_account_id_name")
    @Column(name="general_account_id", unique=true, nullable=false)
    private Long generalAccountId;
    @Column(name = "general_account_type")
    private Character generalAccountType;
    @Column(name = "general_transaction_type")
    private Character generalTransactionType;
    @Column(name = "general_total_credit")
    private BigDecimal generalTotalCredit;
    @Column(name = "general_total_debit")
    private BigDecimal generalTotalDebit;
    @Column(name = "general_total_balance")
    private BigDecimal generalTotalBalance;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalAccountId", fetch = FetchType.LAZY)
    private Set<MasterMerchant> masterMerchantCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalAccountId", fetch = FetchType.LAZY)
    private Set<Merchant> merchantCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalAccountId", fetch = FetchType.LAZY)
    private Set<TransactionsShareData> transactionsShareDataCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "generalAccountId", fetch = FetchType.LAZY)
    private Set<Batch> batchCollection;

    public GeneralAccount() {
    }

    public GeneralAccount(Long generalAccountId) {
        this.generalAccountId = generalAccountId;
    }

    public Long getGeneralAccountId() {
        return generalAccountId;
    }

    public void setGeneralAccountId(Long generalAccountId) {
        this.generalAccountId = generalAccountId;
    }

    public Character getGeneralAccountType() {
        return generalAccountType;
    }

    public void setGeneralAccountType(Character generalAccountType) {
        this.generalAccountType = generalAccountType;
    }

    public Character getGeneralTransactionType() {
        return generalTransactionType;
    }

    public void setGeneralTransactionType(Character generalTransactionType) {
        this.generalTransactionType = generalTransactionType;
    }

    public BigDecimal getGeneralTotalCredit() {
        return generalTotalCredit;
    }

    public void setGeneralTotalCredit(BigDecimal generalTotalCredit) {
        this.generalTotalCredit = generalTotalCredit;
    }

    public BigDecimal getGeneralTotalDebit() {
        return generalTotalDebit;
    }

    public void setGeneralTotalDebit(BigDecimal generalTotalDebit) {
        this.generalTotalDebit = generalTotalDebit;
    }

    public BigDecimal getGeneralTotalBalance() {
        return generalTotalBalance;
    }

    public void setGeneralTotalBalance(BigDecimal generalTotalBalance) {
        this.generalTotalBalance = generalTotalBalance;
    }

    public Set<MasterMerchant> getMasterMerchantCollection() {
        return masterMerchantCollection;
    }

    public void setMasterMerchantCollection(Set<MasterMerchant> masterMerchantCollection) {
        this.masterMerchantCollection = masterMerchantCollection;
    }

    public Set<Merchant> getMerchantCollection() {
        return merchantCollection;
    }

    public void setMerchantCollection(Set<Merchant> merchantCollection) {
        this.merchantCollection = merchantCollection;
    }

    public Set<TransactionsShareData> getTransactionsShareDataCollection() {
        return transactionsShareDataCollection;
    }

    public void setTransactionsShareDataCollection(Set<TransactionsShareData> transactionsShareDataCollection) {
        this.transactionsShareDataCollection = transactionsShareDataCollection;
    }

    public Set<Batch> getBatchCollection() {
        return batchCollection;
    }

    public void setBatchCollection(Set<Batch> batchCollection) {
        this.batchCollection = batchCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (generalAccountId != null ? generalAccountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GeneralAccount)) {
            return false;
        }
        GeneralAccount other = (GeneralAccount) object;
        if ((this.generalAccountId == null && other.generalAccountId != null) || (this.generalAccountId != null && !this.generalAccountId.equals(other.generalAccountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.escrowsys.db.dto.GeneralAccount[generalAccountId=" + generalAccountId + "]";
    }

}
