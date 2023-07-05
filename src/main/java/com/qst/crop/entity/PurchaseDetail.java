package com.qst.crop.entity;

import java.math.BigDecimal;

public class PurchaseDetail {

    private Integer detailId;

    private Integer purchaseId;

    private Integer orderId;

    private BigDecimal uninPrice;

    private BigDecimal sumPrice;

    private Integer count;

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getUninPrice() {
        return uninPrice;
    }

    public void setUninPrice(BigDecimal uninPrice) {
        this.uninPrice = uninPrice;
    }

    public BigDecimal getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(BigDecimal sumPrice) {
        this.sumPrice = sumPrice;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}