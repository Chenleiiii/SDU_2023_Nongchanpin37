package com.qst.crop.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author lzh
 * @creat 2022-08-12 9:12
 */
@Data
public class FinaceUserDetails {

    private BigDecimal rate;

    private String phone;

    private String introduce;
    private String bankName;
}
