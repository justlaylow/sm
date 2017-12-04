package com.tl.sm.service;

import java.util.List;

import com.tl.sm.pojo.Employee;

public interface PrintService {
	//部门工资条
	public List<Employee> departmentSalary(String depName);
	
	/*//统计类别(应发)
	public String categoryShould(String category);
	
	//统计类别(实发)
	public String categoryReality();
	
	//部门(应发)
	public String departmentShould();
	
	//部门(实发)
	public String departmentReality();*/
}
