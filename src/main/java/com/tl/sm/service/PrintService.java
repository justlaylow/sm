package com.tl.sm.service;

import java.util.List;

import com.tl.sm.pojo.Employee;
import com.tl.sm.pojo.Summing;

public interface PrintService {
	//部门工资条
	public List<Employee> departmentSalary(String depName);
	
	//按部门统计
	public List<Summing> department();

	//按统计类别统计
	public List<Summing> category();
	
}
