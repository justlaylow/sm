package com.tl.sm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tl.sm.pojo.Salary;
import com.tl.sm.service.AllInfoService;
import com.tl.sm.service.SalaryService;
import com.tl.sm.util.SalaryList;

@Controller
@Scope("prototype")
public class SalaryController {
	@Resource
	private AllInfoService allInfoService;
	@Resource
	private SalaryService salaryService;
	/**
	 * 员工工资管理
	 * */
	// 查询员工工资
	@RequestMapping("/list/sal")
	public String listSal(HttpServletRequest request) {
		List<Salary> salList = salaryService.listCal();
		String maxMonth = allInfoService.maxMonth();
		Date dt = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dt = format.parse(maxMonth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("maxMonth", dt);
		request.setAttribute("salList", salList);
		return "salary";
	}

	// 新增员工工资信息
	@RequestMapping("/insert/sal")
	public String insertSal(Salary salary, HttpServletRequest request) {
		String insertSal = salaryService.insertCal(salary);
		List<Salary> salList = salaryService.listCal();
		String maxMonth = allInfoService.maxMonth();
		Date dt = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dt = format.parse(maxMonth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("maxMonth", dt);
		request.setAttribute("salList", salList);
		request.setAttribute("insertSal", insertSal);
		return "salary";
	}

	// 修改员工工资信息
	@RequestMapping("/update/sal")
	public String updateSal(Salary salary, HttpServletRequest request) {
		String updateSal = salaryService.updateCal(salary);
		List<Salary> salList = salaryService.listCal();
		request.setAttribute("salList", salList);
		request.setAttribute("updateSal", updateSal);
		return "salary";
	}
	
	//删除员工工资信息
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
		String maxMonth = allInfoService.maxMonth();
		Date dt = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dt = format.parse(maxMonth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("maxMonth", dt);
		request.setAttribute("salList", salList);
		return "salary";
	}
	
	//批量更新,直接接收页面上的数据修改
	@RequestMapping("/updateBatch/sal")
	public String updateBatch(SalaryList salary,HttpServletRequest request) {
		List<Salary> list = salary.getSalary();
		String updateInsBatchMsg = salaryService.updateBatch(list);
		List<Salary> salList = salaryService.listCal();
		String maxMonth = allInfoService.maxMonth();
		Date dt = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dt = format.parse(maxMonth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("maxMonth", dt);
		request.setAttribute("salList", salList);
		request.setAttribute("updateInsBatchMsg", updateInsBatchMsg);
		return "salary";
	}
		
		
}
