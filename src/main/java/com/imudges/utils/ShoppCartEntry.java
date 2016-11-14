package com.imudges.utils;

import com.imudges.model.CommodityEntity;

/**
 * Created by Administrator on 2016/11/3.
 */
public class ShoppCartEntry {
    private CommodityEntity commodityEntity;
    private String time;
    private String number;
    private String size;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public CommodityEntity getCommodityEntity() {
        return commodityEntity;
    }

    public void setCommodityEntity(CommodityEntity commodityEntity) {
        this.commodityEntity = commodityEntity;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
