package com.tl.sm.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tl.sm.pojo.Salary;

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
    		,@Param("cal_date") String calDate);
}