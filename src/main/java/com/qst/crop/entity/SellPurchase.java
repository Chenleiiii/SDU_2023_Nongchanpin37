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


}