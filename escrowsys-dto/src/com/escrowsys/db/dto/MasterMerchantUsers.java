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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author kuuga
 */
@Entity
@Table(name="master_merchant_users"
    ,schema="public"
)
@SequenceGenerator(name = "seq_master_merchant_users_id_name", sequenceName = "seq_master_merchant_users_id", allocationSize = 1)
public class MasterMerchantUsers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_master_merchant_users_id_name")
    @Column(name="merchant_users_id", unique=true, nullable=false)
    private Integer merchantUsersId;
    @Column(name = "merchant_users_name")
    private String merchantUsersName;
    @Column(name = "merchant_users_login_id")
    private String merchantUsersLoginId;
    @Column(name = "merchant_users_password")
    private String merchantUsersPassword;
    @Column(name = "merchant_users_password_1")
    private String merchantUsersPassword1;
    @Column(name = "merchant_users_password_2")
    private String merchantUsersPassword2;
    @Column(name = "merchant_users_password_3")
    private String merchantUsersPassword3;
    @JoinColumn(name = "master_merchant_id", referencedColumnName = "master_merchant_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MasterMerchant masterMerchantId;

    public MasterMerchantUsers() {
    }

    public MasterMerchantUsers(Integer merchantUsersId) {
        this.merchantUsersId = merchantUsersId;
    }

    public Integer getMerchantUsersId() {
        return merchantUsersId;
    }

    public void setMerchantUsersId(Integer merchantUsersId) {
        this.merchantUsersId = merchantUsersId;
    }

    public String getMerchantUsersName() {
        return merchantUsersName;
    }

    public void setMerchantUsersName(String merchantUsersName) {
        this.merchantUsersName = merchantUsersName;
    }

    public String getMerchantUsersLoginId() {
        return merchantUsersLoginId;
    }

    public void setMerchantUsersLoginId(String merchantUsersLoginId) {
        this.merchantUsersLoginId = merchantUsersLoginId;
    }

    public String getMerchantUsersPassword() {
        return merchantUsersPassword;
    }

    public void setMerchantUsersPassword(String merchantUsersPassword) {
        this.merchantUsersPassword = merchantUsersPassword;
    }

    public String getMerchantUsersPassword1() {
        return merchantUsersPassword1;
    }

    public void setMerchantUsersPassword1(String merchantUsersPassword1) {
        this.merchantUsersPassword1 = merchantUsersPassword1;
    }

    public String getMerchantUsersPassword2() {
        return merchantUsersPassword2;
    }

    public void setMerchantUsersPassword2(String merchantUsersPassword2) {
        this.merchantUsersPassword2 = merchantUsersPassword2;
    }

    public String getMerchantUsersPassword3() {
        return merchantUsersPassword3;
    }

    public void setMerchantUsersPassword3(String merchantUsersPassword3) {
        this.merchantUsersPassword3 = merchantUsersPassword3;
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
        hash += (merchantUsersId != null ? merchantUsersId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MasterMerchantUsers)) {
            return false;
        }
        MasterMerchantUsers other = (MasterMerchantUsers) object;
        if ((this.merchantUsersId == null && other.merchantUsersId != null) || (this.merchantUsersId != null && !this.merchantUsersId.equals(other.merchantUsersId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.escrowsys.db.dto.MasterMerchantUsers[merchantUsersId=" + merchantUsersId + "]";
    }

}
