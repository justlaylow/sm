package com.tl.sm.serviceImpl;

import java.io.InputStream;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tl.sm.mapper.EmployeeMapper;
import com.tl.sm.mapper.InsuranceMapper;
import com.tl.sm.mapper.SalaryMapper;
import com.tl.sm.pojo.Department;
import com.tl.sm.pojo.Employee;
import com.tl.sm.pojo.Insurance;
import com.tl.sm.pojo.Salary;
import com.tl.sm.service.EmployeeService;
import com.tl.sm.util.ExcelUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Resource
	private EmployeeMapper employeeMapper;

	// 查询所有员工
	public List<Employee> listEmp() {
		List<Employee> empList = employeeMapper.listEmp();
		return empList;
	}
	
	//查询部门,用于实现部门的名称改变,员工表里的部门名称跟着改变
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
	public String insertEmp(Employee employee) throws SQLIntegrityConstraintViolationException {
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
	public List<Employee> listEmpBlurry(String name,String id,String oa,String name2,String id2,String oa2){
		List<Employee> empBlurryList = employeeMapper.listEmpBlurry(name,id , oa,name2,id2 , oa2);
		return empBlurryList;
	}

	//查询员工，保险，工资信息
	public List<Employee> listAll(String calDate,String salId,String salName) {
		List<Employee> listAll = employeeMapper.listAll(calDate,salId,salName);
		return listAll;
	}
	
	//poiExcel导入保险
	public List<Employee> importExcelInfo(InputStream in, MultipartFile file,Integer adminId) throws Exception{  
	    List<List<Object>> listob = ExcelUtil.getBankListByExcel(in,file.getOriginalFilename());  
	    List<Employee> employeeList = new ArrayList<Employee>();
	    //遍历listob数据，把数据放到List中  
	    for (int i = 0; i < listob.size(); i++) { 
	        List<Object> ob = listob.get(i);  
	        Employee emp = new Employee();  
	        //设置编号  String.valueOf(ob.get())
	        //通过遍历实现把每一列封装成一个model中，再把所有的model用List集合装载 
	        emp.setSalId(ob.get(0).toString());
	        emp.setSalName(ob.get(1).toString());
	        emp.setSalDep(ob.get(2).toString());
	        emp.setPostCategory(ob.get(3).toString());
	        emp.setSalPost(ob.get(4).toString());
	        emp.setSalOa(ob.get(5).toString());
	        emp.setStaCategory(ob.get(6).toString());
	        emp.setSalRemark(ob.get(7).toString());
	        emp.setSalSkilllevel(ob.get(8).toString());
	        emp.setSalSkillSalary(Float.parseFloat(ob.get(9).toString()));
	        emp.setBankAccount(ob.get(10).toString());
	        
	        employeeList.add(emp);
	        
	    }  
	    return employeeList;  
	}
	
	//Excel数据插入数据库
	public String importDB(List<Employee> employeeList) {
		//批量插入  
		String message = "";
		int i = employeeMapper.insertForeach(employeeList);
		if(i>0) {
			message = "导入成功";
		}else {
			message = "导入失败";
		}
		return message;
	}

}
