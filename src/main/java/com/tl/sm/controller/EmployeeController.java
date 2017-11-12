package com.tl.sm.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tl.sm.pojo.Department;
import com.tl.sm.pojo.Employee;
import com.tl.sm.service.EmployeeService;

@Controller
@Scope("prototype")
public class EmployeeController {
	@Resource
	private EmployeeService employeeService;

	// 查询所有员工
	@RequestMapping("/list/emp")
	public String listEmp(HttpServletRequest request) {
		List<Employee> empList = employeeService.listEmp();
		request.setAttribute("empList", empList);
		return "employee";
	}

	// 新增员工
	@RequestMapping("/insert/emp")
	public String insertEmp(Employee employee, HttpServletRequest request) {
		String insertEmp = employeeService.insertEmp(employee);
		List<Employee> empList = employeeService.listEmp();
		request.setAttribute("empList", empList);
		request.setAttribute("insertEmp", insertEmp);
		return "employee";
	}

	// 修改员工
	@RequestMapping("/update/emp")
	public String updateEmp(Employee employee, HttpServletRequest request) {
		String updateEmp = employeeService.updateEmp(employee);
		List<Employee> empList = employeeService.listEmp();
		request.setAttribute("empList", empList);
		request.setAttribute("updateEmp", updateEmp);
		return "employee";
	}
	
	//删除员工
	@RequestMapping("/delete/emp")
	public String deleteEmp(Integer id,HttpServletRequest request) {
		String deleteEmp = employeeService.deleteEmp(id);
		List<Employee> empList = employeeService.listEmp();
		request.setAttribute("empList", empList);
		request.setAttribute("deleteEmp", deleteEmp);
		return "employee";
	}
	
	//模糊查询
	@RequestMapping("/blurry/emp")
	public String blurryEmp(Employee employee,String salName,String salOa,Integer salId,HttpServletRequest request) {
		List<Employee> empList = employeeService.listEmpBlurry(salName, salId, salOa);
		request.setAttribute("empList", empList);
		return "employee";
	}

}
