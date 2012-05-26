/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.escrowsys.db.dto;

import java.io.Serializable;
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
@Table(name="merchant_connector"
    ,schema="public"
)
@SequenceGenerator(name = "seq_merchant_connector_id_name", sequenceName = "seq_merchant_connector_id", allocationSize = 1)
public class MerchantConnector implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_merchant_connector_id_name")
    @Column(name="merchant_connector_id", unique=true, nullable=false)
    private Long merchantConnectorId;
    @Column(name = "connector_status")
    private Boolean connectorStatus;
    @Column(name = "connector_expiry_date")
    @Temporal(TemporalType.DATE)
    private Date connectorExpiryDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "merchantConnectorId", fetch = FetchType.LAZY)
    private Set<MasterMerchantFormula> masterMerchantFormulaCollection;
    @JoinColumn(name = "master_merchant_id", referencedColumnName = "master_merchant_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MasterMerchant masterMerchantId;
    @JoinColumn(name = "merchant_id", referencedColumnName = "merchant_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Merchant merchantId;

    public MerchantConnector() {
    }

    public MerchantConnector(Long merchantConnectorId) {
        this.merchantConnectorId = merchantConnectorId;
    }

    public Long getMerchantConnectorId() {
        return merchantConnectorId;
    }

    public void setMerchantConnectorId(Long merchantConnectorId) {
        this.merchantConnectorId = merchantConnectorId;
    }

    public Boolean getConnectorStatus() {
        return connectorStatus;
    }

    public void setConnectorStatus(Boolean connectorStatus) {
        this.connectorStatus = connectorStatus;
    }

    public Date getConnectorExpiryDate() {
        return connectorExpiryDate;
    }

    public void setConnectorExpiryDate(Date connectorExpiryDate) {
        this.connectorExpiryDate = connectorExpiryDate;
    }

    public Set<MasterMerchantFormula> getMasterMerchantFormulaCollection() {
        return masterMerchantFormulaCollection;
    }

    public void setMasterMerchantFormulaCollection(Set<MasterMerchantFormula> masterMerchantFormulaCollection) {
        this.masterMerchantFormulaCollection = masterMerchantFormulaCollection;
    }

    public MasterMerchant getMasterMerchantId() {
        return masterMerchantId;
    }

    public void setMasterMerchantId(MasterMerchant masterMerchantId) {
        this.masterMerchantId = masterMerchantId;
    }

    public Merchant getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Merchant merchantId) {
        this.merchantId = merchantId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (merchantConnectorId != null ? merchantConnectorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MerchantConnector)) {
            return false;
        }
        MerchantConnector other = (MerchantConnector) object;
        if ((this.merchantConnectorId == null && other.merchantConnectorId != null) || (this.merchantConnectorId != null && !this.merchantConnectorId.equals(other.merchantConnectorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.escrowsys.db.dto.MerchantConnector[merchantConnectorId=" + merchantConnectorId + "]";
    }

}
