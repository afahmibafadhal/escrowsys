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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author kuuga
 */


@Entity
@Table(name="admin_menu"
    ,schema="public"
)
@SequenceGenerator(name = "seq_admin_menu_id_name", sequenceName = "seq_admin_menu_id", allocationSize = 1)
public class AdminMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_admin_menu_id_name")
    @Column(name="menu_id", unique=true, nullable=false)
    private Integer menuId;
    @Column(name = "menu_name")
    private String menuName;
    @Column(name = "menu_description")
    private String menuDescription;
    @Column(name = "menu_url")
    private String menuUrl;
    @Column(name = "menu_icon")
    private String menuIcon;
    @OneToMany(mappedBy = "menuRootId", fetch = FetchType.LAZY)
    private Set<AdminMenu> adminMenuCollection;
    @JoinColumn(name = "menu_root_id", referencedColumnName = "menu_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private AdminMenu menuRootId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menuId", fetch = FetchType.LAZY)
    private Set<LinkAdminGroups> linkAdminGroupsCollection;

    public AdminMenu() {
    }

    public AdminMenu(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuDescription() {
        return menuDescription;
    }

    public void setMenuDescription(String menuDescription) {
        this.menuDescription = menuDescription;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public Set<AdminMenu> getAdminMenuCollection() {
        return adminMenuCollection;
    }

    public void setAdminMenuCollection(Set<AdminMenu> adminMenuCollection) {
        this.adminMenuCollection = adminMenuCollection;
    }

    public AdminMenu getMenuRootId() {
        return menuRootId;
    }

    public void setMenuRootId(AdminMenu menuRootId) {
        this.menuRootId = menuRootId;
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
        hash += (menuId != null ? menuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdminMenu)) {
            return false;
        }
        AdminMenu other = (AdminMenu) object;
        if ((this.menuId == null && other.menuId != null) || (this.menuId != null && !this.menuId.equals(other.menuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.escrowsys.db.dto.AdminMenu[menuId=" + menuId + "]";
    }

}
