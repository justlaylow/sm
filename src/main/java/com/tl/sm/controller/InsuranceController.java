package com.tl.sm.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tl.sm.pojo.Insurance;
import com.tl.sm.service.InsuranceService;

@Controller
@Scope("prototype")
public class InsuranceController {
	@Resource
	private InsuranceService insuranceService;
	
	//查询所有
	@RequestMapping("/select/ins")
	public String listIns(HttpServletRequest request){
		List<Insurance> listIns = insuranceService.listIns();
		request.setAttribute("listIns", listIns);
		return "insurance";
	}
	
	//新增
	@RequestMapping("/insert/ins")
	public String insertIns(Insurance insurance,HttpServletRequest request) {
		String insertInsMsg = insuranceService.insertIns(insurance);
		List<Insurance> listIns = insuranceService.listIns();
		request.setAttribute("listIns", listIns);
		request.setAttribute("insertInsMsg", insertInsMsg);
		return "insurance";
	}
	
	//更新
	@RequestMapping("/update/ins")
	public String updateIns(Insurance insurance,HttpServletRequest request) {
		String updateInsMsg = insuranceService.updateIns(insurance);
		List<Insurance> listIns = insuranceService.listIns();
		request.setAttribute("listIns", listIns);
		request.setAttribute("updateInsMsg", updateInsMsg);
		return "insurance";
	}
	
	//删除
	@RequestMapping("/delete/ins")
	public String deleteIns(Integer id,HttpServletRequest request) {
		String deleteInsMsg = insuranceService.deleteIns(id);
		List<Insurance> listIns = insuranceService.listIns();
		request.setAttribute("listIns", listIns);
		request.setAttribute("deleteInsMsg", deleteInsMsg);
		return "insurance";
	}
	
	//模糊查询
	@RequestMapping("/blurry/ins")
	public String listInsBlurry(String insId,String insName,HttpServletRequest request){
		List<Insurance> listIns = insuranceService.listInsBlurry(insId, insName);
		request.setAttribute("listIns", listIns);
		return "insurance";
	}
	

}
