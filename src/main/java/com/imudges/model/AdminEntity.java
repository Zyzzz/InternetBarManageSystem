package com.imudges.model;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/11/14.
 */
@Entity
@Table(name = "admin", schema = "ecommerce", catalog = "")
public class AdminEntity {
    private int adminid;
    private String adminname;
    private String password;

    @Id
    @Column(name = "adminid", nullable = false)
    public int getAdminid() {
        return adminid;
    }

    public void setAdminid(int adminid) {
        this.adminid = adminid;
    }

    @Basic
    @Column(name = "adminname", nullable = false, length = 255)
    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdminEntity that = (AdminEntity) o;

        if (adminid != that.adminid) return false;
        if (adminname != null ? !adminname.equals(that.adminname) : that.adminname != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = adminid;
        result = 31 * result + (adminname != null ? adminname.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
