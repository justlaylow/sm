package com.tl.sm.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tl.sm.pojo.Salary;
import com.tl.sm.service.SalaryService;

@Controller
@Scope("prototype")
public class SalaryController {

	@Resource
	private SalaryService salaryService;
	
	// 查询所有员工和员工保险
	@RequestMapping("/list/sal")
	public String listSal(HttpServletRequest request) {
		List<Salary> salList = salaryService.listCal();
		request.setAttribute("salList", salList);
		return "salary";
	}

	// 新增员工
	@RequestMapping("/insert/sal")
	public String insertSal(Salary salary, HttpServletRequest request) {
		String insertSal = salaryService.insertCal(salary);
		List<Salary> salList = salaryService.listCal();
		request.setAttribute("salList", salList);
		request.setAttribute("insertSal", insertSal);
		return "salary";
	}

	// 修改员工
	@RequestMapping("/update/sal")
	public String updateSal(Salary salary, HttpServletRequest request) {
		String updateSal = salaryService.updateCal(salary);
		List<Salary> salList = salaryService.listCal();
		request.setAttribute("salList", salList);
		request.setAttribute("updateSal", updateSal);
		return "salary";
	}
	
	//删除员工
	@RequestMapping("/delete/sal")
	public String deleteSal(Integer id,HttpServletRequest request) {
		String deleteSal = salaryService.deleteCal(id);
		List<Salary> salList = salaryService.listCal();
		request.setAttribute("salList", salList);
		request.setAttribute("deleteSal", deleteSal);
		return "salary";
	}
	
	//模糊查询
	@RequestMapping("/blurry/sal")
	public String listInsBlurry(String calId,String calName,String calDate,String calId2,String calName2,String calDate2,HttpServletRequest request){
		List<Salary> salList = salaryService.listCalBlurry(calId, calName, calDate,calId2, calName2, calDate2);
		request.setAttribute("salList", salList);
		return "salary";
	}
		
		
}
