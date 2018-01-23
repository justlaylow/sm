package com.tl.sm.service;

import java.io.InputStream;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.tl.sm.pojo.Department;
import com.tl.sm.pojo.Employee;
import com.tl.sm.util.PageBean;

public interface EmployeeService {
	
	//查询所有员工
	public List<Employee> listEmp();
	
	//查询部门
	public List<Department> listDep();
	
	//查询所有员工和保险
	public List<Employee> listInner();
	
	//增加员工
	public String insertEmp(Employee employee) throws SQLIntegrityConstraintViolationException;
	
	//删除员工
	public String deleteEmp(String id);
	
	//修改员工信息
	public String updateEmp(Employee employee);
	
	//模糊查询
	public List<Employee> listEmpBlurry(String name,String id,String oa,String name2,String id2,String oa2);
	
	//查询员工，保险，工资信息
	public List<Employee> listAll(String calDate,String salId,String salName);
	
	//Excel导入预览集合
	public List<Employee> importExcelInfo(InputStream in, MultipartFile file, Integer adminId)throws Exception;
	
	//Excel数据插入数据库
	public String importDB(List<Employee> list);
	
	//分页
	public  PageBean<Employee> paging(int pageNum,int pageSize);
	
	
}
