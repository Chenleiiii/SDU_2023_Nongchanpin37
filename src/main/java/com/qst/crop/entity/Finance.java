package com.qst.crop.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class Finance {
    private Integer financeId;
    private Integer bankId;
    private String ownName;
    private String realName;
    private String phone;
    private String idNum;
    private Integer status;
    @NotBlank(message = "金额不能为空")
    private BigDecimal money;
    @NotBlank(message = "利率不能为空")
    private BigDecimal rate;
    @NotBlank(message = "还款周期不能为空")
    private Integer repayment;
    private Date createTime;
    private Date updateTime;

    private String combinationName1;
    private String combinationPhone1;
    private String combinationIdnum1;
    private String combinationName2;
    private String combinationPhone2;
    private String combinationIdnum2;

    private String fileInfo;

    public Integer getFinanceId() {
        return financeId;
    }

    public void setFinanceId(Integer financeId) {
        this.financeId = financeId;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public String getOwnName() {
        return ownName;
    }

    public void setOwnName(String ownName) {
        this.ownName = ownName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Integer getRepayment() {
        return repayment;
    }

    public void setRepayment(Integer repayment) {
        this.repayment = repayment;
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

    public String getCombinationName1() {
        return combinationName1;
    }

    public void setCombinationName1(String combinationName1) {
        this.combinationName1 = combinationName1;
    }

    public String getCombinationPhone1() {
        return combinationPhone1;
    }

    public void setCombinationPhone1(String combinationPhone1) {
        this.combinationPhone1 = combinationPhone1;
    }

    public String getCombinationIdnum1() {
        return combinationIdnum1;
    }

    public void setCombinationIdnum1(String combinationIdnum1) {
        this.combinationIdnum1 = combinationIdnum1;
    }

    public String getCombinationName2() {
        return combinationName2;
    }

    public void setCombinationName2(String combinationName2) {
        this.combinationName2 = combinationName2;
    }

    public String getCombinationPhone2() {
        return combinationPhone2;
    }

    public void setCombinationPhone2(String combinationPhone2) {
        this.combinationPhone2 = combinationPhone2;
    }

    public String getCombinationIdnum2() {
        return combinationIdnum2;
    }

    public void setCombinationIdnum2(String combinationIdnum2) {
        this.combinationIdnum2 = combinationIdnum2;
    }

    public String getFileInfo() {
        return fileInfo;
    }

    public void setFileInfo(String fileInfo) {
        this.fileInfo = fileInfo;
    }
}