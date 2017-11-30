package com.tl.sm.service;

import java.beans.IntrospectionException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.tl.sm.pojo.Salary;


public interface SalaryService {
	
	//Excel导入预览集合
	public List<Salary> importExcelInfo(InputStream in, MultipartFile file, String salaryDate,Integer adminId)throws Exception;
	
	//Excel数据插入数据库
	public String importDB(List<Salary> list);
	
	//Excel导出
	public XSSFWorkbook exportExcelInfo(String calDate) throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException ; 
	
	//查询所有
	public List<Salary> listCal();
	
	//模糊查询
	public List<Salary> listCalBlurry(String calId,String calName,String calDate
			,String calId2,String calName2,String calDate2);
	
	//更新
	public String updateCal(Salary salary);
	
	//删除
	public String deleteCal(Integer id);
	
	//新增
	public String insertCal(Salary salary);
	
}
