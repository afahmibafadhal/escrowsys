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
@Table(name="admin_users"
    ,schema="public"
)
@SequenceGenerator(name = "seq_admin_users_id_name", sequenceName = "seq_admin_users_id", allocationSize = 1)
public class AdminUsers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_admin_users_id_name")
    @Column(name="admin_users_id", unique=true, nullable=false)
    private Integer adminUsersId;
    @Column(name = "admin_users_name")
    private String adminUsersName;
    @Column(name = "admin_users_login_id")
    private String adminUsersLoginId;
    @Column(name = "admin_users_password")
    private String adminUsersPassword;
    @Column(name = "admin_users_password_1")
    private String adminUsersPassword1;
    @Column(name = "admin_users_password_2")
    private String adminUsersPassword2;
    @Column(name = "admin_users_password_3")
    private String adminUsersPassword3;
    @Basic(optional = false)
    @Column(name = "admin_user_type")
    private int adminUserType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adminUsersId", fetch = FetchType.LAZY)
    private Set<LinkGroupsAdminUsers> linkGroupsAdminUsersCollection;

    public AdminUsers() {
    }

    public AdminUsers(Integer adminUsersId) {
        this.adminUsersId = adminUsersId;
    }

    public AdminUsers(Integer adminUsersId, int adminUserType) {
        this.adminUsersId = adminUsersId;
        this.adminUserType = adminUserType;
    }

    public Integer getAdminUsersId() {
        return adminUsersId;
    }

    public void setAdminUsersId(Integer adminUsersId) {
        this.adminUsersId = adminUsersId;
    }

    public String getAdminUsersName() {
        return adminUsersName;
    }

    public void setAdminUsersName(String adminUsersName) {
        this.adminUsersName = adminUsersName;
    }

    public String getAdminUsersLoginId() {
        return adminUsersLoginId;
    }

    public void setAdminUsersLoginId(String adminUsersLoginId) {
        this.adminUsersLoginId = adminUsersLoginId;
    }

    public String getAdminUsersPassword() {
        return adminUsersPassword;
    }

    public void setAdminUsersPassword(String adminUsersPassword) {
        this.adminUsersPassword = adminUsersPassword;
    }

    public String getAdminUsersPassword1() {
        return adminUsersPassword1;
    }

    public void setAdminUsersPassword1(String adminUsersPassword1) {
        this.adminUsersPassword1 = adminUsersPassword1;
    }

    public String getAdminUsersPassword2() {
        return adminUsersPassword2;
    }

    public void setAdminUsersPassword2(String adminUsersPassword2) {
        this.adminUsersPassword2 = adminUsersPassword2;
    }

    public String getAdminUsersPassword3() {
        return adminUsersPassword3;
    }

    public void setAdminUsersPassword3(String adminUsersPassword3) {
        this.adminUsersPassword3 = adminUsersPassword3;
    }

    public int getAdminUserType() {
        return adminUserType;
    }

    public void setAdminUserType(int adminUserType) {
        this.adminUserType = adminUserType;
    }

    public Set<LinkGroupsAdminUsers> getLinkGroupsAdminUsersCollection() {
        return linkGroupsAdminUsersCollection;
    }

    public void setLinkGroupsAdminUsersCollection(Set<LinkGroupsAdminUsers> linkGroupsAdminUsersCollection) {
        this.linkGroupsAdminUsersCollection = linkGroupsAdminUsersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminUsersId != null ? adminUsersId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdminUsers)) {
            return false;
        }
        AdminUsers other = (AdminUsers) object;
        if ((this.adminUsersId == null && other.adminUsersId != null) || (this.adminUsersId != null && !this.adminUsersId.equals(other.adminUsersId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.escrowsys.db.dto.AdminUsers[adminUsersId=" + adminUsersId + "]";
    }

}
