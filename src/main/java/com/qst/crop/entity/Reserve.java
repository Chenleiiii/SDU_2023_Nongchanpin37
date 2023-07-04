package com.qst.crop.entity;

import org.hibernate.validator.constraints.NotBlank;

public class Reserve {

    private Integer id;

    private String expertName;

    private String questioner;

    @NotBlank(message = "面积不能为空")
    private String area;

    @NotBlank(message = "地址不能为空")
    private String address;

    @NotBlank(message = "农作物名称不能为空")
    private String plantName;

    @NotBlank(message = "土壤条件不能为空")
    private String soilCondition;

    @NotBlank(message = "农作物条件不能为空")
    private String plantCondition;

    @NotBlank(message = "农作物详细信息不能为空")
    private String plantDetail;

    @NotBlank(message = "电话不能为空")
    private String phone;

    private String message;

    private String answer;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExpertName() {
        return expertName;
    }

    public void setExpertName(String expertName) {
        this.expertName = expertName == null ? null : expertName.trim();
    }

    public String getQuestioner() {
        return questioner;
    }

    public void setQuestioner(String questioner) {
        this.questioner = questioner == null ? null : questioner.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName == null ? null : plantName.trim();
    }

    public String getSoilCondition() {
        return soilCondition;
    }

    public void setSoilCondition(String soilCondition) {
        this.soilCondition = soilCondition == null ? null : soilCondition.trim();
    }

    public String getPlantCondition() {
        return plantCondition;
    }

    public void setPlantCondition(String plantCondition) {
        this.plantCondition = plantCondition == null ? null : plantCondition.trim();
    }

    public String getPlantDetail() {
        return plantDetail;
    }

    public void setPlantDetail(String plantDetail) {
        this.plantDetail = plantDetail == null ? null : plantDetail.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}