package com.imudges.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by Administrator on 2016/10/20.
 */
@Entity
@Table(name = "image", schema = "ecommerce", catalog = "")
public class ImageEntity {
    private CommodityEntity ecommerceByimageid;

    @OneToOne(mappedBy = "imageByImageId")
    public CommodityEntity getEcommerceByimageid() {
        return ecommerceByimageid;
    }

    public void setEcommerceByimageid(CommodityEntity ecommerceByimageid) {
        this.ecommerceByimageid = ecommerceByimageid;
    }
}
