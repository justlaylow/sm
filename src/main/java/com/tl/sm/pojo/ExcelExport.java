package com.tl.sm.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 工资导出实体类
 * */

public class ExcelExport {
	//银行账户
	private String bankAccount;
	//姓名(员工表)
    private String salName;
    //岗位类别
    private String postCategory;
    //工号(员工表)
    private String salId;
    //部门
    private String salDep;
    //岗位
    private String salPost;
    //sap账号
    private String salOa;
    //统计类别
    private String staCategory;
    //技能等级
    private String salSkilllevel;
    //备注
    private String salRemark;
    //sap账号
	private String calHr;
    //工号(工资表)
    private String calId;
    //姓名(工资表)
    private String calName;
    //基本工资
    private Float calBasic;
    //岗位工资
    private Float calPost;
    //浮动工资
    private Float calFloat;
    //系数
    private Float calCoefficient;
    //保密工资
    private Float calSecrecy;
    //技能等级工资
    private Float calSkillLevel;
    //司龄工资
    private Float calComage;
    //奖金
    private Float calBonus;
    //加班工资
    private Float calOvertime;
    //津贴
    private Float calBenefit;
    //考评工资
    private Float calCheck;
    //工伤工资
    private Float calInjury;
    //缺勤
    private Float calLeave;
    //其他
    private Float calOther;
    //罚款
    private Float calPenalty;
    //扣款
    private Float calWithhold;
    //水电
    private Float calWaterandele;
    //餐补
    private Float calAllowance;
    //实得工资
    private Float calResult;
    //工资日期
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date calDate;
    //会费
    private Float calDues;
    //工时
    private Float calManhour;
    //工价
    private Float labourCost;
    //效益工资
    private Float calBenefitwage;
    //工时奖(没有使用)
    private Float calManhourBonus;
    //工时工资
    private Float calManhourSalary;
    //福利(没有使用)
    private Float calWelfare;
    //应发工资
    private Float calShould;
    //工废(没有使用)
    private Float calWaste;
    //工资合计
    private Float calTotal;
    //下月扣款
	private Float calLastWithhold;
    //所得税
    private Float calIncometax;
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
    //公积投保地
    private String insAccAddress;
    //医保投保地
    private String insSign;

	public String getInsSign() {
		return insSign;
	}

	public void setInsSign(String insSign) {
		this.insSign = insSign;
	}

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
