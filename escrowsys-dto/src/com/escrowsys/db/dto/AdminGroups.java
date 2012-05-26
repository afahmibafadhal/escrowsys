/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.escrowsys.db.dto;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author kuuga
 */


@Entity
@Table(name="admin_groups"
    ,schema="public"
)
@SequenceGenerator(name = "seq_admin_groups_id_name", sequenceName = "seq_admin_groups_id", allocationSize = 1)
public class AdminGroups  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_admin_groups_id_name")
    @Column(name="admin_groups_id", unique=true, nullable=false)
    private Integer adminGroupsId;
    @Column(name = "admin_groups_name")
    private String adminGroupsName;
    @Column(name = "admin_groups_desc")
    private String adminGroupsDesc;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "adminGroups", fetch = FetchType.LAZY)
    private LinkGroupsAdminUsers linkGroupsAdminUsers;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adminGroupsId", fetch = FetchType.LAZY)
    private Set<LinkAdminGroups> linkAdminGroupsCollection;

    public AdminGroups() {
    }

    public AdminGroups(Integer adminGroupsId) {
        this.adminGroupsId = adminGroupsId;
    }

    public Integer getAdminGroupsId() {
        return adminGroupsId;
    }

    public void setAdminGroupsId(Integer adminGroupsId) {
        this.adminGroupsId = adminGroupsId;
    }

    public String getAdminGroupsName() {
        return adminGroupsName;
    }

    public void setAdminGroupsName(String adminGroupsName) {
        this.adminGroupsName = adminGroupsName;
    }

    public String getAdminGroupsDesc() {
        return adminGroupsDesc;
    }

    public void setAdminGroupsDesc(String adminGroupsDesc) {
        this.adminGroupsDesc = adminGroupsDesc;
    }

    public LinkGroupsAdminUsers getLinkGroupsAdminUsers() {
        return linkGroupsAdminUsers;
    }

    public void setLinkGroupsAdminUsers(LinkGroupsAdminUsers linkGroupsAdminUsers) {
        this.linkGroupsAdminUsers = linkGroupsAdminUsers;
    }

    public Set<LinkAdminGroups> getLinkAdminGroupsCollection() {
        return linkAdminGroupsCollection;
    }

    public void setLinkAdminGroupsCollection(Set<LinkAdminGroups> linkAdminGroupsCollection) {
        this.linkAdminGroupsCollection = linkAdminGroupsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminGroupsId != null ? adminGroupsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdminGroups)) {
            return false;
        }
        AdminGroups other = (AdminGroups) object;
        if ((this.adminGroupsId == null && other.adminGroupsId != null) || (this.adminGroupsId != null && !this.adminGroupsId.equals(other.adminGroupsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.escrowsys.db.dto.AdminGroups[adminGroupsId=" + adminGroupsId + "]";
    }

}
