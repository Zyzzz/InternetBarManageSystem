package com.imudges.model;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/10/28.
 */
@Entity
@Table(name = "shoppingcar", schema = "ecommerce", catalog = "")
public class ShoppingcarEntity {
    private int shoppingcarid;
    private int userid;
    private String cookie;
    private String commodityidlist;
    private String timelist;
    private Double price;
    private String sizes;

    @Id
    @Column(name = "shoppingcarid", nullable = false)
    public int getShoppingcarid() {
        return shoppingcarid;
    }

    public void setShoppingcarid(int shoppingcarid) {
        this.shoppingcarid = shoppingcarid;
    }

    @Basic
    @Column(name = "userid", nullable = false)
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "cookie", nullable = false, length = 255)
    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    @Basic
    @Column(name = "commodityidlist", nullable = false, length = 255)
    public String getCommodityidlist() {
        return commodityidlist;
    }

    public void setCommodityidlist(String commodityidlist) {
        this.commodityidlist = commodityidlist;
    }

    @Basic
    @Column(name = "timelist", nullable = false, length = 255)
    public String getTimelist() {
        return timelist;
    }

    public void setTimelist(String timelist) {
        this.timelist = timelist;
    }

    @Basic
    @Column(name = "price", nullable = true, precision = 0)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    @Basic
    @Column(name = "sizes", nullable = true, precision = 0)
    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShoppingcarEntity that = (ShoppingcarEntity) o;

        if (shoppingcarid != that.shoppingcarid) return false;
        if (userid != that.userid) return false;
        if (cookie != null ? !cookie.equals(that.cookie) : that.cookie != null) return false;
        if (commodityidlist != null ? !commodityidlist.equals(that.commodityidlist) : that.commodityidlist != null)
            return false;
        if (timelist != null ? !timelist.equals(that.timelist) : that.timelist != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shoppingcarid;
        result = 31 * result + userid;
        result = 31 * result + (cookie != null ? cookie.hashCode() : 0);
        result = 31 * result + (commodityidlist != null ? commodityidlist.hashCode() : 0);
        result = 31 * result + (timelist != null ? timelist.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
