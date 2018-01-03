package com.tl.sm.controller;


import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tl.sm.pojo.AllInfo;
import com.tl.sm.pojo.Department;
import com.tl.sm.pojo.Employee;
import com.tl.sm.service.AllInfoService;
import com.tl.sm.service.EmployeeService;

@Controller
@Scope("prototype")
public class AllInfoController {
	@Resource
	private AllInfoService allInfoService;
	@Resource
	private EmployeeService employeeService;
	/**
	 * 用来查询修改工资表，员工表，保险表的数据
	 * listDep在allInfo.jsp中没有使用到
	 * */
	//三表更新,分三次update完成,allInfoMapper.xml
	@RequestMapping("/allInfo")
	public String AllUpdate(AllInfo allInfo,HttpServletRequest request) {
		String AllUpdateMessage = allInfoService.AllUpdate(allInfo);
		List<Department> listDep = employeeService.listDep();
		String maxMonth = allInfoService.maxMonth();
		request.setAttribute("maxMonth", maxMonth);
		request.setAttribute("listDep", listDep);
		request.setAttribute("AllUpdateMessage", AllUpdateMessage);
		return "allInfo";
	}
	
	//通过工号删除员工,delete语句执行3次分别删除员工表,保险表,工资表内的数据
	@RequestMapping("/allInfo/del")
	public String deleteAll(String calId,String calDate,HttpServletRequest request) {
		String AllDeleteMessage = allInfoService.deleteAll(calId,calDate);
		request.setAttribute("AllDeleteMessage", AllDeleteMessage);
		return "allInfo";
	}
	
	// 通过工号和工资日期查询员工的所有信息
	@RequestMapping("/list/all")
	public String listAll(String calId,String calDate,String calName,HttpServletRequest request) throws ParseException {
		/*判断工号和姓名，如果没填值可能为空字符串，如果是赋值为空，否则listAll查询
		不到工号和姓名为空字符串的数据*/
		if(calId.equals("")) {
			calId = null;
		}else if(calName.equals("")) {
			calName = null;
		}
		List<Employee> ListAll = employeeService.listAll(calDate,calId,calName);
		List<Department> listDep = employeeService.listDep();
		String maxMonth = allInfoService.maxMonth();
		request.setAttribute("maxMonth", maxMonth);
		request.setAttribute("listDep", listDep);
		request.setAttribute("listAll", ListAll);
		return "allInfo";
	}
}
