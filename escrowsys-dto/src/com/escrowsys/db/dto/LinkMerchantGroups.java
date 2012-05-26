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
@Table(name="link_merchant_groups"
    ,schema="public"
)
@SequenceGenerator(name = "seq_link_merchant_groups_id_name", sequenceName = "seq_link_merchant_groups_id", allocationSize = 1)
public class LinkMerchantGroups implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_link_merchant_groups_id_name")
    @Column(name="access_id", unique=true, nullable=false)
    private Long accessId;
    @JoinColumn(name = "menu_id", referencedColumnName = "menu_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MasterMerchantMenu menuId;
    @JoinColumn(name = "merchant_groups_id", referencedColumnName = "merchant_groups_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MerchantGroups merchantGroupsId;

    public LinkMerchantGroups() {
    }

    public LinkMerchantGroups(Long accessId) {
        this.accessId = accessId;
    }

    public Long getAccessId() {
        return accessId;
    }

    public void setAccessId(Long accessId) {
        this.accessId = accessId;
    }

    public MasterMerchantMenu getMenuId() {
        return menuId;
    }

    public void setMenuId(MasterMerchantMenu menuId) {
        this.menuId = menuId;
    }

    public MerchantGroups getMerchantGroupsId() {
        return merchantGroupsId;
    }

    public void setMerchantGroupsId(MerchantGroups merchantGroupsId) {
        this.merchantGroupsId = merchantGroupsId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accessId != null ? accessId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LinkMerchantGroups)) {
            return false;
        }
        LinkMerchantGroups other = (LinkMerchantGroups) object;
        if ((this.accessId == null && other.accessId != null) || (this.accessId != null && !this.accessId.equals(other.accessId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.escrowsys.db.dto.LinkMerchantGroups[accessId=" + accessId + "]";
    }

}
