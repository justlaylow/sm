package com.tl.sm.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tl.sm.mapper.EmployeeMapper;
import com.tl.sm.pojo.Employee;
import com.tl.sm.service.PrintService;
@Service
public class PrintServiceImpl implements PrintService{
	@Resource
	private EmployeeMapper printMapper;
	
	//部门工资条
	public List<Employee> departmentSalary(String depName) {
		List<Employee> listall = printMapper.printByDepName(depName);
		return listall;
	}

	/*@Override
	public String categoryShould() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String categoryReality() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String departmentShould() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String departmentReality() {
		// TODO Auto-generated method stub
		return null;
	}*/

}
