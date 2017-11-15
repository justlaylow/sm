package com.tl.sm.mapper;

import java.util.List;

import com.tl.sm.pojo.Salary;

public interface SalaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Salary record);

    int insertSelective(Salary record);

    Salary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Salary record);

    int updateByPrimaryKey(Salary record);
    
    //批量插入
    int insertForeach(List<Salary> list);
}