package com.tl.sm.controller;

import java.io.InputStream;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tl.sm.pojo.Department;
import com.tl.sm.pojo.Employee;
import com.tl.sm.service.EmployeeService;
import com.tl.sm.util.excelList;

@Controller
@Scope("prototype")
public class EmployeeController {
	@Resource
	private EmployeeService employeeService;

	// 查询所有员工和员工保险,保险表联合员工表
	@RequestMapping("/list/emp")
	public String listEmp(HttpServletRequest request) {
		List<Employee> empList = employeeService.listInner();
		request.setAttribute("empList", empList);
		List<Department> listDep = employeeService.listDep();
		request.setAttribute("listDep", listDep);
		return "employee";
	}

	// 新增员工
	@RequestMapping("/insert/emp")
	public String insertEmp(Employee employee, HttpServletRequest request) throws SQLIntegrityConstraintViolationException{
		String insertEmp = employeeService.insertEmp(employee);
		List<Employee> empList = employeeService.listInner();
		List<Department> listDep = employeeService.listDep();
		request.setAttribute("listDep", listDep);
		request.setAttribute("empList", empList);
		request.setAttribute("insertEmp", insertEmp);
		return "employee";
	}

	// 修改员工
	@RequestMapping("/update/emp")
	public String updateEmp(Employee employee, HttpServletRequest request) {
		String updateEmp = employeeService.updateEmp(employee);
		List<Employee> empList = employeeService.listInner();
		List<Department> listDep = employeeService.listDep();
		request.setAttribute("listDep", listDep);
		request.setAttribute("empList", empList);
		request.setAttribute("updateEmp", updateEmp);
		return "employee";
	}
	
	//删除员工
	@RequestMapping("/delete/emp")
	public String deleteEmp(String salId,HttpServletRequest request) {
		String deleteEmp = employeeService.deleteEmp(salId);
		List<Employee> empList = employeeService.listInner();
		List<Department> listDep = employeeService.listDep();
		request.setAttribute("listDep", listDep);
		request.setAttribute("empList", empList);
		request.setAttribute("deleteEmp", deleteEmp);
		return "employee";
	}
	
	//模糊查询
	@RequestMapping("/blurry/emp")
	public String blurryEmp(Employee employee,String salName,String salOa,String salId,HttpServletRequest request) {
		List<Employee> empList = employeeService.listEmpBlurry(salName, salId, salOa,salName, salId, salOa);
		List<Department> listDep = employeeService.listDep();
		request.setAttribute("listDep", listDep);
		request.setAttribute("empList", empList);
		return "employee";
	}
	

	//poi Excel导入
	@RequestMapping("/importIEmployee")
	public String beforeImport(excelList employeeList,HttpServletRequest request) {
		String importMsg = employeeService.importDB(employeeList.getEmployeeList());
		List<Employee> empList = employeeService.listInner();
		request.setAttribute("empList", empList);
		List<Department> listDep = employeeService.listDep();
		request.setAttribute("listDep", listDep);
		request.setAttribute("importMsg", importMsg);
		return "employee";
	}
	
	//poi导入预览,返回的集合在页面显示,提交后Controller拿到页面的数据执行保险表的insert方法
	@RequestMapping("/beforeEmployeeImport")
	public String impotr(HttpServletRequest request, Model model) throws Exception {
		int adminId = 1;
		// 获取上传的文件
		MultipartHttpServletRequest multipart = (MultipartHttpServletRequest) request;
		MultipartFile file = multipart.getFile("upfile");
		InputStream in = file.getInputStream();
		// 数据导入
		List<Employee> employeeList = employeeService.importExcelInfo(in, file, adminId);
		request.setAttribute("employeeList", employeeList);
		in.close();
		return "import/employeeImport";
	}
}
