package com.tl.sm.serviceImpl;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tl.sm.mapper.SalaryMapper;
import com.tl.sm.pojo.Salary;
import com.tl.sm.service.SalaryService;
import com.tl.sm.util.ExcelUtil;

@Service
public class SalaryServiceImpl implements SalaryService{
	
	@Resource
	private SalaryMapper salaryMapper;
	
	public void importExcelInfo(InputStream in, MultipartFile file, String calDate,Integer adminId) throws Exception{  
	    List<List<Object>> listob = ExcelUtil.getBankListByExcel(in,file.getOriginalFilename());  
	    List<Salary> salaryList = new ArrayList<Salary>();
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
	    //遍历listob数据，把数据放到List中  
	    for (int i = 0; i < listob.size(); i++) {  
	        List<Object> ob = listob.get(i);  
	        Salary salary = new Salary();  
	        //设置编号  String.valueOf(ob.get())
	        //通过遍历实现把每一列封装成一个model中，再把所有的model用List集合装载 
	        salary.setCalDate(simpleDateFormat.parse(calDate));
	        salary.setCalHr(String.valueOf(ob.get(0).toString()));
	        salary.setCalId(String.valueOf(ob.get(1).toString()));
	        salary.setCalName(String.valueOf(ob.get(2)));
	        salary.setCalBasic(Float.parseFloat(ob.get(3).toString()));
	        salary.setCalPost(Float.parseFloat(ob.get(4).toString()));
	        salary.setCalFloat(Float.parseFloat(ob.get(5).toString()));
	        salary.setCalCoefficient(Float.parseFloat(ob.get(6).toString()));
	        salary.setCalSecrecy(Float.parseFloat(ob.get(7).toString()));
	        salary.setCalSkillLevel(Float.parseFloat(ob.get(8).toString()));
	        salary.setCalComage(Float.parseFloat(ob.get(9).toString()));
	        salary.setCalBonus(Float.parseFloat(ob.get(10).toString()));
	        salary.setCalOvertime(Float.parseFloat(ob.get(11).toString()));
	        salary.setCalBenefit(Float.parseFloat(ob.get(12).toString()));
	        salary.setCalCheck(Float.parseFloat(ob.get(13).toString()));
	        salary.setCalInjury(Float.parseFloat(ob.get(14).toString()));
	        salary.setCalLeave(Float.parseFloat(ob.get(15).toString()));
	        salary.setCalOther(Float.parseFloat(ob.get(16).toString()));
	        salary.setCalPenalty(Float.parseFloat(ob.get(17).toString()));
	        salary.setCalWithhold(Float.parseFloat(ob.get(18).toString()));
	        salary.setCalWaterandele(Float.parseFloat(ob.get(19).toString()));
	        salary.setCalAllowance(Float.parseFloat(ob.get(20).toString()));
	        salary.setCalDues(Float.parseFloat(ob.get(21).toString()));
	        salary.setCalManhour(Float.parseFloat(ob.get(22).toString()));
	        salary.setLabourCost(Float.parseFloat(ob.get(23).toString()));
	        salary.setCalBenefitwage(Float.parseFloat(ob.get(24).toString()));
	        salary.setCalManhourBonus(Float.parseFloat(ob.get(25).toString()));
	        salary.setCalManhourSalary(Float.parseFloat(ob.get(26).toString()));
	        salary.setCalWelfare(Float.parseFloat(ob.get(27).toString()));
	        salary.setCalWaste(Float.parseFloat(ob.get(28).toString()));
	        salary.setCalLastWithhold(Float.parseFloat(ob.get(29).toString()));
	        
	        
	        //计算所得税，应得工资，实发工资  
	        
	        
	        salaryList.add(salary);  
	    }  
	    //批量插入  
	    salaryMapper.insertForeach(salaryList);  
	}
	
	
	
	
}
