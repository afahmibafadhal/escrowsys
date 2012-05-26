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
@Table(name="merchant_groups"
    ,schema="public"
)
@SequenceGenerator(name = "seq_merchant_groups_id_name", sequenceName = "seq_merchant_groups_id", allocationSize = 1)
public class MerchantGroups implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_merchant_connector_id_name")
    @Column(name="merchant_groups_id", unique=true, nullable=false)
    private Integer merchantGroupsId;
    @Column(name = "merchant_groups_name")
    private String merchantGroupsName;
    @Column(name = "merchant_groups_desc")
    private String merchantGroupsDesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "merchantGroupsId", fetch = FetchType.LAZY)
    private Set<LinkMerchantGroups> linkMerchantGroupsCollection;

    public MerchantGroups() {
    }

    public MerchantGroups(Integer merchantGroupsId) {
        this.merchantGroupsId = merchantGroupsId;
    }

    public Integer getMerchantGroupsId() {
        return merchantGroupsId;
    }

    public void setMerchantGroupsId(Integer merchantGroupsId) {
        this.merchantGroupsId = merchantGroupsId;
    }

    public String getMerchantGroupsName() {
        return merchantGroupsName;
    }

    public void setMerchantGroupsName(String merchantGroupsName) {
        this.merchantGroupsName = merchantGroupsName;
    }

    public String getMerchantGroupsDesc() {
        return merchantGroupsDesc;
    }

    public void setMerchantGroupsDesc(String merchantGroupsDesc) {
        this.merchantGroupsDesc = merchantGroupsDesc;
    }

    public Set<LinkMerchantGroups> getLinkMerchantGroupsCollection() {
        return linkMerchantGroupsCollection;
    }

    public void setLinkMerchantGroupsCollection(Set<LinkMerchantGroups> linkMerchantGroupsCollection) {
        this.linkMerchantGroupsCollection = linkMerchantGroupsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (merchantGroupsId != null ? merchantGroupsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MerchantGroups)) {
            return false;
        }
        MerchantGroups other = (MerchantGroups) object;
        if ((this.merchantGroupsId == null && other.merchantGroupsId != null) || (this.merchantGroupsId != null && !this.merchantGroupsId.equals(other.merchantGroupsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.escrowsys.db.dto.MerchantGroups[merchantGroupsId=" + merchantGroupsId + "]";
    }

}
