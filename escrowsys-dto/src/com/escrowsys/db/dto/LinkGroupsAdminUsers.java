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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author kuuga
 */
@Entity
@Table(name="link_groups_admin_users"
    ,schema="public"
)
@SequenceGenerator(name = "seq_link_groups_admin_users_id_name", sequenceName = "seq_link_groups_admin_users_id", allocationSize = 1)
public class LinkGroupsAdminUsers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_link_groups_admin_users_id_name")
    @Column(name="link_id", unique=true, nullable=false)
    private long linkId;
    @Column(name = "admin_groups_id")
    private Integer adminGroupsId;
    @JoinColumn(name = "admin_groups_id", referencedColumnName = "admin_groups_id", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private AdminGroups adminGroups;
    @JoinColumn(name = "admin_users_id", referencedColumnName = "admin_users_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AdminUsers adminUsersId;

    public LinkGroupsAdminUsers() {
    }

    public LinkGroupsAdminUsers(Integer adminGroupsId) {
        this.adminGroupsId = adminGroupsId;
    }

    public LinkGroupsAdminUsers(Integer adminGroupsId, long linkId) {
        this.adminGroupsId = adminGroupsId;
        this.linkId = linkId;
    }

    public long getLinkId() {
        return linkId;
    }

    public void setLinkId(long linkId) {
        this.linkId = linkId;
    }

    public Integer getAdminGroupsId() {
        return adminGroupsId;
    }

    public void setAdminGroupsId(Integer adminGroupsId) {
        this.adminGroupsId = adminGroupsId;
    }

    public AdminGroups getAdminGroups() {
        return adminGroups;
    }

    public void setAdminGroups(AdminGroups adminGroups) {
        this.adminGroups = adminGroups;
    }

    public AdminUsers getAdminUsersId() {
        return adminUsersId;
    }

    public void setAdminUsersId(AdminUsers adminUsersId) {
        this.adminUsersId = adminUsersId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LinkGroupsAdminUsers other = (LinkGroupsAdminUsers) obj;
        if (this.linkId != other.linkId) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + (int) (this.linkId ^ (this.linkId >>> 32));
        return hash;
    }

    

}
