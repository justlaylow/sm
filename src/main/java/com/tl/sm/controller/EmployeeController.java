package com.tl.sm.controller;

import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tl.sm.pojo.Employee;
import com.tl.sm.pojo.Insurance;
import com.tl.sm.pojo.Salary;
import com.tl.sm.service.EmployeeService;

@Controller
@Scope("prototype")
public class EmployeeController {
	@Resource
	private EmployeeService employeeService;

	// 查询所有员工和员工保险
	@RequestMapping("/list/emp")
	public String listEmp(HttpServletRequest request) {
		List<Employee> empList = employeeService.listInner();
		request.setAttribute("empList", empList);
		return "employee";
	}

	// 新增员工
	@RequestMapping("/insert/emp")
	public String insertEmp(Employee employee, HttpServletRequest request) {
		String insertEmp = employeeService.insertEmp(employee);
		List<Employee> empList = employeeService.listInner();
		request.setAttribute("empList", empList);
		request.setAttribute("insertEmp", insertEmp);
		return "employee";
	}

	// 修改员工
	@RequestMapping("/update/emp")
	public String updateEmp(Employee employee, HttpServletRequest request) {
		String updateEmp = employeeService.updateEmp(employee);
		List<Employee> empList = employeeService.listInner();
		request.setAttribute("empList", empList);
		request.setAttribute("updateEmp", updateEmp);
		return "employee";
	}
	
	//删除员工
	@RequestMapping("/delete/emp")
	public String deleteEmp(String salId,HttpServletRequest request) {
		String deleteEmp = employeeService.deleteEmp(salId);
		List<Employee> empList = employeeService.listInner();
		request.setAttribute("empList", empList);
		request.setAttribute("deleteEmp", deleteEmp);
		return "employee";
	}
	
	//模糊查询
	@RequestMapping("/blurry/emp")
	public String blurryEmp(Employee employee,String salName,String salOa,String salId,HttpServletRequest request) {
		List<Employee> empList = employeeService.listEmpBlurry(salName, salId, salOa);
		request.setAttribute("empList", empList);
		return "employee";
	}
	
	// 查询所有员工,保险,工资信息
	@RequestMapping("/list/all")
	public String listAll(String salId,String calDate,HttpServletRequest request) throws ParseException {
		List<Employee> ListAll = employeeService.listAll(calDate,salId);
		request.setAttribute("listAll", ListAll);
		return "allInfo";
	}
	
	

}
