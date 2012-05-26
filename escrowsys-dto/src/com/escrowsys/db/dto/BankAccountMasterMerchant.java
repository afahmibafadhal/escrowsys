/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.escrowsys.db.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author kuuga
 */
@Entity
@Table(name="bank_account_master_merchant"
    ,schema="public"
)
@SequenceGenerator(name = "seq_bank_id_name", sequenceName = "seq_bank_id", allocationSize = 1)
public class BankAccountMasterMerchant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_bank_id_name")
    @Column(name="bank_account_id", unique=true, nullable=false)
    private Long bankAccountId;
    @Column(name = "account_name")
    private String accountName;
    @Column(name = "account_no")
    private String accountNo;
    @Column(name = "account_bank_name")
    private String accountBankName;
    @Column(name = "account_bank_branch")
    private String accountBankBranch;
    @JoinColumn(name = "master_merchant_id", referencedColumnName = "master_merchant_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MasterMerchant masterMerchantId;

    public BankAccountMasterMerchant() {
    }

    public BankAccountMasterMerchant(Long bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public Long getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(Long bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountBankName() {
        return accountBankName;
    }

    public void setAccountBankName(String accountBankName) {
        this.accountBankName = accountBankName;
    }

    public String getAccountBankBranch() {
        return accountBankBranch;
    }

    public void setAccountBankBranch(String accountBankBranch) {
        this.accountBankBranch = accountBankBranch;
    }

    public MasterMerchant getMasterMerchantId() {
        return masterMerchantId;
    }

    public void setMasterMerchantId(MasterMerchant masterMerchantId) {
        this.masterMerchantId = masterMerchantId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bankAccountId != null ? bankAccountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BankAccountMasterMerchant)) {
            return false;
        }
        BankAccountMasterMerchant other = (BankAccountMasterMerchant) object;
        if ((this.bankAccountId == null && other.bankAccountId != null) || (this.bankAccountId != null && !this.bankAccountId.equals(other.bankAccountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.escrowsys.db.dto.BankAccountMasterMerchant[bankAccountId=" + bankAccountId + "]";
    }

}
