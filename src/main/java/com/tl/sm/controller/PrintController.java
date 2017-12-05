package com.tl.sm.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tl.sm.mapper.AllInfoMapper;
import com.tl.sm.pojo.Employee;
import com.tl.sm.pojo.Summing;
import com.tl.sm.service.PrintService;

@Controller
@Scope("prototype")
public class PrintController {
	@Resource
	private PrintService printService;
	@Resource
	private AllInfoMapper allInfoMapper;//查询工资最大月份
	//部门工资条
	@RequestMapping("/departmentSalary")
	public String departmentSalary(String salDep,HttpServletRequest request) {
		List<Employee> listByDepName = printService.departmentSalary(salDep);
		List<Summing> sumList = printService.department();
		Summing sum = new Summing();
		for(Summing s:sumList) {
			if(s.getDepartment().equals(salDep)) {
				sum = s;
			}
		}
		request.setAttribute("summing", sum);
		request.setAttribute("listByDepName", listByDepName);
		return "print/printTemplate";
	}
	
	//按部门统计应发
	@RequestMapping("/departmentShould")
	public String departmentShould(HttpServletRequest request) {
		List<Summing> departmentShould = printService.department();
		String maxMonth = allInfoMapper.selectMaxDate().substring(5, 7);
		request.setAttribute("maxMonth", maxMonth);
		request.setAttribute("departmentShould", departmentShould);
		return "print/departmentShould";
	}
	
	//按部门统计实发
	@RequestMapping("/departmentReality")
	public String departmentReality(HttpServletRequest request) {
		List<Summing> departmentReality = printService.department();
		String maxMonth = allInfoMapper.selectMaxDate().substring(5, 7);
		request.setAttribute("maxMonth", maxMonth);
		request.setAttribute("departmentReality", departmentReality);
		return "print/departmentReality";
	}
	
	//按统计类别统计应发
	@RequestMapping("/categoryShould")
	public String categoryShould(HttpServletRequest request) {
		List<Summing> categoryShould = printService.category();
		String maxMonth = allInfoMapper.selectMaxDate().substring(5, 7);
		request.setAttribute("maxMonth", maxMonth);
		request.setAttribute("categoryShould", categoryShould);
		return "print/categoryShould";
	}
	
	//按统计类别统计实发
	@RequestMapping("/categoryReality")
	public String categoryReality(HttpServletRequest request) {
		List<Summing> categoryReality = printService.category();
		String maxMonth = allInfoMapper.selectMaxDate().substring(5, 7);
		request.setAttribute("maxMonth", maxMonth);
		request.setAttribute("categoryReality", categoryReality);
		return "print/categoryReality";
	}
}
