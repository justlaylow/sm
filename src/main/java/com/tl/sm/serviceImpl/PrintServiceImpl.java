package com.tl.sm.serviceImpl;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.tl.sm.mapper.DepartmentMapper;
import com.tl.sm.mapper.EmployeeMapper;
import com.tl.sm.mapper.SalaryMapper;
import com.tl.sm.pojo.AllInfo;
import com.tl.sm.pojo.Department;
import com.tl.sm.pojo.Employee;
import com.tl.sm.pojo.ExcelBean;
import com.tl.sm.pojo.Salary;
import com.tl.sm.pojo.SendBank;
import com.tl.sm.pojo.Summing;
import com.tl.sm.service.PrintService;
import com.tl.sm.util.ExcelUtil;
@Service
public class PrintServiceImpl implements PrintService{
	@Resource
	private EmployeeMapper printMapper;
	@Resource
	private DepartmentMapper departmentMapper;
	@Resource
	private SalaryMapper salaryMapper;
	
	
	//部门工资条,通过传部门名称来打印对应的工资条
	public List<Employee> departmentSalary(String depName) {
		List<Employee> listall = printMapper.printByDepName(depName);
		return listall;
	}

	//按部门统计,循环将所有最大月份的工资信息按部门累加起来,然后放到Summing集合里
	public List<Summing> department() {
		List<Summing> sumList = new ArrayList<Summing>();
		List<Employee> list = printMapper.printAll();
		List<Department> listDep = departmentMapper.listAll();
		for(int i =0;i<listDep.size();i++) {
			Summing sum = new Summing();
			String department ="";
			//基本工资
			Float basic=0f;
			//岗位工资
			Float post=0f;
			//司龄工资
			Float comage=0f;
			//保密工资
			Float secrecy=0f;
			//技能工资
			Float skillSalary=0f;
			//效益工资
			Float benefit=0f;
			//工废
			Float labourCost=0f;
			//工时
			Float manhour=0f;
			//工时工资
			Float manhourSalary=0f;
			//加班工资
			Float overtime=0f;
			//奖金
			Float bonus=0f;
			//考评工资
			Float check=0f;
			//津贴
			Float allowance=0f;
			//缺勤
			Float leave=0f;
			//工伤工资
			Float injury=0f;
			//罚款
			Float penalty=0f;
			//其他
			Float other=0f;
			//应发工资
			Float should=0f;
			//会费
			Float dues=0f;
			//养老保险
			Float old=0f;
			//医保
			Float treatments=0f;
			//大病医疗
			Float ill=0f;
			//失业
			Float unemp=0f;
			//公积金
			Float accFund=0f;
			//水电
			Float waterAndEle=0f;
			//扣款
			Float withhold=0f;
			//所得税
			Float incomeTax=0f;
			//下月扣款
			Float lastMonthWithhold=0f;
			//扣款合计
			Float withholdTotal=0f;
			//实得
			Float reality=0f;
			//餐补
			Float mealAllowance=0f;
			//部门名称
			department = listDep.get(i).getDepName();
			sum.setDepartment(department);
			for(int j=0;j<list.size();j++) {
				if(listDep.get(i).getDepName().equals(list.get(j).getSalDep())) {
					basic+=list.get(j).getSalSalaryList().get(0).getCalBasic();
					post+=list.get(j).getSalSalaryList().get(0).getCalPost();
					comage+=list.get(j).getSalSalaryList().get(0).getCalComage();
					secrecy+=list.get(j).getSalSalaryList().get(0).getCalSecrecy();
					skillSalary+=list.get(j).getSalSalaryList().get(0).getCalSkillLevel();
					benefit+=((list.get(j).getSalSalaryList().get(0).getCalBasic()+list.get(j).getSalSalaryList().get(0).getCalPost())*list.get(j).getSalSalaryList().get(0).getCalCoefficient());
					//labourCost+=list.get(j).getSalSalaryList().get(0).getLabourCost();
					//manhour+=list.get(j).getSalSalaryList().get(0).getCalManhour();
					manhourSalary+=list.get(j).getSalSalaryList().get(0).getCalManhourSalary();
					overtime+=list.get(j).getSalSalaryList().get(0).getCalOvertime();
					bonus+=list.get(j).getSalSalaryList().get(0).getCalBonus();
					check+=list.get(j).getSalSalaryList().get(0).getCalCheck();
					allowance+=list.get(j).getSalSalaryList().get(0).getCalBenefit();
					leave+=list.get(j).getSalSalaryList().get(0).getCalLeave();
					injury+=list.get(j).getSalSalaryList().get(0).getCalInjury();
					penalty+=list.get(j).getSalSalaryList().get(0).getCalPenalty();
					other+=list.get(j).getSalSalaryList().get(0).getCalOther();
					should+=list.get(j).getSalSalaryList().get(0).getCalShould();
					dues+=list.get(j).getSalSalaryList().get(0).getCalDues();
					old+=Float.parseFloat(list.get(j).getSalInsuranceList().get(0).getInsOld());
					treatments+=Float.parseFloat(list.get(j).getSalInsuranceList().get(0).getInsTreatments());
					ill+=Float.parseFloat(list.get(j).getSalInsuranceList().get(0).getInsIll());
					unemp+=Float.parseFloat(list.get(j).getSalInsuranceList().get(0).getInsUnemp());
					accFund+=Float.parseFloat(list.get(j).getSalInsuranceList().get(0).getInsAccFund());
					waterAndEle+=list.get(j).getSalSalaryList().get(0).getCalWaterandele();
					withhold+=list.get(j).getSalSalaryList().get(0).getCalWithhold();
					//lastMonthWithhold+=list.get(j).getSalSalaryList().get(0).getCalLastWithhold();
					incomeTax+=list.get(j).getSalSalaryList().get(0).getCalIncometax();
					withholdTotal+=list.get(j).getSalSalaryList().get(0).getCalTotal();
					reality+=list.get(j).getSalSalaryList().get(0).getCalResult();
					mealAllowance+=list.get(j).getSalSalaryList().get(0).getCalAllowance();
					sum.setBasic(reserve(basic));
					sum.setPost(reserve(post));
					sum.setComage(reserve(comage));
					sum.setSecrecy(reserve(secrecy));
					sum.setSkillSalary(reserve(skillSalary));
					sum.setBenefit(reserve(benefit));
					sum.setLabourCost(reserve(labourCost));
					sum.setManhour(reserve(manhour));
					sum.setManhourSalary(reserve(manhourSalary));
					sum.setOvertime(reserve(reserve(overtime)));
					sum.setBonus(reserve(bonus));
					sum.setCheck(reserve(check));
					sum.setAllowance(reserve(allowance));
					sum.setLeave(reserve(leave));
					sum.setInjury(reserve(injury));
					sum.setPenalty(reserve(penalty));
					sum.setOther(reserve(other));
					sum.setShould(reserve(should));
					dues = (float)(Math.round(dues*100))/100;
					sum.setDues(dues);
					sum.setOld(reserve(old));
					sum.setTreatments(reserve(treatments));
					sum.setIll(reserve(ill));
					sum.setUnemp(reserve(unemp));
					sum.setAccFund(reserve(accFund));
					sum.setWaterAndEle(reserve(waterAndEle));
					sum.setWithhold(reserve(withhold));
					sum.setLastMonthWithhold(reserve(lastMonthWithhold));
					incomeTax = (float)(Math.round(incomeTax*100))/100;
					sum.setIncomeTax(incomeTax);
					sum.setWithholdTotal(reserve(withholdTotal));
					sum.setReality(reserve(reality));
					sum.setMealAllowance(reserve(mealAllowance));
				}
			}
			sumList.add(sum);
		}
		
		//总合计
		Summing sum = new Summing();
		String department ="";
		int count = 0;
		Float basic=0f;
		Float post=0f;
		Float comage=0f;
		Float secrecy=0f;
		Float skillSalary=0f;
		Float benefit=0f;
		Float labourCost=0f;
		Float manhour=0f;
		Float manhourSalary=0f;
		Float overtime=0f;
		Float bonus=0f;
		Float check=0f;
		Float allowance=0f;//津贴
		Float leave=0f;
		Float injury=0f;
		Float penalty=0f;
		Float other=0f;
		Float should=0f;
		Float dues=0f;
		Float old=0f;
		Float treatments=0f;
		Float ill=0f;
		Float unemp=0f;
		Float accFund=0f;
		Float waterAndEle=0f;
		Float withhold=0f;
		Float incomeTax=0f;
		Float lastMonthWithhold=0f;
		Float withholdTotal=0f;
		Float reality=0f;
		Float mealAllowance=0f;
		for(int j=0;j<list.size();j++) {
			count+=1;
			basic+=list.get(j).getSalSalaryList().get(0).getCalBasic();
			post+=list.get(j).getSalSalaryList().get(0).getCalPost();
			comage+=list.get(j).getSalSalaryList().get(0).getCalComage();
			secrecy+=list.get(j).getSalSalaryList().get(0).getCalSecrecy();
			skillSalary+=list.get(j).getSalSalaryList().get(0).getCalSkillLevel();
			benefit+=((list.get(j).getSalSalaryList().get(0).getCalBasic()+list.get(j).getSalSalaryList().get(0).getCalPost())*list.get(j).getSalSalaryList().get(0).getCalCoefficient());
			//labourCost+=list.get(j).getSalSalaryList().get(0).getLabourCost();
			//manhour+=list.get(j).getSalSalaryList().get(0).getCalManhour();
			manhourSalary+=list.get(j).getSalSalaryList().get(0).getCalManhourSalary();
			overtime+=list.get(j).getSalSalaryList().get(0).getCalOvertime();
			bonus+=list.get(j).getSalSalaryList().get(0).getCalBonus();
			check+=list.get(j).getSalSalaryList().get(0).getCalCheck();
			allowance+=list.get(j).getSalSalaryList().get(0).getCalBenefit();
			leave+=list.get(j).getSalSalaryList().get(0).getCalLeave();
			injury+=list.get(j).getSalSalaryList().get(0).getCalInjury();
			penalty+=list.get(j).getSalSalaryList().get(0).getCalPenalty();
			other+=list.get(j).getSalSalaryList().get(0).getCalOther();
			should+=list.get(j).getSalSalaryList().get(0).getCalShould();
			dues+=list.get(j).getSalSalaryList().get(0).getCalDues();
			old+=Float.parseFloat(list.get(j).getSalInsuranceList().get(0).getInsOld());
			treatments+=Float.parseFloat(list.get(j).getSalInsuranceList().get(0).getInsTreatments());
			ill+=Float.parseFloat(list.get(j).getSalInsuranceList().get(0).getInsIll());
			unemp+=Float.parseFloat(list.get(j).getSalInsuranceList().get(0).getInsUnemp());
			accFund+=Float.parseFloat(list.get(j).getSalInsuranceList().get(0).getInsAccFund());
			waterAndEle+=list.get(j).getSalSalaryList().get(0).getCalWaterandele();
			withhold+=list.get(j).getSalSalaryList().get(0).getCalWithhold();
			//lastMonthWithhold+=list.get(j).getSalSalaryList().get(0).getCalLastWithhold();
			incomeTax+=(float)(Math.round(list.get(j).getSalSalaryList().get(0).getCalIncometax()*100))/100;
			withholdTotal+=list.get(j).getSalSalaryList().get(0).getCalTotal();
			reality+=list.get(j).getSalSalaryList().get(0).getCalResult();
			mealAllowance+=list.get(j).getSalSalaryList().get(0).getCalAllowance();
			sum.setDepartment(department);
			sum.setCount(count);
			sum.setBasic(reserve(basic));
			sum.setPost(reserve(post));
			sum.setComage(reserve(comage));
			sum.setSecrecy(reserve(secrecy));
			sum.setSkillSalary(reserve(skillSalary));
			sum.setBenefit(reserve(benefit));
			sum.setLabourCost(reserve(labourCost));
			sum.setManhour(reserve(manhour));
			sum.setManhourSalary(reserve(manhourSalary));
			sum.setOvertime(reserve(overtime));
			sum.setBonus(reserve(bonus));
			sum.setCheck(reserve(check));
			sum.setAllowance(reserve(allowance));
			sum.setLeave(reserve(leave));
			sum.setInjury(reserve(injury));
			sum.setPenalty(reserve(penalty));
			sum.setOther(reserve(other));
			sum.setShould(reserve(should));
			dues = (float)(Math.round(dues*100))/100;
			sum.setDues(dues);
			sum.setOld(reserve(old));
			sum.setTreatments(reserve(treatments));
			sum.setIll(reserve(ill));
			sum.setUnemp(reserve(unemp));
			sum.setAccFund(reserve(accFund));
			sum.setWaterAndEle(reserve(waterAndEle));
			sum.setWithhold(reserve(withhold));
			sum.setLastMonthWithhold(reserve(lastMonthWithhold));
			incomeTax = (float)(Math.round(incomeTax*100))/100;
			sum.setIncomeTax(incomeTax);
			sum.setWithholdTotal(reserve(withholdTotal));
			sum.setReality(reserve(reality));
			sum.setMealAllowance(reserve(mealAllowance));
			
		}
		sumList.add(sum);
		return sumList;
	}

	//按统计类别统计,循环将所有最大月份的工资信息按统计类别累加起来,然后放到Summing集合里
	public List<Summing> category() {
		List<String> listCategory = new ArrayList<String>();
		listCategory.add("管理-二级机构负责人");
		listCategory.add("管理-三级机构负责人");
		listCategory.add("管理-一般管理");
		listCategory.add("技术-IT技术");
		listCategory.add("技术-技术服务");
		listCategory.add("技术-技术开发");
		listCategory.add("技术-技术研究");
		listCategory.add("生产人员-计件");
		listCategory.add("生产人员-计时");
		listCategory.add("事务人员");
		listCategory.add("营销人员-售后");
		List<Summing> sumList = new ArrayList<Summing>();
		List<Employee> list = printMapper.printAll();
		for(int i =0;i<listCategory.size();i++) {
			Summing sum = new Summing();
			String category ="";
			int count = 0;
			Float basic=0f;
			Float post=0f;
			Float comage=0f;
			Float secrecy=0f;
			Float skillSalary=0f;
			Float benefit=0f;
			Float labourCost=0f;
			Float manhour=0f;
			Float manhourSalary=0f;
			Float overtime=0f;
			Float bonus=0f;
			Float check=0f;
			Float allowance=0f;//津贴
			Float leave=0f;
			Float injury=0f;
			Float penalty=0f;
			Float other=0f;
			Float should=0f;
			Float dues=0f;
			Float old=0f;
			Float treatments=0f;
			Float ill=0f;
			Float unemp=0f;
			Float accFund=0f;
			Float waterAndEle=0f;
			Float withhold=0f;
			Float incomeTax=0f;
			Float lastMonthWithhold=0f;
			Float withholdTotal=0f;
			Float reality=0f;
			Float mealAllowance=0f;
			category = listCategory.get(i);
			sum.setCategory(category);
			for(int j=0;j<list.size();j++) {
				if(listCategory.get(i).equals(list.get(j).getStaCategory())) {
					count+=1;
					basic+=list.get(j).getSalSalaryList().get(0).getCalBasic();
					post+=list.get(j).getSalSalaryList().get(0).getCalPost();
					comage+=list.get(j).getSalSalaryList().get(0).getCalComage();
					secrecy+=list.get(j).getSalSalaryList().get(0).getCalSecrecy();
					skillSalary+=list.get(j).getSalSalaryList().get(0).getCalSkillLevel();
					benefit+=((list.get(j).getSalSalaryList().get(0).getCalBasic()+list.get(j).getSalSalaryList().get(0).getCalPost())*list.get(j).getSalSalaryList().get(0).getCalCoefficient());
					//labourCost+=list.get(j).getSalSalaryList().get(0).getLabourCost();
					//manhour+=list.get(j).getSalSalaryList().get(0).getCalManhour();
					manhourSalary+=list.get(j).getSalSalaryList().get(0).getCalManhourSalary();
					overtime+=list.get(j).getSalSalaryList().get(0).getCalOvertime();
					bonus+=list.get(j).getSalSalaryList().get(0).getCalBonus();
					check+=list.get(j).getSalSalaryList().get(0).getCalCheck();
					allowance+=list.get(j).getSalSalaryList().get(0).getCalBenefit();
					leave+=list.get(j).getSalSalaryList().get(0).getCalLeave();
					injury+=list.get(j).getSalSalaryList().get(0).getCalInjury();
					penalty+=list.get(j).getSalSalaryList().get(0).getCalPenalty();
					other+=list.get(j).getSalSalaryList().get(0).getCalOther();
					should+=list.get(j).getSalSalaryList().get(0).getCalShould();
					dues+=list.get(j).getSalSalaryList().get(0).getCalDues();
					old+=Float.parseFloat(list.get(j).getSalInsuranceList().get(0).getInsOld());
					treatments+=Float.parseFloat(list.get(j).getSalInsuranceList().get(0).getInsTreatments());
					ill+=Float.parseFloat(list.get(j).getSalInsuranceList().get(0).getInsIll());
					unemp+=Float.parseFloat(list.get(j).getSalInsuranceList().get(0).getInsUnemp());
					accFund+=Float.parseFloat(list.get(j).getSalInsuranceList().get(0).getInsAccFund());
					waterAndEle+=list.get(j).getSalSalaryList().get(0).getCalWaterandele();
					withhold+=list.get(j).getSalSalaryList().get(0).getCalWithhold();
					//lastMonthWithhold+=list.get(j).getSalSalaryList().get(0).getCalLastWithhold();
					incomeTax+=(float)(Math.round(list.get(j).getSalSalaryList().get(0).getCalIncometax()*100))/100;
					withholdTotal+=list.get(j).getSalSalaryList().get(0).getCalTotal();
					reality+=list.get(j).getSalSalaryList().get(0).getCalResult();
					mealAllowance+=list.get(j).getSalSalaryList().get(0).getCalAllowance();
					sum.setCount(count);
					sum.setBasic(reserve(basic));
					sum.setPost(reserve(post));
					sum.setComage(reserve(comage));
					sum.setSecrecy(reserve(secrecy));
					sum.setSkillSalary(reserve(skillSalary));
					sum.setBenefit(reserve(benefit));
					sum.setLabourCost(reserve(labourCost));
					sum.setManhour(reserve(manhour));
					sum.setManhourSalary(reserve(manhourSalary));
					sum.setOvertime(reserve(overtime));
					sum.setBonus(reserve(bonus));
					sum.setCheck(reserve(check));
					sum.setAllowance(reserve(allowance));
					sum.setLeave(reserve(leave));
					sum.setInjury(reserve(injury));
					sum.setPenalty(reserve(penalty));
					sum.setOther(reserve(other));
					sum.setShould(reserve(should));
					dues = (float)(Math.round(dues*100))/100;
					sum.setDues(dues);
					sum.setOld(reserve(old));
					sum.setTreatments(reserve(treatments));
					sum.setIll(reserve(ill));
					sum.setUnemp(reserve(unemp));
					sum.setAccFund(reserve(accFund));
					sum.setWaterAndEle(reserve(waterAndEle));
					sum.setWithhold(reserve(withhold));
					sum.setLastMonthWithhold(reserve(lastMonthWithhold));
					incomeTax = (float)(Math.round(incomeTax*100))/100;
					sum.setIncomeTax(incomeTax);
					sum.setWithholdTotal(reserve(withholdTotal));
					sum.setReality(reserve(reality));
					sum.setMealAllowance(reserve(mealAllowance));
				}
			}
			sumList.add(sum);
		}
		//总合计
		Summing sum = new Summing();
		String category ="";
		int count = 0;
		Float basic=0f;
		Float post=0f;
		Float comage=0f;
		Float secrecy=0f;
		Float skillSalary=0f;
		Float benefit=0f;
		Float labourCost=0f;
		Float manhour=0f;
		Float manhourSalary=0f;
		Float overtime=0f;
		Float bonus=0f;
		Float check=0f;
		Float allowance=0f;//津贴
		Float leave=0f;
		Float injury=0f;
		Float penalty=0f;
		Float other=0f;
		Float should=0f;
		Float dues=0f;
		Float old=0f;
		Float treatments=0f;
		Float ill=0f;
		Float unemp=0f;
		Float accFund=0f;
		Float waterAndEle=0f;
		Float withhold=0f;
		Float incomeTax=0f;
		Float lastMonthWithhold=0f;
		Float withholdTotal=0f;
		Float reality=0f;
		Float mealAllowance=0f;
		for(int j=0;j<list.size();j++) {
			count+=1;
			basic+=list.get(j).getSalSalaryList().get(0).getCalBasic();
			post+=list.get(j).getSalSalaryList().get(0).getCalPost();
			comage+=list.get(j).getSalSalaryList().get(0).getCalComage();
			secrecy+=list.get(j).getSalSalaryList().get(0).getCalSecrecy();
			skillSalary+=list.get(j).getSalSalaryList().get(0).getCalSkillLevel();
			benefit+=((list.get(j).getSalSalaryList().get(0).getCalBasic()+list.get(j).getSalSalaryList().get(0).getCalPost())*list.get(j).getSalSalaryList().get(0).getCalCoefficient());
			//labourCost+=list.get(j).getSalSalaryList().get(0).getLabourCost();
			//manhour+=list.get(j).getSalSalaryList().get(0).getCalManhour();
			manhourSalary+=list.get(j).getSalSalaryList().get(0).getCalManhourSalary();
			overtime+=list.get(j).getSalSalaryList().get(0).getCalOvertime();
			bonus+=list.get(j).getSalSalaryList().get(0).getCalBonus();
			check+=list.get(j).getSalSalaryList().get(0).getCalCheck();
			allowance+=list.get(j).getSalSalaryList().get(0).getCalBenefit();
			leave+=list.get(j).getSalSalaryList().get(0).getCalLeave();
			injury+=list.get(j).getSalSalaryList().get(0).getCalInjury();
			penalty+=list.get(j).getSalSalaryList().get(0).getCalPenalty();
			other+=list.get(j).getSalSalaryList().get(0).getCalOther();
			should+=list.get(j).getSalSalaryList().get(0).getCalShould();
			dues+=list.get(j).getSalSalaryList().get(0).getCalDues();
			old+=Float.parseFloat(list.get(j).getSalInsuranceList().get(0).getInsOld());
			treatments+=Float.parseFloat(list.get(j).getSalInsuranceList().get(0).getInsTreatments());
			ill+=Float.parseFloat(list.get(j).getSalInsuranceList().get(0).getInsIll());
			unemp+=Float.parseFloat(list.get(j).getSalInsuranceList().get(0).getInsUnemp());
			accFund+=Float.parseFloat(list.get(j).getSalInsuranceList().get(0).getInsAccFund());
			waterAndEle+=list.get(j).getSalSalaryList().get(0).getCalWaterandele();
			withhold+=list.get(j).getSalSalaryList().get(0).getCalWithhold();
			//lastMonthWithhold+=list.get(j).getSalSalaryList().get(0).getCalLastWithhold();
			incomeTax+=(float)(Math.round(list.get(j).getSalSalaryList().get(0).getCalIncometax()*100))/100;
			withholdTotal+=list.get(j).getSalSalaryList().get(0).getCalTotal();
			reality+=list.get(j).getSalSalaryList().get(0).getCalResult();
			mealAllowance+=list.get(j).getSalSalaryList().get(0).getCalAllowance();
			sum.setCategory(category);
			sum.setCount(count);
			sum.setBasic(reserve(basic));
			sum.setPost(reserve(post));
			sum.setComage(reserve(comage));
			sum.setSecrecy(reserve(secrecy));
			sum.setSkillSalary(reserve(skillSalary));
			sum.setBenefit(reserve(benefit));
			sum.setLabourCost(reserve(labourCost));
			sum.setManhour(reserve(manhour));
			sum.setManhourSalary(reserve(manhourSalary));
			sum.setOvertime(reserve(overtime));
			sum.setBonus(reserve(bonus));
			sum.setCheck(reserve(check));
			sum.setAllowance(reserve(allowance));
			sum.setLeave(reserve(leave));
			sum.setInjury(reserve(injury));
			sum.setPenalty(reserve(penalty));
			sum.setOther(reserve(other));
			sum.setShould(reserve(should));
			dues = (float)(Math.round(dues*100))/100;
			sum.setDues(dues);
			sum.setOld(reserve(old));
			sum.setTreatments(reserve(treatments));
			sum.setIll(reserve(ill));
			sum.setUnemp(reserve(unemp));
			sum.setAccFund(reserve(accFund));
			sum.setWaterAndEle(reserve(waterAndEle));
			sum.setWithhold(reserve(withhold));
			sum.setLastMonthWithhold(reserve(lastMonthWithhold));
			incomeTax = (float)(Math.round(incomeTax*100))/100;
			sum.setIncomeTax(incomeTax);
			sum.setWithholdTotal(reserve(withholdTotal));
			sum.setReality(reserve(reality));
			sum.setMealAllowance(reserve(mealAllowance));
			
		}
		sumList.add(sum);
		return sumList;
	}

	//送银行文件,(银行账号,姓名,实发工资)
	public List<Salary> sendBank() {
		List<Salary> sendBank = salaryMapper.listCal();
		return sendBank;
	}
	
	/**
     * 导出	送银行文件
     * @param salaryDate
     * @return
     * @throws InvocationTargetException
     * @throws ClassNotFoundException
     * @throws IntrospectionException
     * @throws ParseException
     * @throws IllegalAccessException
     */
    public XSSFWorkbook exportExcelInfo() throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException{
        //根据条件查询数据，把数据装载到一个list中
    	List<SendBank> sendBank = salaryMapper.exportSendBank();

        List<ExcelBean> excel=new ArrayList<ExcelBean>();
        Map<Integer,List<ExcelBean>> map=new LinkedHashMap<Integer,List<ExcelBean>>();
        XSSFWorkbook xssfWorkbook=null;

        //设置标题栏
        excel.add(new ExcelBean("银行账号","bankAccount",0));
        excel.add(new ExcelBean("姓名","salName",0));
        excel.add(new ExcelBean("实得","calResult",0));
        
        
        map.put(0, excel);
        String sheetName = "sendBank";
        //调用ExcelUtil的方法
        xssfWorkbook = ExcelUtil.createExcelFile(SendBank.class, sendBank, map, sheetName);
        return xssfWorkbook;
    }
    
    //保存为excel文件(汇总文件(应发))
    public XSSFWorkbook exportExcelDepInfo() throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException{
        //根据条件查询数据，把数据装载到一个list中
    	List<Summing> Summing = department();

        List<ExcelBean> excel=new ArrayList<ExcelBean>();
        Map<Integer,List<ExcelBean>> map=new LinkedHashMap<Integer,List<ExcelBean>>();
        XSSFWorkbook xssfWorkbook=null;

        //设置标题栏
        excel.add(new ExcelBean("部门名称","department",0));
        excel.add(new ExcelBean("基本工资","basic",0));
        excel.add(new ExcelBean("岗位工资","post",0));
        excel.add(new ExcelBean("司龄工资","comage",0));
        excel.add(new ExcelBean("保密工资","secrecy",0));
        excel.add(new ExcelBean("技能工资","skillSalary",0));
        excel.add(new ExcelBean("效益工资","benefit",0));
        excel.add(new ExcelBean("工时工资","manhourSalary",0));
        excel.add(new ExcelBean("加班","overtime",0));
        excel.add(new ExcelBean("奖金","bonus",0));
        excel.add(new ExcelBean("考评工资","check",0));
        excel.add(new ExcelBean("工时","manhour",0));
        excel.add(new ExcelBean("津贴","allowance",0));
        excel.add(new ExcelBean("考勤扣款","leave",0));
        excel.add(new ExcelBean("工伤产假","injury",0));
        excel.add(new ExcelBean("罚款","penalty",0));
        excel.add(new ExcelBean("其他","other",0));
        excel.add(new ExcelBean("应发工资","should",0));
        
        
        map.put(0, excel);
        String sheetName = "Summing";
        //调用ExcelUtil的方法
        xssfWorkbook = ExcelUtil.createExcelFile(Summing.class, Summing, map, sheetName);
        return xssfWorkbook;
    }
    
    //保存为excel文件(统计文件(应发))
    public XSSFWorkbook exportExcelCategoryShould() throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException{
        //根据条件查询数据，把数据装载到一个list中
    	List<Summing> Summing = category();

        List<ExcelBean> excel=new ArrayList<ExcelBean>();
        Map<Integer,List<ExcelBean>> map=new LinkedHashMap<Integer,List<ExcelBean>>();
        XSSFWorkbook xssfWorkbook=null;

        //设置标题栏
        excel.add(new ExcelBean("统计类别","category",0));
        excel.add(new ExcelBean("人数","count",0));
        excel.add(new ExcelBean("基本工资","basic",0));
        excel.add(new ExcelBean("岗位工资","post",0));
        excel.add(new ExcelBean("司龄工资","comage",0));
        excel.add(new ExcelBean("保密工资","secrecy",0));
        excel.add(new ExcelBean("技能工资","skillSalary",0));
        excel.add(new ExcelBean("效益工资","benefit",0));
        excel.add(new ExcelBean("工时工资","manhourSalary",0));
        excel.add(new ExcelBean("加班","overtime",0));
        excel.add(new ExcelBean("奖金","bonus",0));
        excel.add(new ExcelBean("考评工资","check",0));
        excel.add(new ExcelBean("工时","manhour",0));
        excel.add(new ExcelBean("津贴","allowance",0));
        excel.add(new ExcelBean("考勤扣款","leave",0));
        excel.add(new ExcelBean("工伤产假","injury",0));
        excel.add(new ExcelBean("罚款","penalty",0));
        excel.add(new ExcelBean("其他","other",0));
        excel.add(new ExcelBean("应发工资","should",0));
        
        
        map.put(0, excel);
        String sheetName = "Summing";
        //调用ExcelUtil的方法
        xssfWorkbook = ExcelUtil.createExcelFile(Summing.class, Summing, map, sheetName);
        return xssfWorkbook;
    }
    
    //保存为excel文件(汇总文件(实得))
    public XSSFWorkbook exportExcelDepReality() throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException{
        //根据条件查询数据，把数据装载到一个list中
    	List<Summing> Summing = department();

        List<ExcelBean> excel=new ArrayList<ExcelBean>();
        Map<Integer,List<ExcelBean>> map=new LinkedHashMap<Integer,List<ExcelBean>>();
        XSSFWorkbook xssfWorkbook=null;

        //设置标题栏
        excel.add(new ExcelBean("部门名称","department",0));
        excel.add(new ExcelBean("会费","dues",0));
        excel.add(new ExcelBean("养老保险","old",0));
        excel.add(new ExcelBean("医保","treatments",0));
        excel.add(new ExcelBean("大病","ill",0));
        excel.add(new ExcelBean("失业","unemp",0));
        excel.add(new ExcelBean("扣款","withhold",0));
        excel.add(new ExcelBean("水电费","waterAndEle",0));
        excel.add(new ExcelBean("公积金","accFund",0));
        excel.add(new ExcelBean("所得税","incomeTax",0));
        excel.add(new ExcelBean("扣款合计","withholdTotal",0));
        excel.add(new ExcelBean("实得工资","reality",0));
        excel.add(new ExcelBean("下月扣款","lastMonthWithhold",0));
        excel.add(new ExcelBean("餐补","mealAllowance",0));
        excel.add(new ExcelBean("合计","reality",0));
        
        
        map.put(0, excel);
        String sheetName = "Summing";
        //调用ExcelUtil的方法
        xssfWorkbook = ExcelUtil.createExcelFile(Summing.class, Summing, map, sheetName);
        return xssfWorkbook;
    }
    
    //保存为excel文件(统计文件(实得))
    public XSSFWorkbook exportExcelCategoryReality() throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException{
        //根据条件查询数据，把数据装载到一个list中
    	List<Summing> Summing = category();

        List<ExcelBean> excel=new ArrayList<ExcelBean>();
        Map<Integer,List<ExcelBean>> map=new LinkedHashMap<Integer,List<ExcelBean>>();
        XSSFWorkbook xssfWorkbook=null;

        //设置标题栏
        excel.add(new ExcelBean("统计类别","category",0));
        excel.add(new ExcelBean("人数","count",0));
        excel.add(new ExcelBean("会费","dues",0));
        excel.add(new ExcelBean("养老保险","old",0));
        excel.add(new ExcelBean("医保","treatments",0));
        excel.add(new ExcelBean("大病","ill",0));
        excel.add(new ExcelBean("失业","unemp",0));
        excel.add(new ExcelBean("扣款","withhold",0));
        excel.add(new ExcelBean("水电费","waterAndEle",0));
        excel.add(new ExcelBean("公积金","accFund",0));
        excel.add(new ExcelBean("所得税","incomeTax",0));
        excel.add(new ExcelBean("扣款合计","withholdTotal",0));
        excel.add(new ExcelBean("实得工资","reality",0));
        excel.add(new ExcelBean("下月扣款","lastMonthWithhold",0));
        excel.add(new ExcelBean("餐补","mealAllowance",0));
        excel.add(new ExcelBean("合计","reality",0));
        
        
        map.put(0, excel);
        String sheetName = "Summing";
        //调用ExcelUtil的方法
        xssfWorkbook = ExcelUtil.createExcelFile(Summing.class, Summing, map, sheetName);
        return xssfWorkbook;
    }
    
    //用folat存储数值会损失精度，reserve方法保留2位小数
    public Float reserve(Float f) {
    	return (float)(Math.round(f*100))/100;
    }

}
