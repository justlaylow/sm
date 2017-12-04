package com.tl.sm.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tl.sm.pojo.Employee;
import com.tl.sm.service.PrintService;

@Controller
@Scope("prototype")
public class PrintController {
	@Resource
	private PrintService printService;
	
	@RequestMapping("/departmentSalary")
	public String departmentSalary(String salDep,HttpServletRequest request) {
		List<Employee> listByDepName = printService.departmentSalary(salDep);
		request.setAttribute("listByDepName", listByDepName);
		return "print/printTemplate";
	}
}
