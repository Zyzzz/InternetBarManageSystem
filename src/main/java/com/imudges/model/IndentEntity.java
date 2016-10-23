package com.imudges.model;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/10/23.
 */
@Entity
@Table(name = "indent", schema = "ecommerce", catalog = "")
public class IndentEntity {
    private int indentid;
    private int size;
    private Integer number;
    private UserEntity userByUserid;
    private CommodityEntity commodityByCommodityId;

    @Id
    @Column(name = "indentid", nullable = false)
    public int getIndentid() {
        return indentid;
    }

    public void setIndentid(int indentid) {
        this.indentid = indentid;
    }

    @Basic
    @Column(name = "size", nullable = false)
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Basic
    @Column(name = "number", nullable = true)
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IndentEntity that = (IndentEntity) o;

        if (indentid != that.indentid) return false;
        if (size != that.size) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = indentid;
        result = 31 * result + size;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid", nullable = false)
    public UserEntity getUserByUserid() {
        return userByUserid;
    }

    public void setUserByUserid(UserEntity userByUserid) {
        this.userByUserid = userByUserid;
    }

    @ManyToOne
    @JoinColumn(name = "commodityid", referencedColumnName = "commodityid", nullable = false)
    public CommodityEntity getCommodityByCommodityId() {
        return commodityByCommodityId;
    }

    public void setCommodityByCommodityId(CommodityEntity commodityByCommodityId) {
        this.commodityByCommodityId = commodityByCommodityId;
    }
}
