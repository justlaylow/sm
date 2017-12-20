package com.tl.sm.controller;

import java.beans.IntrospectionException;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tl.sm.mapper.AllInfoMapper;
import com.tl.sm.pojo.Employee;
import com.tl.sm.pojo.Salary;
import com.tl.sm.pojo.Summing;
import com.tl.sm.service.PrintService;

@Controller
@Scope("prototype")
public class PrintController {
	@Resource
	private PrintService printService;
	@Resource
	private AllInfoMapper allInfoMapper;//查询工资最大月份
	
	//部门工资条
	@RequestMapping("/departmentSalary")
	public String departmentSalary(String salDep,HttpServletRequest request) {
		//部门员工的工资信息
		List<Employee> listByDepName = printService.departmentSalary(salDep);
		//部门工资合计
		List<Summing> sumList = printService.department();
		Summing sum = new Summing();
		for(Summing s:sumList) {
			if(salDep.equals(s.getDepartment())) {
				sum = s;
			}
		}
		request.setAttribute("summing", sum);
		request.setAttribute("listByDepName", listByDepName);
		return "print/printTemplate";
	}
	
	//按部门统计应发
	@RequestMapping("/departmentShould")
	public String departmentShould(HttpServletRequest request) {
		List<Summing> departmentShould = printService.department();
		String maxMonth = allInfoMapper.selectMaxDate().substring(5, 7);
		request.setAttribute("maxMonth", maxMonth);
		request.setAttribute("departmentShould", departmentShould);
		return "print/departmentShould";
	}
	
	//按部门统计实发
	@RequestMapping("/departmentReality")
	public String departmentReality(HttpServletRequest request) {
		List<Summing> departmentReality = printService.department();
		String maxMonth = allInfoMapper.selectMaxDate().substring(5, 7);
		request.setAttribute("maxMonth", maxMonth);
		request.setAttribute("departmentReality", departmentReality);
		return "print/departmentReality";
	}
	
	//按统计类别统计应发
	@RequestMapping("/categoryShould")
	public String categoryShould(HttpServletRequest request) {
		List<Summing> categoryShould = printService.category();
		String maxMonth = allInfoMapper.selectMaxDate().substring(5, 7);
		request.setAttribute("maxMonth", maxMonth);
		request.setAttribute("categoryShould", categoryShould);
		return "print/categoryShould";
	}
	
	//按统计类别统计实发
	@RequestMapping("/categoryReality")
	public String categoryReality(HttpServletRequest request) {
		List<Summing> categoryReality = printService.category();
		String maxMonth = allInfoMapper.selectMaxDate().substring(5, 7);
		request.setAttribute("maxMonth", maxMonth);
		request.setAttribute("categoryReality", categoryReality);
		return "print/categoryReality";
	}
	
	//送银行文件
	@RequestMapping("/sendBank")
	public String sendBank(HttpServletRequest request) {
		List<Salary> sendBank = printService.sendBank();
		request.setAttribute("sendBank", sendBank);
		return "print/sendBank";
	}
	
	//poi Excel导出
	@RequestMapping("/exportBank")
    @ResponseBody
    public  void excelAvdImpot(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IntrospectionException, IllegalAccessException, ParseException, InvocationTargetException {
        response.reset(); //清除buffer缓存
        Map<String,Object> map=new HashMap<String,Object>();
        // 指定下载的文件名
        response.setHeader("Content-Disposition", "attachment;filename=sendBank.xlsx");
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        XSSFWorkbook workbook=null;
        //导出Excel对象
        workbook = printService.exportExcelInfo();
        OutputStream output;
        try {
            output = response.getOutputStream();
            BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
            bufferedOutPut.flush();
            workbook.write(bufferedOutPut);
            bufferedOutPut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
