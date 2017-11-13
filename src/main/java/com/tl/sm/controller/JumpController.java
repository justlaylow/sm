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
}
