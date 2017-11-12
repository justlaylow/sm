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

    private Float salBasic;

    private Float salDues;

    private Float salManhour;

    private Float salPostsal;

    private Float endInsurance;

    private Float labourCost;

    private Float salCoef;

    private Float salBenefitwage;

    private Float salBonus;

    private Float salManhourBonus;

    private Float salManhourSalary;

    private Float salOvertime;

    private Float salBenefit;

    private Float salWelfare;

    private Float salCheck;

    private Float salHoliday;

    private Float salAbsence;

    private Float salOther;

    private Float salShould;

    private Float salHeathInsurance;

    private Float salUnemp;

    private Float salIll;

    private Float salConsume;

    private Float salPenalty;

    private Float salWithhold;

    private Float salWaste;

    private Float salWaterandele;

    private Float salAccFund;

    private Float salLastWithhold;

    private Float salIncometax;

    private Float salRealization;

    private Float salAllowance;

    private Float salYears;

    private Float salSecrecy;

    private String salSkilllevel;

    private Float salSkillsalary;

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

    public Float getSalBasic() {
        return salBasic;
    }

    public void setSalBasic(Float salBasic) {
        this.salBasic = salBasic;
    }

    public Float getSalDues() {
        return salDues;
    }

    public void setSalDues(Float salDues) {
        this.salDues = salDues;
    }

    public Float getSalManhour() {
        return salManhour;
    }

    public void setSalManhour(Float salManhour) {
        this.salManhour = salManhour;
    }

    public Float getSalPostsal() {
        return salPostsal;
    }

    public void setSalPostsal(Float salPostsal) {
        this.salPostsal = salPostsal;
    }

    public Float getEndInsurance() {
        return endInsurance;
    }

    public void setEndInsurance(Float endInsurance) {
        this.endInsurance = endInsurance;
    }

    public Float getLabourCost() {
        return labourCost;
    }

    public void setLabourCost(Float labourCost) {
        this.labourCost = labourCost;
    }

    public Float getSalCoef() {
        return salCoef;
    }

    public void setSalCoef(Float salCoef) {
        this.salCoef = salCoef;
    }

    public Float getSalBenefitwage() {
        return salBenefitwage;
    }

    public void setSalBenefitwage(Float salBenefitwage) {
        this.salBenefitwage = salBenefitwage;
    }

    public Float getSalBonus() {
        return salBonus;
    }

    public void setSalBonus(Float salBonus) {
        this.salBonus = salBonus;
    }

    public Float getSalManhourBonus() {
        return salManhourBonus;
    }

    public void setSalManhourBonus(Float salManhourBonus) {
        this.salManhourBonus = salManhourBonus;
    }

    public Float getSalManhourSalary() {
        return salManhourSalary;
    }

    public void setSalManhourSalary(Float salManhourSalary) {
        this.salManhourSalary = salManhourSalary;
    }

    public Float getSalOvertime() {
        return salOvertime;
    }

    public void setSalOvertime(Float salOvertime) {
        this.salOvertime = salOvertime;
    }

    public Float getSalBenefit() {
        return salBenefit;
    }

    public void setSalBenefit(Float salBenefit) {
        this.salBenefit = salBenefit;
    }

    public Float getSalWelfare() {
        return salWelfare;
    }

    public void setSalWelfare(Float salWelfare) {
        this.salWelfare = salWelfare;
    }

    public Float getSalCheck() {
        return salCheck;
    }

    public void setSalCheck(Float salCheck) {
        this.salCheck = salCheck;
    }

    public Float getSalHoliday() {
        return salHoliday;
    }

    public void setSalHoliday(Float salHoliday) {
        this.salHoliday = salHoliday;
    }

    public Float getSalAbsence() {
        return salAbsence;
    }

    public void setSalAbsence(Float salAbsence) {
        this.salAbsence = salAbsence;
    }

    public Float getSalOther() {
        return salOther;
    }

    public void setSalOther(Float salOther) {
        this.salOther = salOther;
    }

    public Float getSalShould() {
        return salShould;
    }

    public void setSalShould(Float salShould) {
        this.salShould = salShould;
    }

    public Float getSalHeathInsurance() {
        return salHeathInsurance;
    }

    public void setSalHeathInsurance(Float salHeathInsurance) {
        this.salHeathInsurance = salHeathInsurance;
    }

    public Float getSalUnemp() {
        return salUnemp;
    }

    public void setSalUnemp(Float salUnemp) {
        this.salUnemp = salUnemp;
    }

    public Float getSalIll() {
        return salIll;
    }

    public void setSalIll(Float salIll) {
        this.salIll = salIll;
    }

    public Float getSalConsume() {
        return salConsume;
    }

    public void setSalConsume(Float salConsume) {
        this.salConsume = salConsume;
    }

    public Float getSalPenalty() {
        return salPenalty;
    }

    public void setSalPenalty(Float salPenalty) {
        this.salPenalty = salPenalty;
    }

    public Float getSalWithhold() {
        return salWithhold;
    }

    public void setSalWithhold(Float salWithhold) {
        this.salWithhold = salWithhold;
    }

    public Float getSalWaste() {
        return salWaste;
    }

    public void setSalWaste(Float salWaste) {
        this.salWaste = salWaste;
    }

    public Float getSalWaterandele() {
        return salWaterandele;
    }

    public void setSalWaterandele(Float salWaterandele) {
        this.salWaterandele = salWaterandele;
    }

    public Float getSalAccFund() {
        return salAccFund;
    }

    public void setSalAccFund(Float salAccFund) {
        this.salAccFund = salAccFund;
    }

    public Float getSalLastWithhold() {
        return salLastWithhold;
    }

    public void setSalLastWithhold(Float salLastWithhold) {
        this.salLastWithhold = salLastWithhold;
    }

    public Float getSalIncometax() {
        return salIncometax;
    }

    public void setSalIncometax(Float salIncometax) {
        this.salIncometax = salIncometax;
    }

    public Float getSalRealization() {
        return salRealization;
    }

    public void setSalRealization(Float salRealization) {
        this.salRealization = salRealization;
    }

    public Float getSalAllowance() {
        return salAllowance;
    }

    public void setSalAllowance(Float salAllowance) {
        this.salAllowance = salAllowance;
    }

    public Float getSalYears() {
        return salYears;
    }

    public void setSalYears(Float salYears) {
        this.salYears = salYears;
    }

    public Float getSalSecrecy() {
        return salSecrecy;
    }

    public void setSalSecrecy(Float salSecrecy) {
        this.salSecrecy = salSecrecy;
    }

    public String getSalSkilllevel() {
        return salSkilllevel;
    }

    public void setSalSkilllevel(String salSkilllevel) {
        this.salSkilllevel = salSkilllevel == null ? null : salSkilllevel.trim();
    }

    public Float getSalSkillsalary() {
        return salSkillsalary;
    }

    public void setSalSkillsalary(Float salSkillsalary) {
        this.salSkillsalary = salSkillsalary;
    }
}