package com.imudges.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Administrator on 2016/10/23.
 */
@Entity
@Table(name = "user", schema = "ecommerce", catalog = "")
public class UserEntity {
    private int userid;
    private String email;
    private String password;
    private int jurisdiction;
    private String firstname;
    private String lastname;
    private String cookie;
    private Collection<IndentEntity> indentByUserid;

    @Id
    @Column(name = "userid", nullable = false)
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "jurisdiction", nullable = false)
    public int getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(int jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    @Basic
    @Column(name = "firstname", nullable = false, length = 255)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "lastname", nullable = false, length = 255)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "cookie", nullable = true,length = 255)
    public String getCookie(){ return cookie; }

    public void setCookie(String cookie) { this.cookie = cookie; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (userid != that.userid) return false;
        if (jurisdiction != that.jurisdiction) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (cookie != null ? !cookie.equals(that.cookie) : that.cookie != null ) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = userid;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + jurisdiction;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (cookie != null ? cookie.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByUserid")
    public Collection<IndentEntity> getIndentByUserid() {
        return indentByUserid;
    }

    public void setIndentByUserid(Collection<IndentEntity> indentByUserid) {
        this.indentByUserid = indentByUserid;
    }
}
