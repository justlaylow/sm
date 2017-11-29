package com.tl.sm.serviceImpl;

import java.beans.IntrospectionException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tl.sm.mapper.EmployeeMapper;
import com.tl.sm.mapper.InsuranceMapper;
import com.tl.sm.mapper.SalaryMapper;
import com.tl.sm.pojo.Employee;
import com.tl.sm.pojo.ExcelBean;
import com.tl.sm.pojo.Insurance;
import com.tl.sm.pojo.Salary;
import com.tl.sm.service.SalaryService;
import com.tl.sm.util.ExcelUtil;

@Service
public class SalaryServiceImpl implements SalaryService{
	
	@Resource
	private SalaryMapper salaryMapper;
	@Resource
	private InsuranceMapper insuranceMapper;
	@Resource
	private EmployeeMapper employeeMapper;
	
	//poiExcel导入
	public List<Salary> importExcelInfo(InputStream in, MultipartFile file, String calDate,Integer adminId) throws Exception{  
	    List<List<Object>> listob = ExcelUtil.getBankListByExcel(in,file.getOriginalFilename());  
	    List<Salary> salaryList = new ArrayList<Salary>();
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
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
	        salary.setCalManhour(Float.parseFloat(ob.get(21).toString()));
	        salary.setLabourCost(Float.parseFloat(ob.get(22).toString()));
	        salary.setCalBenefitwage(Float.parseFloat(ob.get(23).toString()));
	        salary.setCalManhourBonus(Float.parseFloat(ob.get(24).toString()));
	        salary.setCalManhourSalary(Float.parseFloat(ob.get(25).toString()));
	        salary.setCalWelfare(Float.parseFloat(ob.get(26).toString()));
	        salary.setCalWaste(Float.parseFloat(ob.get(27).toString()));
	        salary.setCalLastWithhold(Float.parseFloat(ob.get(28).toString()));
	        
	        //通过工号查到对应保险
	        Insurance ins = insuranceMapper.selectByInsId(ob.get(1).toString());
	        //通过工号取到对应的统计类别，计算会费
	        Employee emp = employeeMapper.selectByEmpId(ob.get(1).toString());
	        
	        //公积金
	        Float accFund = Float.parseFloat(ins.getInsAccFund());
	        //社保
	        Float insurance = Float.parseFloat(ins.getInsOld())+Float.parseFloat(ins.getInsTreatments())
	    	        +Float.parseFloat(ins.getInsIll())+Float.parseFloat(ins.getInsUnemp());
	        
	        //计算所得税，应得工资，实发工资  
	        Float calShould = (Float.parseFloat(ob.get(3).toString())+Float.parseFloat(ob.get(4).toString())
	        +Float.parseFloat(ob.get(5).toString())+Float.parseFloat(ob.get(7).toString())
	        +Float.parseFloat(ob.get(8).toString())+Float.parseFloat(ob.get(9).toString())
	        +Float.parseFloat(ob.get(10).toString())+Float.parseFloat(ob.get(11).toString())
	        +Float.parseFloat(ob.get(12).toString())+Float.parseFloat(ob.get(13).toString())
	        +Float.parseFloat(ob.get(14).toString())+Float.parseFloat(ob.get(16).toString())
	        +Float.parseFloat(ob.get(20).toString())
	        +Float.parseFloat(ob.get(21).toString())+Float.parseFloat(ob.get(22).toString())
	        +Float.parseFloat(ob.get(23).toString())+Float.parseFloat(ob.get(24).toString())
	        +Float.parseFloat(ob.get(25).toString())+Float.parseFloat(ob.get(26).toString())
	        +Float.parseFloat(ob.get(27).toString())-Float.parseFloat(ob.get(17).toString())
	        -Float.parseFloat(ob.get(15).toString())-Float.parseFloat(ob.get(18).toString())
	        -Float.parseFloat(ob.get(19).toString())-Float.parseFloat(ob.get(28).toString()))
	        *Float.parseFloat(ob.get(6).toString());
	        
	        //计算所得税
	        Float calIncometax = calShould-accFund-insurance-3500;
	    	       
	        if(calShould<=3500) {
	        	calIncometax = 0f;
	        }else {
	        	if(calIncometax<=1500) {
	        		calIncometax = calIncometax*0.03f;
	        	}else if(calIncometax>1500&&calIncometax<=4500) {
	        		calIncometax = calIncometax*0.1f-105;
	        	}else if(calIncometax>4500&&calIncometax<=9000) {
	        		calIncometax = calIncometax*0.2f-555;
	        	}else if(calIncometax>9000&&calIncometax<=35000) {
	        		calIncometax = calIncometax*0.25f-1005;
	        	}else if(calIncometax>35000&&calIncometax<=55000) {
	        		calIncometax = calIncometax*0.3f-2755;
	        	}else if(calIncometax>55000&&calIncometax<=80000) {
	        		calIncometax = calIncometax*0.35f-5505;
	        	}else {
	        		calIncometax = calIncometax*0.45f-13505;
	        	}
	        }
	        
	        //会费
	        String staCategory = emp.getStaCategory().substring(0, 2);
	        System.out.println(staCategory);
	        Float calDues = 0f;
	        if(staCategory.equals("管理")||staCategory.equals("技术")||staCategory.equals("事务")) {
	        	calDues = (Float.parseFloat(ob.get(3).toString())+Float.parseFloat(ob.get(4).toString())
	        	+Float.parseFloat(ob.get(7).toString())-calIncometax-accFund-insurance)*0.005f;
	        }else if(staCategory.equals("营销")) {
	        	//calDues = 
	        }else {
	        	Float all = Float.parseFloat(ob.get(8).toString())+Float.parseFloat(ob.get(13).toString());
	        	if(all<2000) {
	        		calDues = 5f;
	        	}else {
	        		calDues = 10f;
	        	}
	        }
	        
	        //实得工资
	        Float calResult = calShould-accFund-insurance-calIncometax-calDues;
	        
	        salary.setCalResult(calResult);
	        salary.setCalDues(calDues);
	        salary.setCalShould(calShould);
	        salary.setCalIncometax(calIncometax);
	        salaryList.add(salary);  
	    }  
	    return salaryList;  
	}

	//查询所有
	public List<Salary> listCal() {
		List<Salary> listCal = salaryMapper.listCal();
		return listCal;
	}

	//模糊查询
	public List<Salary> listCalBlurry(String calId, String calName, String calDate,String calId2, String calName2, String calDate2) {
		List<Salary> listCalBlurry = salaryMapper.listCalBlurry(calId, calName, calDate,calId2, calName2, calDate2);
		return listCalBlurry;
	}

	//更新
	public String updateCal(Salary salary) {
		String message = "";
		int i = salaryMapper.updateByPrimaryKeySelective(salary);
		if(i>0) {
			message = "修改成功";
		}else {
			message = "修改失败";
		}
		return message;
	}

	//单个删除
	public String deleteCal(Integer id) {
		String message = "";
		int i = salaryMapper.deleteByPrimaryKey(id);
		if(i>0) {
			message = "删除成功";
		}else {
			message = "删除失败";
		}
		return message;
	}

	//增加
	public String insertCal(Salary salary) {
		String message = "";
		int i = salaryMapper.insert(salary);
		if(i>0) {
			message = "添加成功";
		}else {
			message = "添加失败";
		}
		return message;
	}
	
	
	/**
     * 导出
     * @param salaryDate
     * @return
     * @throws InvocationTargetException
     * @throws ClassNotFoundException
     * @throws IntrospectionException
     * @throws ParseException
     * @throws IllegalAccessException
     */
    public XSSFWorkbook exportExcelInfo(String calDate) throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException{
        //根据条件查询数据，把数据装载到一个list中
        List<Salary> list = salaryMapper.selectCal(calDate);

        List<ExcelBean> excel=new ArrayList<ExcelBean>();
        Map<Integer,List<ExcelBean>> map=new LinkedHashMap<Integer,List<ExcelBean>>();
        XSSFWorkbook xssfWorkbook=null;
        //设置标题栏
        excel.add(new ExcelBean("HR号","calHr",0));
        excel.add(new ExcelBean("工号","calId",0));
        excel.add(new ExcelBean("姓名","calName",0));
        excel.add(new ExcelBean("基本工资","calBasic",0));
        excel.add(new ExcelBean("岗位工资","calPost",0));
        excel.add(new ExcelBean("浮动工资","calFloat",0));
        excel.add(new ExcelBean("系数","calCoefficient",0));
        excel.add(new ExcelBean("保密工资","calSecrecy",0));
        excel.add(new ExcelBean("技能等级工资","calSkillLevel",0));
        excel.add(new ExcelBean("司龄工资","calComage",0));
        excel.add(new ExcelBean("奖金","calBonus",0));
        excel.add(new ExcelBean("加班工资","calOvertime",0));
        excel.add(new ExcelBean("津贴","calBenefit",0));
        excel.add(new ExcelBean("考评工资","calCheck",0));
        excel.add(new ExcelBean("工伤工资","calInjury",0));
        excel.add(new ExcelBean("缺勤","calLeave",0));
        excel.add(new ExcelBean("其他","calOther",0));
        excel.add(new ExcelBean("罚款","calPenalty",0));
        excel.add(new ExcelBean("扣款","calWithhold",0));
        excel.add(new ExcelBean("水电","calWaterandele",0));
        excel.add(new ExcelBean("餐补","calAllowance",0));
        excel.add(new ExcelBean("会费","calDues",0));
        excel.add(new ExcelBean("工时","calManhour",0));
        excel.add(new ExcelBean("工价","LabourCost",0));
        excel.add(new ExcelBean("效益工资","calBenefitwage",0));
        excel.add(new ExcelBean("工时奖","calManhourBonus",0));
        excel.add(new ExcelBean("工时工资","calManhourSalary",0));
        excel.add(new ExcelBean("福利","calWelfare",0));
        excel.add(new ExcelBean("工废","calWaste",0));
        excel.add(new ExcelBean("上月扣款","calLastWithhold",0));
        excel.add(new ExcelBean("所得税","calIncometax",0));
        excel.add(new ExcelBean("应发工资","calShould",0));
        excel.add(new ExcelBean("实得工资","calResult",0));
        map.put(0, excel);
        String sheetName = calDate + "月份工资";
        //调用ExcelUtil的方法
        xssfWorkbook = ExcelUtil.createExcelFile(Salary.class, list, map, sheetName);
        return xssfWorkbook;
    }

	//Excel数据插入数据库
	public String importDB(List<Salary> salaryList) {
		//批量插入  
		String message = "";
		int i = salaryMapper.insertForeach(salaryList);
		if(i>0) {
			message = "导入成功";
		}else {
			message = "导入失败";
		}
		return message;
	}
	
}
