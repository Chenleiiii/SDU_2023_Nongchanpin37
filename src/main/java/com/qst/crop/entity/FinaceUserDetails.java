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

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
