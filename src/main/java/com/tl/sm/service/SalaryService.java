package com.tl.sm.service;

import java.util.Date;
import java.util.List;

import com.tl.sm.pojo.Salary;

public interface SalaryService {
	
	//模糊查询
	public List<Salary> listSalBlurry(int calId,int calHr,Date calDate,String calName);
	
	//工资计算
	public String SalaryCalculate(Salary salary); 
	
	//工资数据导入
	
	//工资数据导出
}
