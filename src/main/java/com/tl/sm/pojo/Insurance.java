package com.tl.sm.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Insurance {
    private Integer id;
    //姓名
    private String insName;
    //工号
    private String insId;
    //性别
    private String insSex;
    //出生日期
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date insBoth;
    //身份证
    private String insIden;
    //家庭住址
    private String insAddress;
    //保险基数
    private String insCarNumber;
    //养老编号(没有使用)
    private String insOldId;
    //养老保险
    private String insOld;
    //工伤投保地
    private String insTreatmentId;
    //医疗保险
    private String insTreatments;
    //大病编号(没有使用)
    private String insIllId;
    //大病医疗
    private String insIll;
    //养老投保地
    private String insurance;
    //失业编号(没有使用)
    private String insUnempId;
    //失业保险
    private String insUnemp;
    //失业投保地
    private String insUnempAddress;
    //公积金
    private String insAccFund;
    //公积金投保地
    private String insAccAddress;
    //医疗投保地
    private String insSign;
    //备注
    private String insRemark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInsName() {
        return insName;
    }

    public void setInsName(String insName) {
        this.insName = insName == null ? null : insName.trim();
    }

    public String getInsId() {
        return insId;
    }

    public void setInsId(String insId) {
        this.insId = insId;
    }

    public String getInsSex() {
        return insSex;
    }

    public void setInsSex(String insSex) {
        this.insSex = insSex == null ? null : insSex.trim();
    }

    public Date getInsBoth() {
        return insBoth;
    }

    public void setInsBoth(Date insBoth) {
        this.insBoth = insBoth ;
    }

    public String getInsIden() {
        return insIden;
    }

    public void setInsIden(String insIden) {
        this.insIden = insIden == null ? null : insIden.trim();
    }

    public String getInsAddress() {
        return insAddress;
    }

    public void setInsAddress(String insAddress) {
        this.insAddress = insAddress == null ? null : insAddress.trim();
    }

    public String getInsCarNumber() {
        return insCarNumber;
    }

    public void setInsCarNumber(String insCarNumber) {
        this.insCarNumber = insCarNumber == null ? null : insCarNumber.trim();
    }

    public String getInsOldId() {
        return insOldId;
    }

    public void setInsOldId(String insOldId) {
        this.insOldId = insOldId == null ? null : insOldId.trim();
    }

    public String getInsOld() {
        return insOld;
    }

    public void setInsOld(String insOld) {
        this.insOld = insOld == null ? null : insOld.trim();
    }

    public String getInsTreatmentId() {
        return insTreatmentId;
    }

    public void setInsTreatmentId(String insTreatmentId) {
        this.insTreatmentId = insTreatmentId == null ? null : insTreatmentId.trim();
    }

    public String getInsTreatments() {
        return insTreatments;
    }

    public void setInsTreatments(String insTreatments) {
        this.insTreatments = insTreatments == null ? null : insTreatments.trim();
    }

    public String getInsIllId() {
        return insIllId;
    }

    public void setInsIllId(String insIllId) {
        this.insIllId = insIllId == null ? null : insIllId.trim();
    }

    public String getInsIll() {
        return insIll;
    }

    public void setInsIll(String insIll) {
        this.insIll = insIll == null ? null : insIll.trim();
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance == null ? null : insurance.trim();
    }

    public String getInsUnempId() {
        return insUnempId;
    }

    public void setInsUnempId(String insUnempId) {
        this.insUnempId = insUnempId == null ? null : insUnempId.trim();
    }

    public String getInsUnemp() {
        return insUnemp;
    }

    public void setInsUnemp(String insUnemp) {
        this.insUnemp = insUnemp == null ? null : insUnemp.trim();
    }

    public String getInsUnempAddress() {
        return insUnempAddress;
    }

    public void setInsUnempAddress(String insUnempAddress) {
        this.insUnempAddress = insUnempAddress == null ? null : insUnempAddress.trim();
    }

    public String getInsAccFund() {
        return insAccFund;
    }

    public void setInsAccFund(String insAccFund) {
        this.insAccFund = insAccFund == null ? null : insAccFund.trim();
    }

    public String getInsAccAddress() {
        return insAccAddress;
    }

    public void setInsAccAddress(String insAccAddress) {
        this.insAccAddress = insAccAddress == null ? null : insAccAddress.trim();
    }

    public String getInsSign() {
        return insSign;
    }

    public void setInsSign(String insSign) {
        this.insSign = insSign == null ? null : insSign.trim();
    }

    public String getInsRemark() {
        return insRemark;
    }

    public void setInsRemark(String insRemark) {
        this.insRemark = insRemark == null ? null : insRemark.trim();
    }
}