/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.escrowsys.db.dto;

import java.io.Serializable;
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

/**
 *
 * @author kuuga
 */
@Entity
@Table(name="master_merchant"
    ,schema="public"
)
@SequenceGenerator(name = "seq_master_merchant_id_name", sequenceName = "seq_master_merchant_id", allocationSize = 1)
public class MasterMerchant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_master_merchant_id_name")
    @Column(name="master_merchant_id", unique=true, nullable=false)
    private Long masterMerchantId;
    @Column(name = "master_merchant_name")
    private String masterMerchantName;
    @Column(name = "master_merchant_shop_name")
    private String masterMerchantShopName;
    @Column(name = "master_merchant_address")
    private String masterMerchantAddress;
    @Column(name = "master_merchant_tax_no")
    private String masterMerchantTaxNo;
    @Column(name = "master_merchant_office_phone_no")
    private String masterMerchantOfficePhoneNo;
    @Column(name = "master_merchant_office_fax")
    private String masterMerchantOfficeFax;
    @Column(name = "master_merchant_pic_name")
    private String masterMerchantPicName;
    @Column(name = "master_merchant_pic_phone_no")
    private String masterMerchantPicPhoneNo;
    @Column(name = "master_merchant_additional_info")
    private String masterMerchantAdditionalInfo;
    @JoinColumn(name = "general_account_id", referencedColumnName = "general_account_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GeneralAccount generalAccountId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "masterMerchantId", fetch = FetchType.LAZY)
    private Set<BankAccountMasterMerchant> bankAccountMasterMerchantCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "masterMerchantId", fetch = FetchType.LAZY)
    private Set<MasterMerchantUsers> masterMerchantUsersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "masterMerchantId", fetch = FetchType.LAZY)
    private Set<MerchantConnector> merchantConnectorCollection;

    public MasterMerchant() {
    }

    public MasterMerchant(Long masterMerchantId) {
        this.masterMerchantId = masterMerchantId;
    }

    public Long getMasterMerchantId() {
        return masterMerchantId;
    }

    public void setMasterMerchantId(Long masterMerchantId) {
        this.masterMerchantId = masterMerchantId;
    }

    public String getMasterMerchantName() {
        return masterMerchantName;
    }

    public void setMasterMerchantName(String masterMerchantName) {
        this.masterMerchantName = masterMerchantName;
    }

    public String getMasterMerchantShopName() {
        return masterMerchantShopName;
    }

    public void setMasterMerchantShopName(String masterMerchantShopName) {
        this.masterMerchantShopName = masterMerchantShopName;
    }

    public String getMasterMerchantAddress() {
        return masterMerchantAddress;
    }

    public void setMasterMerchantAddress(String masterMerchantAddress) {
        this.masterMerchantAddress = masterMerchantAddress;
    }

    public String getMasterMerchantTaxNo() {
        return masterMerchantTaxNo;
    }

    public void setMasterMerchantTaxNo(String masterMerchantTaxNo) {
        this.masterMerchantTaxNo = masterMerchantTaxNo;
    }

    public String getMasterMerchantOfficePhoneNo() {
        return masterMerchantOfficePhoneNo;
    }

    public void setMasterMerchantOfficePhoneNo(String masterMerchantOfficePhoneNo) {
        this.masterMerchantOfficePhoneNo = masterMerchantOfficePhoneNo;
    }

    public String getMasterMerchantOfficeFax() {
        return masterMerchantOfficeFax;
    }

    public void setMasterMerchantOfficeFax(String masterMerchantOfficeFax) {
        this.masterMerchantOfficeFax = masterMerchantOfficeFax;
    }

    public String getMasterMerchantPicName() {
        return masterMerchantPicName;
    }

    public void setMasterMerchantPicName(String masterMerchantPicName) {
        this.masterMerchantPicName = masterMerchantPicName;
    }

    public String getMasterMerchantPicPhoneNo() {
        return masterMerchantPicPhoneNo;
    }

    public void setMasterMerchantPicPhoneNo(String masterMerchantPicPhoneNo) {
        this.masterMerchantPicPhoneNo = masterMerchantPicPhoneNo;
    }

    public String getMasterMerchantAdditionalInfo() {
        return masterMerchantAdditionalInfo;
    }

    public void setMasterMerchantAdditionalInfo(String masterMerchantAdditionalInfo) {
        this.masterMerchantAdditionalInfo = masterMerchantAdditionalInfo;
    }

    public GeneralAccount getGeneralAccountId() {
        return generalAccountId;
    }

    public void setGeneralAccountId(GeneralAccount generalAccountId) {
        this.generalAccountId = generalAccountId;
    }

    public Set<BankAccountMasterMerchant> getBankAccountMasterMerchantCollection() {
        return bankAccountMasterMerchantCollection;
    }

    public void setBankAccountMasterMerchantCollection(Set<BankAccountMasterMerchant> bankAccountMasterMerchantCollection) {
        this.bankAccountMasterMerchantCollection = bankAccountMasterMerchantCollection;
    }

    public Set<MasterMerchantUsers> getMasterMerchantUsersCollection() {
        return masterMerchantUsersCollection;
    }

    public void setMasterMerchantUsersCollection(Set<MasterMerchantUsers> masterMerchantUsersCollection) {
        this.masterMerchantUsersCollection = masterMerchantUsersCollection;
    }

    public Set<MerchantConnector> getMerchantConnectorCollection() {
        return merchantConnectorCollection;
    }

    public void setMerchantConnectorCollection(Set<MerchantConnector> merchantConnectorCollection) {
        this.merchantConnectorCollection = merchantConnectorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (masterMerchantId != null ? masterMerchantId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MasterMerchant)) {
            return false;
        }
        MasterMerchant other = (MasterMerchant) object;
        if ((this.masterMerchantId == null && other.masterMerchantId != null) || (this.masterMerchantId != null && !this.masterMerchantId.equals(other.masterMerchantId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.escrowsys.db.dto.MasterMerchant[masterMerchantId=" + masterMerchantId + "]";
    }

}
