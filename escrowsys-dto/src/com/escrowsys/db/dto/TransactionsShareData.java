/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.escrowsys.db.dto;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author kuuga
 */
@Entity
@Table(name="transactions_share_data"
    ,schema="public"
)
@SequenceGenerator(name = "seq_transactions_share_data_id_name", sequenceName = "seq_transactions_share_data_id", allocationSize = 1)
public class TransactionsShareData implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_transactions_share_data_id_name")
    @Column(name="transactions_share_data_id", unique=true, nullable=false)
    private Long transactionsShareDataId;
    @Column(name = "share_type")
    private Character shareType;
    @Column(name = "share_remark")
    private String shareRemark;
    @Column(name = "share_amount")
    private BigDecimal shareAmount;
    @JoinColumn(name = "general_account_id", referencedColumnName = "general_account_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GeneralAccount generalAccountId;
    @JoinColumn(name = "transactions_id", referencedColumnName = "transactions_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Transactions transactionsId;

    public TransactionsShareData() {
    }

    public TransactionsShareData(Long transactionsShareDataId) {
        this.transactionsShareDataId = transactionsShareDataId;
    }

    public Long getTransactionsShareDataId() {
        return transactionsShareDataId;
    }

    public void setTransactionsShareDataId(Long transactionsShareDataId) {
        this.transactionsShareDataId = transactionsShareDataId;
    }

    public Character getShareType() {
        return shareType;
    }

    public void setShareType(Character shareType) {
        this.shareType = shareType;
    }

    public String getShareRemark() {
        return shareRemark;
    }

    public void setShareRemark(String shareRemark) {
        this.shareRemark = shareRemark;
    }

    public BigDecimal getShareAmount() {
        return shareAmount;
    }

    public void setShareAmount(BigDecimal shareAmount) {
        this.shareAmount = shareAmount;
    }

    public GeneralAccount getGeneralAccountId() {
        return generalAccountId;
    }

    public void setGeneralAccountId(GeneralAccount generalAccountId) {
        this.generalAccountId = generalAccountId;
    }

    public Transactions getTransactionsId() {
        return transactionsId;
    }

    public void setTransactionsId(Transactions transactionsId) {
        this.transactionsId = transactionsId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionsShareDataId != null ? transactionsShareDataId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransactionsShareData)) {
            return false;
        }
        TransactionsShareData other = (TransactionsShareData) object;
        if ((this.transactionsShareDataId == null && other.transactionsShareDataId != null) || (this.transactionsShareDataId != null && !this.transactionsShareDataId.equals(other.transactionsShareDataId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.escrowsys.db.dto.TransactionsShareData[transactionsShareDataId=" + transactionsShareDataId + "]";
    }

}
