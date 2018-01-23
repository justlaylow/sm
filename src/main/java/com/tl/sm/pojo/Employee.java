package com.tl.sm.pojo;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Employee {
    private Integer id;
    //技能等级工资
    private Float salSkillSalary;
    //银行账户
	private String bankAccount;
	//银行账号所属省份
	private String bankAddress;
	//姓名
    private String salName;
    //岗位类别
    private String postCategory;
    //工号
    private String salId;
    //部门
    private String salDep;
    //岗位
    private String salPost;
    //入职时间
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date salDate;
    //sap账号
    private String salOa;
    //统计类别
    private String staCategory;
    //备注
    private String salRemark;
    //技能等级
    private String salSkilllevel;
    
    //员工保险信息
    private List<Insurance> salInsuranceList;
    
    //员工工资信息
    private List<Salary> salSalaryList;
    

    
    public String getBankAddress() {
		return bankAddress;
	}

	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}
    public Float getSalSkillSalary() {
		return salSkillSalary;
	}

	public void setSalSkillSalary(Float salSkillSalary) {
		this.salSkillSalary = salSkillSalary;
	}

	public List<Salary> getSalSalaryList() {
		return salSalaryList;
	}

	public void setSalSalaryList(List<Salary> salSalaryList) {
		this.salSalaryList = salSalaryList;
	}

	public List<Insurance> getSalInsuranceList() {
		return salInsuranceList;
	}

	public void setSalInsuranceList(List<Insurance> salInsuranceList) {
		this.salInsuranceList = salInsuranceList;
	}

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

    public String getSalId() {
        return salId;
    }

    public void setSalId(String salId) {
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