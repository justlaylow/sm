package com.tl.sm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tl.sm.pojo.Admin;

public interface AdminMapper {
	//查询
	public Admin getAdmin(@Param("adminname") String adminname,@Param("password") String password);
	//查询所有
	public List<Admin> list();
	//新增用户
	public int add(Admin admin);
}
