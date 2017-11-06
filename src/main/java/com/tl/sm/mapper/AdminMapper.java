package com.tl.sm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tl.sm.pojo.Admin;

public interface AdminMapper {
	public Admin getAdmin(@Param("adminname") String adminname,@Param("password") String password);
	
	public List<Admin> list();
	
	public int add(Admin admin);
}
