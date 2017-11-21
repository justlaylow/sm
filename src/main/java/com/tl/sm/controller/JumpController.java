package com.tl.sm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpController {
	@RequestMapping("/dep")
	public String dep(HttpServletRequest request,HttpServletResponse response) {
		return "department";
	}
	
	@RequestMapping("/select")
	public String list(HttpServletRequest request,HttpServletResponse response) {
		return "emp";
	}
	
	@RequestMapping("/main")
	public String main(HttpServletRequest request,HttpServletResponse response) {
		return "main";
	}
	
	@RequestMapping("/salary")
	public String importExcel(HttpServletRequest request,HttpServletResponse response) {
		return "excel";
	}
	
	@RequestMapping("/insuranceAdd")
	public String insuranceAdd(HttpServletRequest request,HttpServletResponse response) {
		return "add/insuranceAdd";
	}
	
	@RequestMapping("/calculateAdd")
	public String calculateAdd(HttpServletRequest request,HttpServletResponse response) {
		return "add/calculateAdd";
	}
	
	@RequestMapping("/allInform")
	public String allInfo(HttpServletRequest request,HttpServletResponse response) {
		return "allInfo";
	}
	
	@RequestMapping("/exportExcel")
	public String exportExcel(HttpServletRequest request,HttpServletResponse response) {
		return "excelExport";
	}
}
