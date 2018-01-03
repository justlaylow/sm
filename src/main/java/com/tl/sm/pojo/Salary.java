package com.tl.sm.pojo;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 工资信息实体类
 * */
public class Salary {
    private Integer id;
    //sap账号
    private String calHr;
    //工号
    private String calId;
    //姓名
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
    //工资时间
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
    //员工信息
    private List<Employee> calEmployee;

    public List<Employee> getCalEmployee() {
		return calEmployee;
	}

	public void setCalEmployee(List<Employee> calEmployee) {
		this.calEmployee = calEmployee;
	}

	public Float getCalTotal() {
		return calTotal;
	}

	public void setCalTotal(Float calTotal) {
		this.calTotal = calTotal;
	}
	
	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        this.calName = calName == null ? null : calName.trim();
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
}