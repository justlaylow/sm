package com.tl.sm.service;

import com.tl.sm.pojo.Admin;

public interface AdminService {
	//登陆验证
	public Admin checkLogin(String adminname,String password);
}
