package com.imudges.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Administrator on 2016/10/20.
 */
@Entity
@Table(name = "commodity", schema = "ecommerce", catalog = "")
public class CommodityEntity {
    private ImageEntity imageByImageId;
    private Collection<IndentEntity> identByCommodityId;

    @OneToOne
    @JoinColumn(name = "imageid", referencedColumnName = "imageid")
    public ImageEntity getImageByImageId() {
        return imageByImageId;
    }

    public void setImageByImageId(ImageEntity imageByImageId) {
        this.imageByImageId = imageByImageId;
    }

    @OneToMany(mappedBy = "commodityByCommodityId")
    public Collection<IndentEntity> getIdentByCommodityId() {
        return identByCommodityId;
    }

    public void setIdentByCommodityId(Collection<IndentEntity> identByCommodityId) {
        this.identByCommodityId = identByCommodityId;
    }
}
