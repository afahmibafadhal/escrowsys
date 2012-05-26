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
@Table(name="batch"
    ,schema="public"
)
@SequenceGenerator(name = "seq_batch_id_name", sequenceName = "seq_batch_id", allocationSize = 1)
public class Batch implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_batch_id_name")
    @Column(name="batch_id", unique=true, nullable=false)
    private Long batchId;
    @Basic(optional = false)
    @Column(name = "batch_count")
    private int batchCount;
    @Column(name = "batch_total_amount")
    private BigDecimal batchTotalAmount;
    @Column(name = "batch_status")
    private Character batchStatus;
    @Column(name = "batch_open_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date batchOpenDate;
    @Column(name = "batch_close_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date batchCloseDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "batchId", fetch = FetchType.LAZY)
    private Set<Transactions> transactionsCollection;
    @JoinColumn(name = "general_account_id", referencedColumnName = "general_account_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GeneralAccount generalAccountId;

    public Batch() {
    }

    public Batch(Long batchId) {
        this.batchId = batchId;
    }

    public Batch(Long batchId, int batchCount) {
        this.batchId = batchId;
        this.batchCount = batchCount;
    }

    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public int getBatchCount() {
        return batchCount;
    }

    public void setBatchCount(int batchCount) {
        this.batchCount = batchCount;
    }

    public BigDecimal getBatchTotalAmount() {
        return batchTotalAmount;
    }

    public void setBatchTotalAmount(BigDecimal batchTotalAmount) {
        this.batchTotalAmount = batchTotalAmount;
    }

    public Character getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(Character batchStatus) {
        this.batchStatus = batchStatus;
    }

    public Date getBatchOpenDate() {
        return batchOpenDate;
    }

    public void setBatchOpenDate(Date batchOpenDate) {
        this.batchOpenDate = batchOpenDate;
    }

    public Date getBatchCloseDate() {
        return batchCloseDate;
    }

    public void setBatchCloseDate(Date batchCloseDate) {
        this.batchCloseDate = batchCloseDate;
    }

    public Set<Transactions> getTransactionsCollection() {
        return transactionsCollection;
    }

    public void setTransactionsCollection(Set<Transactions> transactionsCollection) {
        this.transactionsCollection = transactionsCollection;
    }

    public GeneralAccount getGeneralAccountId() {
        return generalAccountId;
    }

    public void setGeneralAccountId(GeneralAccount generalAccountId) {
        this.generalAccountId = generalAccountId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (batchId != null ? batchId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Batch)) {
            return false;
        }
        Batch other = (Batch) object;
        if ((this.batchId == null && other.batchId != null) || (this.batchId != null && !this.batchId.equals(other.batchId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.escrowsys.db.dto.Batch[batchId=" + batchId + "]";
    }

}
