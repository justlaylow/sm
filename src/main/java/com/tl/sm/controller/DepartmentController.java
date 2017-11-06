package com.tl.sm.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tl.sm.pojo.Department;
import com.tl.sm.service.DepartmentService;

@Controller
@Scope("prototype")
public class DepartmentController {
	@Resource
	private DepartmentService departmentService;

	// 新增员工
	@RequestMapping("/insert/dep")
	public String addDep(Department department, HttpServletRequest request) {
		String insertDep = departmentService.addDep(department);
		request.setAttribute("insertDep", insertDep);
		return "department";
	}

	// 修改员工信息
	@RequestMapping("/update/dep")
	public String updateDep(Department department, HttpServletRequest request) {
		String updateDep = departmentService.updateDep(department);
		request.setAttribute("updateDep", updateDep);
		return "department";
	}

	// 删除员工
	@RequestMapping("/delete/dep")
	public String deleteDep(Integer id, HttpServletRequest request) {
		String deleteDep = departmentService.deleteDep(id);
		request.setAttribute("deleteDep", deleteDep);
		return "department";
	}

	// 查询所有员工
	@RequestMapping("/list/dep")
	public String listDep(HttpServletRequest request) {
		List<Department> listDep = departmentService.listAll();
		request.setAttribute("listDep", listDep);
		return "department";
	}
}
