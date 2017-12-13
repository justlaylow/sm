package com.tl.sm.util;

import java.util.List;

import com.tl.sm.pojo.Employee;
import com.tl.sm.pojo.Insurance;
import com.tl.sm.pojo.Salary;

public class excelList {
	private List<Salary> salaryList;
	private List<Insurance> insuranceList;
	private List<Employee> employeeList;

	public List<Insurance> getInsuranceList() {
		return insuranceList;
	}

	public void setInsuranceList(List<Insurance> insuranceList) {
		this.insuranceList = insuranceList;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public List<Salary> getSalaryList() {
		return salaryList;
	}

	public void setSalaryList(List<Salary> salaryList) {
		this.salaryList = salaryList;
	}
}
