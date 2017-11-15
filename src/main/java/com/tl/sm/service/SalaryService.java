package com.tl.sm.service;

import java.beans.IntrospectionException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;


public interface SalaryService {
	
	public void importExcelInfo(InputStream in, MultipartFile file, String salaryDate,Integer adminId)throws Exception;
	
	//public XSSFWorkbook exportExcelInfo(String salaryDate) throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException ; 
}
