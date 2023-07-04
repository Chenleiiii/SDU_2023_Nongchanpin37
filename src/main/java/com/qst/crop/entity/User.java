package com.qst.crop.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import java.util.Date;
@Data
public class User {
    @Id
//    @Column(name = "userName")
//    @NotBlank(message = "账号不能为空")
    @Pattern(regexp = "^[a-zA-Z][A-Za-z0-9]{2,9}+$",message = "账号必须以字母开头，长度在3-10之间，只能包含英文字符、数字")
    private String userName;
//    @NotBlank(message = "密码不能为空")
    @Pattern(  regexp = "^[a-zA-Z][a-zA-Z0-9_]{5,17}$",message = "密码必须以字母开头，长度在6-18之间，只能包含英文字符、数字和下划线")
    private String password;
    @NotBlank(message = "昵称不能为空")
    private String nickName;

    private String realName;
    @Pattern(regexp = "^1[3|4|5|7|8][0-9]{9}$",message = "请输入正确的手机号")
    private String phone;
    @Pattern(regexp = "^\\d{15}|\\d{18}$",message = "请输入15或18位有效身份证号")
    private String identityNum;
    @Length(min = 2,max = 30,message = "请输入的地址长度在2-30之间")
    private String address;
    @Pattern(regexp = "^(user|expert|admin)$",message = "设置角色请输入 user,expert,admin 等角色")
    private String role;
    private Date createTime;
    private Date updateTime;
    private int integral;
    private int credit;
    private String avatar;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdentityNum() {
        return identityNum;
    }

    public void setIdentityNum(String identityNum) {
        this.identityNum = identityNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
