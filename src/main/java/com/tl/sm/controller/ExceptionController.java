package com.tl.sm.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tl.sm.pojo.BusinessException;
import com.tl.sm.pojo.ParameterException;
import com.tl.sm.service.ExceptionService;

@Controller
public class ExceptionController {
	@Resource
	private ExceptionService exceptionService;
	
	@RequestMapping("/controller")
	public void controller(HttpServletRequest request,Integer id) throws Exception{
		switch(id) {
		case 1:
			throw new BusinessException("10","controller10");
		case 2:
			throw new BusinessException("20","controller20");
		case 3:
			throw new BusinessException("30","controller30");
		case 4:
			throw new BusinessException("40","controller40");
		case 5:
			throw new BusinessException("50","controller50");
		default:
			throw new ParameterException("controller parameter error");
		}
	}
	
	@RequestMapping("/service")
	public void service(HttpServletRequest request,Integer id) throws Exception{
		exceptionService.exception(id);
	}
	
	@RequestMapping("/dao")
	public void dao(HttpServletRequest request,Integer id) throws Exception{
		exceptionService.dao(id);
	}
	
	
}
