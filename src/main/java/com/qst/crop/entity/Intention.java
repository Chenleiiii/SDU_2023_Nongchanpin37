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
}
