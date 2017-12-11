package com.tl.sm.serviceImpl;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tl.sm.mapper.InsuranceMapper;
import com.tl.sm.pojo.Employee;
import com.tl.sm.pojo.Insurance;
import com.tl.sm.pojo.Salary;
import com.tl.sm.service.InsuranceService;
import com.tl.sm.util.ExcelUtil;

@Service
public class InsuranceServiceImpl implements InsuranceService{
	@Resource
	private InsuranceMapper insuranceMapper;

	//查询所有的保险信息 
	public List<Insurance> listIns() {
		List<Insurance> listIns = insuranceMapper.listIns();
		return listIns;
	}

	//模糊查询
	public List<Insurance> listInsBlurry(String insId,String insName) {
		List<Insurance> listInsBlurry = insuranceMapper.listInsBlurry(insId, insName);
		return listInsBlurry;
	}

	//更新
	public String updateIns(Insurance insurance) {
		String message = "";
		int i = insuranceMapper.updateByPrimaryKey(insurance);
		if(i>0) {
			message = "更新成功";
		}else {
			message = "更新失败";
		}
		return message;
	}

	//删除
	public String deleteIns(Integer insId) {
		String message = "";
		int i = insuranceMapper.deleteByPrimaryKey(insId);
		if(i>0) {
			message = "删除成功";
		}else {
			message = "删除失败";
		}
		return message;
	}

	//新增
	public String insertIns(Insurance insurance) {
		String message = "";
		int i = insuranceMapper.insert(insurance);
		if(i>0) {
			message = "添加成功";
		}else {
			message = "添加失败";
		}
		return message;
	}

	//批量更新,用于直接在页面上进行修改并提交,更直观
	public String updateBatch(List<Insurance> list) {
		String message = "";
		int i = insuranceMapper.updateBatch(list);
		if(i>0) {
			message = "修改成功";
		}else {
			message = "修改失败";
		}
		return message;
	}
	
	//poi Excel导入
	public List<Insurance> importExcelInfo(InputStream in, MultipartFile file,Integer adminId) throws Exception{  
	    List<List<Object>> listob = ExcelUtil.getBankListByExcel(in,file.getOriginalFilename());  
	    List<Insurance> insuranceList = new ArrayList<Insurance>();
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    //遍历listob数据，把数据放到List中  
	    for (int i = 0; i < listob.size(); i++) { 
	        List<Object> ob = listob.get(i);  
	        Insurance insurance = new Insurance();  
	        //设置编号  String.valueOf(ob.get())
	        //通过遍历实现把每一列封装成一个model中，再把所有的model用List集合装载 
	        insurance.setInsId(ob.get(0).toString());
	        insurance.setInsName(ob.get(1).toString());
	        insurance.setInsCarNumber(ob.get(2).toString());
	        insurance.setInsOld(ob.get(3).toString());
	        insurance.setInsTreatments(ob.get(4).toString());
	        insurance.setInsIll(ob.get(5).toString());
	        insurance.setInsUnemp(ob.get(6).toString());
	        insurance.setInsAccFund(ob.get(7).toString());
	          
	        insuranceList.add(insurance);
	    }  
	    return insuranceList;  
	}
	
	//批量更新,通过导入excel表实现,修改的字段比updateBatch少,可以考虑直接用updateBatch
	public String importBatch(List<Insurance> list) {
		String message = "";
		int i = insuranceMapper.importBatch(list);
		if(i>0) {
			message = "更新成功";
		}else {
			message = "更新失败";
		}
		return message;
	}
	
}
