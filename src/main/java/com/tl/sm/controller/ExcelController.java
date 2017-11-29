package com.tl.sm.controller;

import java.beans.IntrospectionException;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tl.sm.pojo.Salary;
import com.tl.sm.service.SalaryService;
import com.tl.sm.util.excelList;

@Controller
@Scope("prototype")
public class ExcelController {
	@Resource
	private SalaryService salaryService;

	//poi Excel导入
	@RequestMapping("/import")
	public String beforeImport(excelList salaryLsit,HttpServletRequest request) {
		System.out.println(salaryLsit.getSalaryList().get(0).getCalHr());
		String importMsg = salaryService.importDB(salaryLsit.getSalaryList());
		request.setAttribute("importMsg", importMsg);
		return "beforeImport";
	}
	
	//poi导入预览
	@RequestMapping("/beforeImport")
	public String impotr(HttpServletRequest request, Model model) throws Exception {
		int adminId = 1;
		// 获取上传的文件
		MultipartHttpServletRequest multipart = (MultipartHttpServletRequest) request;
		MultipartFile file = multipart.getFile("upfile");
		String month = request.getParameter("calDate");
		InputStream in = file.getInputStream();
		// 数据导入
		List<Salary> salaryList = salaryService.importExcelInfo(in, file, month, adminId);
		request.setAttribute("salaryList", salaryList);
		in.close();
		return "beforeImport";
	}
	
	//poi Excel导出
	@RequestMapping("/export")
    @ResponseBody
    public  void excelAvdImpot(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IntrospectionException, IllegalAccessException, ParseException, InvocationTargetException {
        String calDate = request.getParameter("calDate");
        if(calDate!=""){
            response.reset(); //清除buffer缓存
            Map<String,Object> map=new HashMap<String,Object>();
            // 指定下载的文件名
            response.setHeader("Content-Disposition", "attachment;filename="+calDate+".xlsx");
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            XSSFWorkbook workbook=null;
            //导出Excel对象
            workbook = salaryService.exportExcelInfo(calDate);
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

	
}
