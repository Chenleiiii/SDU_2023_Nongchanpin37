package com.qst.crop.entity;

import org.hibernate.validator.constraints.NotBlank;

public class Expert {
    private String userName;
    @NotBlank(message = "真实姓名不能为空")
    private String realName;
    @NotBlank(message = "电话不能为空")
    private String phone;
    @NotBlank(message = "从事专业不能为空")
    private String profession;
    @NotBlank(message = "职位不能为空")
    private String position;
    @NotBlank(message = "所属单位不能为空")
    private String belong;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong == null ? null : belong.trim();
    }
}