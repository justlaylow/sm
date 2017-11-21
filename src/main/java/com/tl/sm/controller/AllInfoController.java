package com.tl.sm.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tl.sm.pojo.AllInfo;
import com.tl.sm.service.AllInfoService;

@Controller
@Scope("prototype")
public class AllInfoController {
	@Resource
	private AllInfoService allInfoService;
	
	@RequestMapping("/allInfo")
	public String AllUpdate(AllInfo allInfo,HttpServletRequest request) {
		String AllUpdateMessage = allInfoService.AllUpdate(allInfo);
		request.setAttribute("AllUpdateMessage", AllUpdateMessage);
		return "allInfo";
	}
	
	@RequestMapping("/allInfo/del")
	public String deleteAll(String salId,HttpServletRequest request) {
		String AllUpdateMessage = allInfoService.deleteAll(salId);
		request.setAttribute("AllUpdateMessage", AllUpdateMessage);
		return "allInfo";
	}
}
