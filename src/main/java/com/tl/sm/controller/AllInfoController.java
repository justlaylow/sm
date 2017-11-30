package com.tl.sm.controller;


import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tl.sm.pojo.AllInfo;
import com.tl.sm.pojo.Department;
import com.tl.sm.pojo.Employee;
import com.tl.sm.service.AllInfoService;
import com.tl.sm.service.EmployeeService;

@Controller
@Scope("prototype")
public class AllInfoController {
	@Resource
	private AllInfoService allInfoService;
	@Resource
	private EmployeeService employeeService;
	
	@RequestMapping("/allInfo")
	public String AllUpdate(AllInfo allInfo,HttpServletRequest request) {
		String AllUpdateMessage = allInfoService.AllUpdate(allInfo);
		request.setAttribute("AllUpdateMessage", AllUpdateMessage);
		return "allInfo";
	}
	
	@RequestMapping("/allInfo/del")
	public String deleteAll(String salId,HttpServletRequest request) {
		String AllUpdateMessage = allInfoService.deleteAll(salId);
		request.setAttribute("AllUpdateMessage", AllUpdateMessage);
		return "allInfo";
	}
	
	// 查询所有员工,保险,工资信息
	@RequestMapping("/list/all")
	public String listAll(String salId,String calDate,HttpServletRequest request) throws ParseException {
		List<Employee> ListAll = employeeService.listAll(calDate,salId);
		List<Department> listDep = employeeService.listDep();
		String maxMonth = allInfoService.maxMonth();
		request.setAttribute("maxMonth", maxMonth);
		request.setAttribute("listDep", listDep);
		request.setAttribute("listAll", ListAll);
		return "allInfo";
	}
}
