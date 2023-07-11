package com.qst.crop.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

/**
 * @author lzh
 * @creat 2022-08-09 15:43
 */
@Data
public class Intention {
    @NotBlank(message = "用户名不能为空")
    private String userName;
    @NotBlank(message = "用户名不能为空")
    private String realName;
    @NotBlank(message = "地址不能为空")
    private String address;
    @NotBlank(message = "金额不能为空")
    private Integer amount;
    @NotBlank(message = "用途不能为空")
    private String application;
    @NotBlank(message = "商品名称不能为空")
    private String item;
    @NotBlank(message = "还款日期不能为空")
    private Integer repaymentPeriod;
    @NotBlank(message = "种植面积不能为空")
    private Integer area;
    @NotBlank(message = "手机号不能为空")
    private String phone;
    private Date createTime;
    private Date updateTime;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getRepaymentPeriod() {
        return repaymentPeriod;
    }

    public void setRepaymentPeriod(Integer repaymentPeriod) {
        this.repaymentPeriod = repaymentPeriod;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
