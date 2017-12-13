package com.tl.sm.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tl.sm.mapper.DepartmentMapper;
import com.tl.sm.pojo.Department;


@Controller
public class JumpController {
	@Resource
	private DepartmentMapper departmentMapper;
	
	//跳转到部门页面
	@RequestMapping("/dep")
	public String dep(HttpServletRequest request,HttpServletResponse response) {
		return "department";
	}
	
	@RequestMapping("/select")
	public String list(HttpServletRequest request,HttpServletResponse response) {
		return "emp";
	}
	
	//跳转到主页面
	@RequestMapping("/main")
	public String main(HttpServletRequest request,HttpServletResponse response) {
		return "main";
	}
	
	//跳转到excel导入页面
	@RequestMapping("/salary")
	public String importExcel(HttpServletRequest request,HttpServletResponse response) {
		return "excel";
	}
	
	//跳转到新增保险信息页面
	@RequestMapping("/insuranceAdd")
	public String insuranceAdd(HttpServletRequest request,HttpServletResponse response) {
		return "add/insuranceAdd";
	}
	
	//跳转到新增工资信息页面
	@RequestMapping("/calculateAdd")
	public String calculateAdd(HttpServletRequest request,HttpServletResponse response) {
		return "add/calculateAdd";
	}
	
	//跳转到查询所有信息页面,员工,保险,工资信息
	@RequestMapping("/allInform")
	public String allInfo(HttpServletRequest request,HttpServletResponse response) {
		return "allInfo";
	}
	
	//跳转带excel导出页面
	@RequestMapping("/exportExcel")
	public String exportExcel(HttpServletRequest request,HttpServletResponse response) {
		return "excelExport";
	}
	
	//跳转到选择excel文件页面,用于保险更新预览
	@RequestMapping("/insUpdateFile")
	public String insUpdateFile(HttpServletRequest request,HttpServletResponse response) {
		return "insuranceFile";
	}
	
	//跳转到选择excel文件页面,用于保险导入预览
	@RequestMapping("/insImportFile")
	public String insImportFile(HttpServletRequest request,HttpServletResponse response) {
		return "import/insuranceImportFile";
	}
	
	//跳转到选择excel文件页面,用于保险导入预览
	@RequestMapping("/empImportFile")
	public String empImportFile(HttpServletRequest request,HttpServletResponse response) {
		return "import/employeeFile";
	}
	
	//跳转到打印页面
	@RequestMapping("/print")
	public String print(HttpServletRequest request,HttpServletResponse response) {
		List<Department> listDep = departmentMapper.listAll();
		request.setAttribute("listDep", listDep);
		return "print";
	}
}
