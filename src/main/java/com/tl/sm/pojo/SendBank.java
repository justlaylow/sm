package com.tl.sm.pojo;
/**
 * 送银行文件
 * */
public class SendBank {
	//银行账户
	private String bankAccount;
	//姓名
	private String salName;
	//实得工资
	private Float calResult;
	//银行账号所属省份
	private String bankAddress;
	
	public String getBankAddress() {
		return bankAddress;
	}
	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
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
	public Float getCalResult() {
		return calResult;
	}
	public void setCalResult(Float calResult) {
		this.calResult = calResult;
	}
}
