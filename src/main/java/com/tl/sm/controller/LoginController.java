package com.tl.sm.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tl.sm.pojo.Admin;
import com.tl.sm.service.AdminService;

@Controller
@Scope("prototype")
@RequestMapping("admin")
public class LoginController {
	@Resource
	private AdminService adminService;

	//登陆
	@RequestMapping(value = "login")
	public ModelAndView login(String loginname, String password, ModelAndView mv, HttpSession session) {
		Admin admin = adminService.checkLogin(loginname, password);
		if (admin != null) {
			// 登录成功，将user对象设置到HttpSession作用范围域中
			session.setAttribute("admin", admin);
			/*// 转发到main请求
			mv.setView(new RedirectView("main"));*/
			mv.setViewName("main");
		} else {
			// 登录失败，设置失败信息，并调转到登录页面

			mv.addObject("message", "登录名和密码错误，请重新输入");
			mv.setViewName("fail");
		}
		return mv;
	}
}
