package com.tl.sm.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Employee {
    private Integer id;

    private String bankAccount;

    private String salName;

    private String postCategory;

    private Integer salId;

    private String salDep;

    private String salPost;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date salDate;

    private String salOa;

    private String staCategory;

    private String salRemark;

    private String salSkilllevel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
    }

    public String getSalName() {
        return salName;
    }

    public void setSalName(String salName) {
        this.salName = salName == null ? null : salName.trim();
    }

    public String getPostCategory() {
        return postCategory;
    }

    public void setPostCategory(String postCategory) {
        this.postCategory = postCategory == null ? null : postCategory.trim();
    }

    public Integer getSalId() {
        return salId;
    }

    public void setSalId(Integer salId) {
        this.salId = salId;
    }

    public String getSalDep() {
        return salDep;
    }

    public void setSalDep(String salDep) {
        this.salDep = salDep == null ? null : salDep.trim();
    }

    public String getSalPost() {
        return salPost;
    }

    public void setSalPost(String salPost) {
        this.salPost = salPost == null ? null : salPost.trim();
    }

    public Date getSalDate() {
        return salDate;
    }

    public void setSalDate(Date salDate) {
        this.salDate = salDate;
    }

    public String getSalOa() {
        return salOa;
    }

    public void setSalOa(String salOa) {
        this.salOa = salOa == null ? null : salOa.trim();
    }

    public String getStaCategory() {
        return staCategory;
    }

    public void setStaCategory(String staCategory) {
        this.staCategory = staCategory == null ? null : staCategory.trim();
    }

    public String getSalRemark() {
        return salRemark;
    }

    public void setSalRemark(String salRemark) {
        this.salRemark = salRemark == null ? null : salRemark.trim();
    }

    public String getSalSkilllevel() {
        return salSkilllevel;
    }

    public void setSalSkilllevel(String salSkilllevel) {
        this.salSkilllevel = salSkilllevel == null ? null : salSkilllevel.trim();
    }
}