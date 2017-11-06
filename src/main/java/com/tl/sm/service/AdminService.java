package com.tl.sm.service;

import com.tl.sm.pojo.Admin;

public interface AdminService {
	public Admin checkLogin(String adminname,String password);
}
