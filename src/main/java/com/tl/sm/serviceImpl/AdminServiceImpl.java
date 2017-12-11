package com.tl.sm.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tl.sm.mapper.AdminMapper;
import com.tl.sm.pojo.Admin;
import com.tl.sm.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	@Resource
	private AdminMapper adminMapper;
	
	//验证登陆，用户名和密码
	public Admin checkLogin(String adminname,String password) {
		Admin admin = adminMapper.getAdmin(adminname, password);
		if(admin!=null&&admin.getAdm_pass().equals(password)) {
			return admin;
		}
		return null;
	}
}
