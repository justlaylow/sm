package com.tl.sm.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ExcelExport {
	private String bankAccount;

    private String salName;

    private String postCategory;

    private String salId;

    private String salDep;

    private String salPost;

    private String salOa;

    private String staCategory;

    private String salSkilllevel;
    
    private String salRemark;
    
	private String calHr;

    private String calId;

    private String calName;

    private Float calBasic;

    private Float calPost;

    private Float calFloat;

    private Float calCoefficient;

    private Float calSecrecy;

    private Float calSkillLevel;

    private Float calComage;

    private Float calBonus;

    private Float calOvertime;

    private Float calBenefit;

    private Float calCheck;

    private Float calInjury;

    private Float calLeave;

    private Float calOther;

    private Float calPenalty;

    private Float calWithhold;

    private Float calWaterandele;

    private Float calAllowance;

    private Float calResult;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date calDate;

    private Float calDues;

    private Float calManhour;

    private Float labourCost;

    private Float calBenefitwage;

    private Float calManhourBonus;

    private Float calManhourSalary;

    private Float calWelfare;

    private Float calShould;

    private Float calWaste;
    
    private Float calTotal;

	private Float calLastWithhold;

    private Float calIncometax;
    
    private String insIden;

    private String insAddress;

    private String insCarNumber;

    private String insOldId;

    private String insOld;

    private String insTreatmentId;

    private String insTreatments;

    private String insIllId;

    private String insIll;

    private String insurance;

    private String insUnempId;

    private String insUnemp;

    private String insUnempAddress;

    private String insAccFund;

    private String insAccAddress;

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getSalName() {
		return salName;
	}

	public void setSalName(String salName) {
		this.salName = salName;
	}

	public String getPostCategory() {
		return postCategory;
	}

	public void setPostCategory(String postCategory) {
		this.postCategory = postCategory;
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
		this.salDep = salDep;
	}

	public String getSalPost() {
		return salPost;
	}

	public void setSalPost(String salPost) {
		this.salPost = salPost;
	}

	public String getSalOa() {
		return salOa;
	}

	public void setSalOa(String salOa) {
		this.salOa = salOa;
	}

	public String getStaCategory() {
		return staCategory;
	}

	public void setStaCategory(String staCategory) {
		this.staCategory = staCategory;
	}

	public String getSalSkilllevel() {
		return salSkilllevel;
	}

	public void setSalSkilllevel(String salSkilllevel) {
		this.salSkilllevel = salSkilllevel;
	}

	public String getCalHr() {
		return calHr;
	}

	public void setCalHr(String calHr) {
		this.calHr = calHr;
	}

	public String getCalId() {
		return calId;
	}

	public void setCalId(String calId) {
		this.calId = calId;
	}

	public String getCalName() {
		return calName;
	}

	public void setCalName(String calName) {
		this.calName = calName;
	}

	public Float getCalBasic() {
		return calBasic;
	}

	public void setCalBasic(Float calBasic) {
		this.calBasic = calBasic;
	}

	public Float getCalPost() {
		return calPost;
	}

	public void setCalPost(Float calPost) {
		this.calPost = calPost;
	}

	public Float getCalFloat() {
		return calFloat;
	}

	public void setCalFloat(Float calFloat) {
		this.calFloat = calFloat;
	}

	public Float getCalCoefficient() {
		return calCoefficient;
	}

	public void setCalCoefficient(Float calCoefficient) {
		this.calCoefficient = calCoefficient;
	}

	public Float getCalSecrecy() {
		return calSecrecy;
	}

	public void setCalSecrecy(Float calSecrecy) {
		this.calSecrecy = calSecrecy;
	}

	public Float getCalSkillLevel() {
		return calSkillLevel;
	}

	public void setCalSkillLevel(Float calSkillLevel) {
		this.calSkillLevel = calSkillLevel;
	}

	public Float getCalComage() {
		return calComage;
	}

	public void setCalComage(Float calComage) {
		this.calComage = calComage;
	}

	public Float getCalBonus() {
		return calBonus;
	}

	public void setCalBonus(Float calBonus) {
		this.calBonus = calBonus;
	}

	public Float getCalOvertime() {
		return calOvertime;
	}

	public void setCalOvertime(Float calOvertime) {
		this.calOvertime = calOvertime;
	}

	public Float getCalBenefit() {
		return calBenefit;
	}

	public void setCalBenefit(Float calBenefit) {
		this.calBenefit = calBenefit;
	}

	public Float getCalCheck() {
		return calCheck;
	}

	public void setCalCheck(Float calCheck) {
		this.calCheck = calCheck;
	}

	public Float getCalInjury() {
		return calInjury;
	}

	public void setCalInjury(Float calInjury) {
		this.calInjury = calInjury;
	}

	public Float getCalLeave() {
		return calLeave;
	}

	public void setCalLeave(Float calLeave) {
		this.calLeave = calLeave;
	}

	public Float getCalOther() {
		return calOther;
	}

	public void setCalOther(Float calOther) {
		this.calOther = calOther;
	}

	public Float getCalPenalty() {
		return calPenalty;
	}

	public void setCalPenalty(Float calPenalty) {
		this.calPenalty = calPenalty;
	}

	public Float getCalWithhold() {
		return calWithhold;
	}

	public void setCalWithhold(Float calWithhold) {
		this.calWithhold = calWithhold;
	}

	public Float getCalWaterandele() {
		return calWaterandele;
	}

	public void setCalWaterandele(Float calWaterandele) {
		this.calWaterandele = calWaterandele;
	}

	public Float getCalAllowance() {
		return calAllowance;
	}

	public void setCalAllowance(Float calAllowance) {
		this.calAllowance = calAllowance;
	}

	public Float getCalResult() {
		return calResult;
	}

	public void setCalResult(Float calResult) {
		this.calResult = calResult;
	}

	public Date getCalDate() {
		return calDate;
	}

	public void setCalDate(Date calDate) {
		this.calDate = calDate;
	}

	public Float getCalDues() {
		return calDues;
	}

	public void setCalDues(Float calDues) {
		this.calDues = calDues;
	}

	public Float getCalManhour() {
		return calManhour;
	}

	public void setCalManhour(Float calManhour) {
		this.calManhour = calManhour;
	}

	public Float getLabourCost() {
		return labourCost;
	}

	public void setLabourCost(Float labourCost) {
		this.labourCost = labourCost;
	}

	public Float getCalBenefitwage() {
		return calBenefitwage;
	}

	public void setCalBenefitwage(Float calBenefitwage) {
		this.calBenefitwage = calBenefitwage;
	}

	public Float getCalManhourBonus() {
		return calManhourBonus;
	}

	public void setCalManhourBonus(Float calManhourBonus) {
		this.calManhourBonus = calManhourBonus;
	}

	public Float getCalManhourSalary() {
		return calManhourSalary;
	}

	public void setCalManhourSalary(Float calManhourSalary) {
		this.calManhourSalary = calManhourSalary;
	}

	public Float getCalWelfare() {
		return calWelfare;
	}

	public void setCalWelfare(Float calWelfare) {
		this.calWelfare = calWelfare;
	}

	public Float getCalShould() {
		return calShould;
	}

	public void setCalShould(Float calShould) {
		this.calShould = calShould;
	}

	public Float getCalWaste() {
		return calWaste;
	}

	public void setCalWaste(Float calWaste) {
		this.calWaste = calWaste;
	}

	public Float getCalTotal() {
		return calTotal;
	}

	public void setCalTotal(Float calTotal) {
		this.calTotal = calTotal;
	}

	public Float getCalLastWithhold() {
		return calLastWithhold;
	}

	public void setCalLastWithhold(Float calLastWithhold) {
		this.calLastWithhold = calLastWithhold;
	}

	public Float getCalIncometax() {
		return calIncometax;
	}

	public void setCalIncometax(Float calIncometax) {
		this.calIncometax = calIncometax;
	}

	public String getInsIden() {
		return insIden;
	}

	public void setInsIden(String insIden) {
		this.insIden = insIden;
	}

	public String getInsAddress() {
		return insAddress;
	}

	public void setInsAddress(String insAddress) {
		this.insAddress = insAddress;
	}

	public String getInsCarNumber() {
		return insCarNumber;
	}

	public void setInsCarNumber(String insCarNumber) {
		this.insCarNumber = insCarNumber;
	}

	public String getInsOldId() {
		return insOldId;
	}

	public void setInsOldId(String insOldId) {
		this.insOldId = insOldId;
	}

	public String getInsOld() {
		return insOld;
	}

	public void setInsOld(String insOld) {
		this.insOld = insOld;
	}

	public String getInsTreatmentId() {
		return insTreatmentId;
	}

	public void setInsTreatmentId(String insTreatmentId) {
		this.insTreatmentId = insTreatmentId;
	}

	public String getInsTreatments() {
		return insTreatments;
	}

	public void setInsTreatments(String insTreatments) {
		this.insTreatments = insTreatments;
	}

	public String getInsIllId() {
		return insIllId;
	}

	public void setInsIllId(String insIllId) {
		this.insIllId = insIllId;
	}

	public String getInsIll() {
		return insIll;
	}

	public void setInsIll(String insIll) {
		this.insIll = insIll;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public String getInsUnempId() {
		return insUnempId;
	}

	public void setInsUnempId(String insUnempId) {
		this.insUnempId = insUnempId;
	}

	public String getInsUnemp() {
		return insUnemp;
	}

	public void setInsUnemp(String insUnemp) {
		this.insUnemp = insUnemp;
	}

	public String getInsUnempAddress() {
		return insUnempAddress;
	}

	public void setInsUnempAddress(String insUnempAddress) {
		this.insUnempAddress = insUnempAddress;
	}

	public String getInsAccFund() {
		return insAccFund;
	}

	public void setInsAccFund(String insAccFund) {
		this.insAccFund = insAccFund;
	}

	public String getInsAccAddress() {
		return insAccAddress;
	}

	public void setInsAccAddress(String insAccAddress) {
		this.insAccAddress = insAccAddress;
	}
	public String getSalRemark() {
		return salRemark;
	}

	public void setSalRemark(String salRemark) {
		this.salRemark = salRemark;
	}
}
