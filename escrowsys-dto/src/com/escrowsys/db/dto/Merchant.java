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
@Table(name="merchant"
    ,schema="public"
)
@SequenceGenerator(name = "seq_merchant_id_name", sequenceName = "seq_merchant_id", allocationSize = 1)
public class Merchant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_merchant_id_name")
    @Column(name="merchant_id", unique=true, nullable=false)
    private Long merchantId;
    @Column(name = "merchant_name")
    private String merchantName;
    @Column(name = "merchant_shop_name")
    private String merchantShopName;
    @Column(name = "merchant_address")
    private String merchantAddress;
    @Column(name = "merchant_tax_no")
    private String merchantTaxNo;
    @Column(name = "merchant_office_phone_no")
    private String merchantOfficePhoneNo;
    @Column(name = "merchant_office_fax")
    private String merchantOfficeFax;
    @Column(name = "merchant_pic_name")
    private String merchantPicName;
    @Column(name = "merchant_pic_phone_no")
    private String merchantPicPhoneNo;
    @Column(name = "merchant_additional_info")
    private String merchantAdditionalInfo;
    @JoinColumn(name = "general_account_id", referencedColumnName = "general_account_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GeneralAccount generalAccountId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "merchantId", fetch = FetchType.LAZY)
    private Set<MerchantConnector> merchantConnectorCollection;

    public Merchant() {
    }

    public Merchant(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantShopName() {
        return merchantShopName;
    }

    public void setMerchantShopName(String merchantShopName) {
        this.merchantShopName = merchantShopName;
    }

    public String getMerchantAddress() {
        return merchantAddress;
    }

    public void setMerchantAddress(String merchantAddress) {
        this.merchantAddress = merchantAddress;
    }

    public String getMerchantTaxNo() {
        return merchantTaxNo;
    }

    public void setMerchantTaxNo(String merchantTaxNo) {
        this.merchantTaxNo = merchantTaxNo;
    }

    public String getMerchantOfficePhoneNo() {
        return merchantOfficePhoneNo;
    }

    public void setMerchantOfficePhoneNo(String merchantOfficePhoneNo) {
        this.merchantOfficePhoneNo = merchantOfficePhoneNo;
    }

    public String getMerchantOfficeFax() {
        return merchantOfficeFax;
    }

    public void setMerchantOfficeFax(String merchantOfficeFax) {
        this.merchantOfficeFax = merchantOfficeFax;
    }

    public String getMerchantPicName() {
        return merchantPicName;
    }

    public void setMerchantPicName(String merchantPicName) {
        this.merchantPicName = merchantPicName;
    }

    public String getMerchantPicPhoneNo() {
        return merchantPicPhoneNo;
    }

    public void setMerchantPicPhoneNo(String merchantPicPhoneNo) {
        this.merchantPicPhoneNo = merchantPicPhoneNo;
    }

    public String getMerchantAdditionalInfo() {
        return merchantAdditionalInfo;
    }

    public void setMerchantAdditionalInfo(String merchantAdditionalInfo) {
        this.merchantAdditionalInfo = merchantAdditionalInfo;
    }

    public GeneralAccount getGeneralAccountId() {
        return generalAccountId;
    }

    public void setGeneralAccountId(GeneralAccount generalAccountId) {
        this.generalAccountId = generalAccountId;
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
        hash += (merchantId != null ? merchantId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Merchant)) {
            return false;
        }
        Merchant other = (Merchant) object;
        if ((this.merchantId == null && other.merchantId != null) || (this.merchantId != null && !this.merchantId.equals(other.merchantId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.escrowsys.db.dto.Merchant[merchantId=" + merchantId + "]";
    }

}
