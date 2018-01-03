package com.tl.sm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tl.sm.pojo.ExcelExport;
import com.tl.sm.pojo.Salary;
import com.tl.sm.pojo.SendBank;
import com.tl.sm.pojo.Summing;

public interface SalaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Salary record);

    int insertSelective(Salary record);

    Salary selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Salary record);

    int updateByPrimaryKey(Salary record);
    
    //批量插入
    int insertForeach(List<Salary> list);
    
    //查询所有
    List<Salary> listCal();
    
    //模糊查询
    List<Salary> listCalBlurry(@Param("cal_id") String calId,@Param("cal_name") String calName
    		,@Param("cal_date") String calDate,@Param("cal_id2") String calId2,@Param("cal_name2") String calName2
    		,@Param("cal_date2") String calDate2);
    
    //导出
    List<Salary> selectCal(@Param("cal_date") String calDate);
    List<ExcelExport> exportAll(@Param("cal_date") String calDate);
    
    //导出送银行文件
    List<SendBank> exportSendBank();
    
    //导出部门工资文件
    List<Summing> exportDepInfo();
    
    //批量更新工资
    int updateBatchSalary(List<Salary> list);
}