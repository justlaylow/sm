package com.tl.sm.serviceImpl;

import java.io.InputStream;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tl.sm.mapper.EmployeeMapper;
import com.tl.sm.pojo.Department;
import com.tl.sm.pojo.Employee;
import com.tl.sm.service.EmployeeService;
import com.tl.sm.util.ExcelUtil;
import com.tl.sm.util.PageBean;

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
	
	//poiExcel导入员工信息
	public List<Employee> importExcelInfo(InputStream in, MultipartFile file,Integer adminId) throws Exception{  
	    List<List<Object>> listob = ExcelUtil.getBankListByExcel(in,file.getOriginalFilename());  
	    List<Employee> employeeList = new ArrayList<Employee>();
	    //遍历listob数据，把数据放到List中  
	    for (int i = 0; i < listob.size(); i++) { 
	        List<Object> ob = listob.get(i);  
	        Employee emp = new Employee();  
	        //设置编号  String.valueOf(ob.get())
	        //通过遍历实现把每一列封装成一个model中，再把所有的model用List集合装载 
	        emp.setSalOa(ob.get(0).toString());
	        emp.setSalId(ob.get(1).toString());
	        emp.setSalName(ob.get(2).toString());
	        emp.setSalDep(ob.get(3).toString());
	        emp.setPostCategory(ob.get(4).toString());
	        emp.setSalPost(ob.get(5).toString());
	        emp.setStaCategory(ob.get(6).toString());
	        emp.setSalSkilllevel(ob.get(7).toString());
	        if("".equals(ob.get(8).toString())||ob.get(8).toString()==null) {
	        	emp.setSalSkillSalary(0.0f);
	        }else {
	        	emp.setSalSkillSalary(Float.parseFloat(ob.get(8).toString()));
	        }
	        emp.setBankAccount(ob.get(9).toString());
	        emp.setBankAddress(ob.get(10).toString());
	        emp.setSalRemark(ob.get(11).toString());
	        
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

	@Override
	public PageBean<Employee> paging(int pageNum, int pageSize) {
		//在这里就要将pageBean中的数据创建好,然后将该对象传回去
		//先要从数据库中获取所有用户的数据量有多少,获得totalRecord
		List<Employee> list = employeeMapper.listInner();
		int totalRecord = list.size();
		
		//有了三个初始数据,就能够创建pageBean对象了
		PageBean<Employee> pb = new PageBean<Employee>(pageNum,pageSize,totalRecord);
		
		//获取pageBean对象中的startIndex
		int startIndex  = pb.getStartIndex();
		
		//有startIndex和pageSize,就可以拿到每页的数据了
		pb.setList(employeeMapper.paging(startIndex, pageSize));
		
		return pb;
	}

}
