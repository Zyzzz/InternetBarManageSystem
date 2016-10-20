package com.imudges.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by Administrator on 2016/10/20.
 */
@Entity
@Table(name = "indent", schema = "ecommerce", catalog = "")
public class IndentEntity {
    private UserEntity userByUserId;
    private CommodityEntity commodityByCommodityId;

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid", nullable = false)
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
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
