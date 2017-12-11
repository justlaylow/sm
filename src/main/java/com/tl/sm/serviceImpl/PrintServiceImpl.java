package com.tl.sm.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tl.sm.mapper.DepartmentMapper;
import com.tl.sm.mapper.EmployeeMapper;
import com.tl.sm.mapper.SalaryMapper;
import com.tl.sm.pojo.Department;
import com.tl.sm.pojo.Employee;
import com.tl.sm.pojo.Salary;
import com.tl.sm.pojo.Summing;
import com.tl.sm.service.PrintService;
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
			department = listDep.get(i).getDepName();
			sum.setDepartment(department);
			for(int j=0;j<list.size();j++) {
				if(listDep.get(i).getDepName().equals(list.get(j).getSalDep())) {
					basic+=list.get(j).getSalSalaryList().get(0).getCalBasic();
					post+=list.get(j).getSalSalaryList().get(0).getCalPost();
					comage+=list.get(j).getSalSalaryList().get(0).getCalComage();
					secrecy+=list.get(j).getSalSalaryList().get(0).getCalSecrecy();
					skillSalary+=list.get(j).getSalSalaryList().get(0).getCalSkillLevel();
					benefit+=list.get(j).getSalSalaryList().get(0).getCalBenefitwage();
					labourCost+=list.get(j).getSalSalaryList().get(0).getLabourCost();
					manhour+=list.get(j).getSalSalaryList().get(0).getCalManhour();
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
					lastMonthWithhold+=list.get(j).getSalSalaryList().get(0).getCalLastWithhold();
					incomeTax+=list.get(j).getSalSalaryList().get(0).getCalIncometax();
					withholdTotal+=list.get(j).getSalSalaryList().get(0).getCalTotal();
					reality+=list.get(j).getSalSalaryList().get(0).getCalResult();
					mealAllowance+=list.get(j).getSalSalaryList().get(0).getCalAllowance();
					sum.setBasic(basic);
					sum.setPost(post);
					sum.setComage(comage);
					sum.setSecrecy(secrecy);
					sum.setSkillSalary(skillSalary);
					sum.setBenefit(benefit);
					sum.setLabourCost(labourCost);
					sum.setManhour(manhour);
					sum.setManhourSalary(manhourSalary);
					sum.setOvertime(overtime);
					sum.setBonus(bonus);
					sum.setCheck(check);
					sum.setAllowance(allowance);
					sum.setLeave(leave);
					sum.setInjury(injury);
					sum.setPenalty(penalty);
					sum.setOther(other);
					sum.setShould(should);
					dues = (float)(Math.round(dues*100))/100;
					sum.setDues(dues);
					sum.setOld(old);
					sum.setTreatments(treatments);
					sum.setIll(ill);
					sum.setUnemp(unemp);
					sum.setAccFund(accFund);
					sum.setWaterAndEle(waterAndEle);
					sum.setWithhold(withhold);
					sum.setLastMonthWithhold(lastMonthWithhold);
					incomeTax = (float)(Math.round(incomeTax*100))/100;
					sum.setIncomeTax(incomeTax);
					sum.setWithholdTotal(withholdTotal);
					sum.setReality(reality);
					sum.setMealAllowance(mealAllowance);
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
			benefit+=list.get(j).getSalSalaryList().get(0).getCalBenefitwage();
			labourCost+=list.get(j).getSalSalaryList().get(0).getLabourCost();
			manhour+=list.get(j).getSalSalaryList().get(0).getCalManhour();
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
			lastMonthWithhold+=list.get(j).getSalSalaryList().get(0).getCalLastWithhold();
			incomeTax+=(float)(Math.round(list.get(j).getSalSalaryList().get(0).getCalIncometax()*100))/100;
			withholdTotal+=list.get(j).getSalSalaryList().get(0).getCalTotal();
			reality+=list.get(j).getSalSalaryList().get(0).getCalResult();
			mealAllowance+=list.get(j).getSalSalaryList().get(0).getCalAllowance();
			sum.setDepartment(department);
			sum.setCount(count);
			sum.setBasic(basic);
			sum.setPost(post);
			sum.setComage(comage);
			sum.setSecrecy(secrecy);
			sum.setSkillSalary(skillSalary);
			sum.setBenefit(benefit);
			sum.setLabourCost(labourCost);
			sum.setManhour(manhour);
			sum.setManhourSalary(manhourSalary);
			sum.setOvertime(overtime);
			sum.setBonus(bonus);
			sum.setCheck(check);
			sum.setAllowance(allowance);
			sum.setLeave(leave);
			sum.setInjury(injury);
			sum.setPenalty(penalty);
			sum.setOther(other);
			sum.setShould(should);
			dues = (float)(Math.round(dues*100))/100;
			sum.setDues(dues);
			sum.setOld(old);
			sum.setTreatments(treatments);
			sum.setIll(ill);
			sum.setUnemp(unemp);
			sum.setAccFund(accFund);
			sum.setWaterAndEle(waterAndEle);
			sum.setWithhold(withhold);
			sum.setLastMonthWithhold(lastMonthWithhold);
			incomeTax = (float)(Math.round(incomeTax*100))/100;
			sum.setIncomeTax(incomeTax);
			sum.setWithholdTotal(withholdTotal);
			sum.setReality(reality);
			sum.setMealAllowance(mealAllowance);
			
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
					benefit+=list.get(j).getSalSalaryList().get(0).getCalBenefitwage();
					labourCost+=list.get(j).getSalSalaryList().get(0).getLabourCost();
					manhour+=list.get(j).getSalSalaryList().get(0).getCalManhour();
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
					lastMonthWithhold+=list.get(j).getSalSalaryList().get(0).getCalLastWithhold();
					incomeTax+=(float)(Math.round(list.get(j).getSalSalaryList().get(0).getCalIncometax()*100))/100;
					withholdTotal+=list.get(j).getSalSalaryList().get(0).getCalTotal();
					reality+=list.get(j).getSalSalaryList().get(0).getCalResult();
					mealAllowance+=list.get(j).getSalSalaryList().get(0).getCalAllowance();
					sum.setCount(count);
					sum.setBasic(basic);
					sum.setPost(post);
					sum.setComage(comage);
					sum.setSecrecy(secrecy);
					sum.setSkillSalary(skillSalary);
					sum.setBenefit(benefit);
					sum.setLabourCost(labourCost);
					sum.setManhour(manhour);
					sum.setManhourSalary(manhourSalary);
					sum.setOvertime(overtime);
					sum.setBonus(bonus);
					sum.setCheck(check);
					sum.setAllowance(allowance);
					sum.setLeave(leave);
					sum.setInjury(injury);
					sum.setPenalty(penalty);
					sum.setOther(other);
					sum.setShould(should);
					dues = (float)(Math.round(dues*100))/100;
					sum.setDues(dues);
					sum.setOld(old);
					sum.setTreatments(treatments);
					sum.setIll(ill);
					sum.setUnemp(unemp);
					sum.setAccFund(accFund);
					sum.setWaterAndEle(waterAndEle);
					sum.setWithhold(withhold);
					sum.setLastMonthWithhold(lastMonthWithhold);
					incomeTax = (float)(Math.round(incomeTax*100))/100;
					sum.setIncomeTax(incomeTax);
					sum.setWithholdTotal(withholdTotal);
					sum.setReality(reality);
					sum.setMealAllowance(mealAllowance);
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
			benefit+=list.get(j).getSalSalaryList().get(0).getCalBenefitwage();
			labourCost+=list.get(j).getSalSalaryList().get(0).getLabourCost();
			manhour+=list.get(j).getSalSalaryList().get(0).getCalManhour();
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
			lastMonthWithhold+=list.get(j).getSalSalaryList().get(0).getCalLastWithhold();
			incomeTax+=(float)(Math.round(list.get(j).getSalSalaryList().get(0).getCalIncometax()*100))/100;
			withholdTotal+=list.get(j).getSalSalaryList().get(0).getCalTotal();
			reality+=list.get(j).getSalSalaryList().get(0).getCalResult();
			mealAllowance+=list.get(j).getSalSalaryList().get(0).getCalAllowance();
			sum.setCategory(category);
			sum.setCount(count);
			sum.setBasic(basic);
			sum.setPost(post);
			sum.setComage(comage);
			sum.setSecrecy(secrecy);
			sum.setSkillSalary(skillSalary);
			sum.setBenefit(benefit);
			sum.setLabourCost(labourCost);
			sum.setManhour(manhour);
			sum.setManhourSalary(manhourSalary);
			sum.setOvertime(overtime);
			sum.setBonus(bonus);
			sum.setCheck(check);
			sum.setAllowance(allowance);
			sum.setLeave(leave);
			sum.setInjury(injury);
			sum.setPenalty(penalty);
			sum.setOther(other);
			sum.setShould(should);
			dues = (float)(Math.round(dues*100))/100;
			sum.setDues(dues);
			sum.setOld(old);
			sum.setTreatments(treatments);
			sum.setIll(ill);
			sum.setUnemp(unemp);
			sum.setAccFund(accFund);
			sum.setWaterAndEle(waterAndEle);
			sum.setWithhold(withhold);
			sum.setLastMonthWithhold(lastMonthWithhold);
			incomeTax = (float)(Math.round(incomeTax*100))/100;
			sum.setIncomeTax(incomeTax);
			sum.setWithholdTotal(withholdTotal);
			sum.setReality(reality);
			sum.setMealAllowance(mealAllowance);
			
		}
		sumList.add(sum);
		return sumList;
	}

	//送银行文件,(银行账号,姓名,实发工资)
	public List<Salary> sendBank() {
		List<Salary> sendBank = salaryMapper.listCal();
		return sendBank;
	}

}
