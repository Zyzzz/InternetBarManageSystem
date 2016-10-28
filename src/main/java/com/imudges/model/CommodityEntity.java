package com.imudges.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Administrator on 2016/10/23.
 */
@Entity
@Table(name = "commodity", schema = "ecommerce", catalog = "")
public class CommodityEntity {
    private int commodityid;
    private String commodityname;
    private double price;
    private String description;
    private ImageEntity imageByImageId;
    private double discount;
    private Collection<IndentEntity> indentByCommodityId;

    @Id
    @Column(name = "commodityid", nullable = false)
    public int getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(int commodityid) {
        this.commodityid = commodityid;
    }

    @Basic
    @Column(name = "commodityname", nullable = false, length = 255)
    public String getCommodityname() {
        return commodityname;
    }

    public void setCommodityname(String commodityname) {
        this.commodityname = commodityname;
    }

    @Basic
    @Column(name = "price", nullable = false)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "discount",nullable = true)
    public double getDiscount(){ return discount; }

    public void setDiscount(double discount) { this.discount = discount; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommodityEntity that = (CommodityEntity) o;

        if (commodityid != that.commodityid) return false;
        if (price != that.price) return false;
        if (commodityname != null ? !commodityname.equals(that.commodityname) : that.commodityname != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (discount != that.discount) return  false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = commodityid;
        result = 31 * result + (commodityname != null ? commodityname.hashCode() : 0);
        result = 31 * result + (int) price;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (int) discount;
        return result;
    }

    @OneToOne
    @JoinColumn(name = "imageid", referencedColumnName = "imageid")
    public ImageEntity getImageByImageId() {
        return imageByImageId;
    }

    public void setImageByImageId(ImageEntity imageByImageId) {
        this.imageByImageId = imageByImageId;
    }

    @OneToMany(mappedBy = "commodityByCommodityId")
    public Collection<IndentEntity> getIndentByCommodityId() {
        return indentByCommodityId;
    }

    public void setIndentByCommodityId(Collection<IndentEntity> indentByCommodityId) {
        this.indentByCommodityId = indentByCommodityId;
    }
}
