package com.tl.sm.serviceImpl;

import java.beans.IntrospectionException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tl.sm.mapper.SalaryMapper;
import com.tl.sm.pojo.ExcelBean;
import com.tl.sm.pojo.Salary;
import com.tl.sm.service.SalaryService;
import com.tl.sm.util.ExcelUtil;

@Service
public class SalaryServiceImpl implements SalaryService{
	
	@Resource
	private SalaryMapper salaryMapper;
	
	//poiExcel导入
	public void importExcelInfo(InputStream in, MultipartFile file, String calDate,Integer adminId) throws Exception{  
	    List<List<Object>> listob = ExcelUtil.getBankListByExcel(in,file.getOriginalFilename());  
	    List<Salary> salaryList = new ArrayList<Salary>();
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    //遍历listob数据，把数据放到List中  
	    for (int i = 0; i < listob.size(); i++) {  
	        List<Object> ob = listob.get(i);  
	        Salary salary = new Salary();  
	        //设置编号  String.valueOf(ob.get())
	        //通过遍历实现把每一列封装成一个model中，再把所有的model用List集合装载 
	        System.out.println(simpleDateFormat.parse(calDate));
	        salary.setCalDate(simpleDateFormat.parse(calDate));
	        salary.setCalHr(String.valueOf(ob.get(0).toString()));
	        salary.setCalId(String.valueOf(ob.get(1).toString()));
	        salary.setCalName(String.valueOf(ob.get(2)));
	        if(ob.get(3)!=null) {
	        	salary.setCalBasic(Float.parseFloat(ob.get(3).toString()));
	        }
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

	
	//查询所有
	public List<Salary> listCal() {
		List<Salary> listCal = salaryMapper.listCal();
		return listCal;
	}

	//模糊查询
	public List<Salary> listCalBlurry(String calId, String calName, String calDate) {
		List<Salary> listCalBlurry = salaryMapper.listCalBlurry(calId, calName, calDate);
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
        excel.add(new ExcelBean("HR号","calId",0));
        excel.add(new ExcelBean("工号","calName",0));
        excel.add(new ExcelBean("姓名","calDate",0));
        excel.add(new ExcelBean("基本工资","calBasic",0));
        excel.add(new ExcelBean("岗位工资","calId",0));
        excel.add(new ExcelBean("浮动工资","calId",0));
        excel.add(new ExcelBean("系数","calId",0));
        excel.add(new ExcelBean("保密工资","calId",0));
        excel.add(new ExcelBean("技能等级工资","calId",0));
        excel.add(new ExcelBean("司龄工资","calId",0));
        excel.add(new ExcelBean("奖金","calId",0));
        excel.add(new ExcelBean("加班工资","calId",0));
        excel.add(new ExcelBean("津贴","calId",0));
        excel.add(new ExcelBean("考评工资","calId",0));
        excel.add(new ExcelBean("工伤工资","calId",0));
        excel.add(new ExcelBean("缺勤","calId",0));
        excel.add(new ExcelBean("其他","calId",0));
        excel.add(new ExcelBean("罚款","calId",0));
        excel.add(new ExcelBean("扣款","calId",0));
        excel.add(new ExcelBean("水电","calId",0));
        excel.add(new ExcelBean("餐补","calId",0));
        excel.add(new ExcelBean("会费","calId",0));
        excel.add(new ExcelBean("工时","calId",0));
        excel.add(new ExcelBean("工价","calId",0));
        excel.add(new ExcelBean("效益工资","calId",0));
        excel.add(new ExcelBean("工时奖","calId",0));
        excel.add(new ExcelBean("工时工资","calId",0));
        excel.add(new ExcelBean("福利","calId",0));
        excel.add(new ExcelBean("工废","calId",0));
        excel.add(new ExcelBean("上月扣款","calId",0));
        excel.add(new ExcelBean("所得税","calId",0));
        excel.add(new ExcelBean("应发工资","calId",0));
        excel.add(new ExcelBean("实得工资","calId",0));
        map.put(0, excel);
        String sheetName = calDate + "月份工资";
        //调用ExcelUtil的方法
        xssfWorkbook = ExcelUtil.createExcelFile(Salary.class, list, map, sheetName);
        return xssfWorkbook;
    }
	
}
