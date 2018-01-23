package com.tl.sm.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.tl.sm.pojo.Department;
import com.tl.sm.service.DepartmentService;

@Controller
@Scope("prototype")
public class DepartmentController {
	@Resource
	private DepartmentService departmentService;
	/**
	 * 部门维护
	 * */
	// select * from department_查询所有部门
	@RequestMapping("/list/dep")
	public String listDep(HttpServletRequest request) {
		List<Department> listDep = departmentService.listAll();
		request.setAttribute("listDep", listDep);
		return "department";
	}

	// insert新增部门
	@RequestMapping("/insert/dep")
	public String addDep(Department department, HttpServletRequest request) {
		String insertDep = departmentService.addDep(department);
		List<Department> listDep = departmentService.listAll();
		request.setAttribute("listDep", listDep);
		request.setAttribute("insertDep", insertDep);
		return "department";
	}

	// 修改部门信息
	@RequestMapping("/update/dep")
	public String updateDep(Department department, HttpServletRequest request) {
		String updateDep = departmentService.updateDep(department);
		List<Department> listDep = departmentService.listAll();
		request.setAttribute("listDep", listDep);
		request.setAttribute("updateDep", updateDep);
		return "department";
	}

	// 删除部门
	@RequestMapping("/delete/dep")
	public ModelAndView deleteDep(Integer id, HttpServletRequest request, ModelAndView mv) {
		String deleteDep = departmentService.deleteDep(id);
		List<Department> listDep = departmentService.listAll();
		request.setAttribute("listDep", listDep);
		request.setAttribute("deleteDep", deleteDep);
		/*
		 * 转发到/list/dep请求 mv.setView(new RedirectView("/list/dep"));
		 */
		mv.setViewName("department");
		return mv;
	}

	//模糊查询
	@RequestMapping("/blurryF/dep")
	public String listByDep(Department department, HttpServletRequest request,String depId,String depName) {
		List<Department> listDep = departmentService.listByDep(depId, depName);
		request.setAttribute("listDep", listDep);
		return "department";
	}
	
	/*//分页
	@RequestMapping("/paging/dep")
	public ModelAndView pagingDep(Page page) {
		ModelAndView mav = new ModelAndView();
		PageHelper.offsetPage(page.getStart(), 10);
		List<Department> pagingList = departmentService.listAll();
		int total = (int) new PageInfo<>(pagingList).getTotal();
		
		page.caculateLast(total);
		
		// 放入转发参数
        mav.addObject("pagingList", pagingList);
        // 放入jsp路径
        mav.setViewName("department");
        return mav;
	}*/

}
