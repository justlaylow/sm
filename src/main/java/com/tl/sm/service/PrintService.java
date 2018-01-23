package com.tl.sm.service;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tl.sm.pojo.Employee;
import com.tl.sm.pojo.SendBank;
import com.tl.sm.pojo.Summing;

public interface PrintService {
	//部门工资条
	public List<Employee> departmentSalary(String depName);
	
	//按部门统计
	public List<Summing> department();

	//按统计类别统计
	public List<Summing> category();
	
	//送银行文件
	public List<SendBank> sendBank();
	
	//送银行文件excel导出
	//Excel导出
	public XSSFWorkbook exportExcelInfo() throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException ;
	
	//汇总表excel导出(应发)
	public XSSFWorkbook exportExcelDepInfo() throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException;

	//统计表excel导出(应发)
		public XSSFWorkbook exportExcelCategoryShould() throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException;
		
	//汇总表excel导出(实得)
	public XSSFWorkbook exportExcelDepReality() throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException;
	
	//统计表excel导出(实得)
	public XSSFWorkbook exportExcelCategoryReality() throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException;
		
}
