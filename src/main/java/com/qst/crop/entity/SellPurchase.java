package com.qst.crop.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class SellPurchase {

    private Integer sellPurchaseId;

    private Integer purchaseId;

    private Integer orderId;

    private String ownName;

    private Integer purchaseType;

    private BigDecimal uninPricee;

    private BigDecimal sumPrice;

    private String address;
    private String phone;

    private Integer purchaseStatus;

    private Date createTime;

    private Date updateTime;

    public Integer getSellPurchaseId() {
        return sellPurchaseId;
    }

    public void setSellPurchaseId(Integer sellPurchaseId) {
        this.sellPurchaseId = sellPurchaseId;
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

    public String getOwnName() {
        return ownName;
    }

    public void setOwnName(String ownName) {
        this.ownName = ownName;
    }

    public Integer getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(Integer purchaseType) {
        this.purchaseType = purchaseType;
    }

    public BigDecimal getUninPricee() {
        return uninPricee;
    }

    public void setUninPricee(BigDecimal uninPricee) {
        this.uninPricee = uninPricee;
    }

    public BigDecimal getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(BigDecimal sumPrice) {
        this.sumPrice = sumPrice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getPurchaseStatus() {
        return purchaseStatus;
    }

    public void setPurchaseStatus(Integer purchaseStatus) {
        this.purchaseStatus = purchaseStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}