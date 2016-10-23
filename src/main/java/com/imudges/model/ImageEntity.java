package com.imudges.model;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/10/23.
 */
@Entity
@Table(name = "image", schema = "ecommerce", catalog = "")
public class ImageEntity {
    private int imageid;
    private String img;
    private CommodityEntity commodityByImageId;

    @Id
    @Column(name = "imageid", nullable = false)
    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    @Basic
    @Column(name = "img", nullable = false, length = 255)
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImageEntity that = (ImageEntity) o;

        if (imageid != that.imageid) return false;
        if (img != null ? !img.equals(that.img) : that.img != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = imageid;
        result = 31 * result + (img != null ? img.hashCode() : 0);
        return result;
    }

    @OneToOne(mappedBy = "imageByImageId")
    public CommodityEntity getCommodityByImageId() {
        return commodityByImageId;
    }

    public void setCommodityByImageId(CommodityEntity commodityByImageId) {
        this.commodityByImageId = commodityByImageId;
    }
}
