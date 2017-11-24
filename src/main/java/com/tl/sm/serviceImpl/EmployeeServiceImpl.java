package com.tl.sm.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tl.sm.mapper.EmployeeMapper;
import com.tl.sm.mapper.InsuranceMapper;
import com.tl.sm.mapper.SalaryMapper;
import com.tl.sm.pojo.Department;
import com.tl.sm.pojo.Employee;
import com.tl.sm.pojo.Insurance;
import com.tl.sm.pojo.Salary;
import com.tl.sm.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Resource
	private EmployeeMapper employeeMapper;

	// 查询所有员工
	public List<Employee> listEmp() {
		List<Employee> empList = employeeMapper.listEmp();
		return empList;
	}
	
	//查询部门
	public List<Department> listDep(){
		List<Department> listDep = employeeMapper.listDep();
		return listDep;
	}
	
	// 查询所有员工和员工保险
	public List<Employee> listInner() {
		List<Employee> empList = employeeMapper.listInner();
		return empList;
	}

	// 新增员工
	public String insertEmp(Employee employee) {
		String message = "";
		int i = employeeMapper.insert(employee);
		if (i > 0) {
			message = "添加成功";
		} else {
			message = "添加失败";
		}
		return message;
	}

	// 修改员工
	public String updateEmp(Employee employee) {
		String message = "";
		int i = employeeMapper.updateByPrimaryKeySelective(employee);
		if (i > 0) {
			message = "修改成功";
		} else {
			message = "修改失败";
		}
		return message;
	}
	
	//删除员工
	public String deleteEmp(String salId) {
		String message = "";
		int i = employeeMapper.deleteByPrimaryKey(salId);
		if (i > 0) {
			message = "删除成功";
		} else {
			message = "删除失败";
		}
		return message;
	}
	
	//模糊查询
	public List<Employee> listEmpBlurry(String name,String id,String oa){
		List<Employee> empBlurryList = employeeMapper.listEmpBlurry(name,id , oa);
		return empBlurryList;
	}

	//查询员工，保险，工资信息
	public List<Employee> listAll(String calDate,String salId) {
		List<Employee> listAll = employeeMapper.listAll(calDate,salId);
		return listAll;
	}

}
