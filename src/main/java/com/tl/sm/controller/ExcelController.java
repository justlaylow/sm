package com.tl.sm.controller;

import java.beans.IntrospectionException;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tl.sm.service.SalaryService;

@Controller
@Scope("prototype")
public class ExcelController {
	@Resource
	private SalaryService salaryService;

	@RequestMapping("/import")
	public String impotr(HttpServletRequest request, Model model) throws Exception {
		int adminId = 1;
		// 获取上传的文件
		MultipartHttpServletRequest multipart = (MultipartHttpServletRequest) request;
		MultipartFile file = multipart.getFile("upfile");
		String month = request.getParameter("calDate");
		InputStream in = file.getInputStream();
		// 数据导入
		salaryService.importExcelInfo(in, file, month, adminId);
		in.close();
		return "main";
	}

	
}