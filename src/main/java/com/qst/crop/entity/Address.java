package com.qst.crop.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

public class Address {
    @Id
    private Integer id;
    private String ownName;
    @NotBlank(message = "收货人不能为空")
    @Length(min = 2,max = 10,message = "收货人长度在2-10之间")
    private String consignee;
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^1[3|4|5|7|8][0-9]{9}$",message = "请输入正确的手机号")
    private String phone;
    @NotBlank(message = "地址不能为空")
    @Length(min = 2,max = 40,message = "地址长度在2-40之间")
    private String addressDetail;
    private Boolean isDefault;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOwnName() {
        return ownName;
    }

    public void setOwnName(String ownName) {
        this.ownName = ownName;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }
}
