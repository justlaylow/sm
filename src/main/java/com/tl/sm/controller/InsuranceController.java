package com.tl.sm.controller;

import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tl.sm.pojo.Insurance;
import com.tl.sm.service.InsuranceService;
import com.tl.sm.util.InsuranceList;

@Controller
@Scope("prototype")
public class InsuranceController {
	@Resource
	private InsuranceService insuranceService;
	
	//查询所有员工的保险信息
	@RequestMapping("/select/ins")
	public String listIns(HttpServletRequest request){
		List<Insurance> listIns = insuranceService.listIns();
		request.setAttribute("listIns", listIns);
		return "insurance";
	}
	
	//新增
	@RequestMapping("/insert/ins")
	public String insertIns(Insurance insurance,HttpServletRequest request) {
		String insertInsMsg = insuranceService.insertIns(insurance);
		List<Insurance> listIns = insuranceService.listIns();
		request.setAttribute("listIns", listIns);
		request.setAttribute("insertInsMsg", insertInsMsg);
		return "insurance";
	}
	
	//更新
	@RequestMapping("/update/ins")
	public String updateIns(Insurance insurance,HttpServletRequest request) {
		String updateInsMsg = insuranceService.updateIns(insurance);
		List<Insurance> listIns = insuranceService.listIns();
		request.setAttribute("listIns", listIns);
		request.setAttribute("updateInsMsg", updateInsMsg);
		return "insurance";
	}
	
	//删除
	@RequestMapping("/delete/ins")
	public String deleteIns(Integer id,HttpServletRequest request) {
		String deleteInsMsg = insuranceService.deleteIns(id);
		List<Insurance> listIns = insuranceService.listIns();
		request.setAttribute("listIns", listIns);
		request.setAttribute("deleteInsMsg", deleteInsMsg);
		return "insurance";
	}
	
	//模糊查询
	@RequestMapping("/blurry/ins")
	public String listInsBlurry(String insId,String insName,HttpServletRequest request){
		List<Insurance> listIns = insuranceService.listInsBlurry(insId, insName);
		request.setAttribute("listIns", listIns);
		return "insurance";
	}
	
	//批量更新,直接在页面上改,更直观
	@RequestMapping("/updateBatch/ins")
	public String updateBatch(InsuranceList insurance,HttpServletRequest request) {
		List<Insurance> list = insurance.getInsurance();
		String updateInsBatchMsg = insuranceService.updateBatch(list);
		
		List<Insurance> listIns = insuranceService.listIns();
		request.setAttribute("listIns", listIns);
		request.setAttribute("updateInsBatchMsg", updateInsBatchMsg);
		return "insurance";
	}
	
	//批量导入预览
	@RequestMapping("/insBeforeImport")
	public String importBatch(Model model,HttpServletRequest request) throws Exception {
		int adminId = 1;
		//获取上传文件
		MultipartHttpServletRequest multipart = (MultipartHttpServletRequest)request;
		MultipartFile file = multipart.getFile("upfile");
		InputStream in = file.getInputStream();
		//数据导入
		List<Insurance> insurance = insuranceService.importExcelInfo(in, file, adminId);
		request.setAttribute("insurance", insurance);
		in.close();
		return "add/insuranceImport";
	}
	//获得导入预览的List,然后执行批量更新方法,通过excel导入实现
	@RequestMapping("/insImport")
	public String insImport(HttpServletRequest request,InsuranceList insurance) {
		List<Insurance> list = insurance.getInsurance();
		String insImportMsg = insuranceService.importBatch(list);
		List<Insurance> listIns = insuranceService.listIns();
		request.setAttribute("listIns", listIns);
		request.setAttribute("insImportMsg", insImportMsg);
		return "insurance";
	}

}
