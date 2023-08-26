package com.qst.crop.entity;

import lombok.Data;

@Data
public class AliPay {

    private String tradeNo;
    private double totalAmount;
    private String subject;
    private String alipayTraceNo;
}


