package com.tl.sm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tl.sm.pojo.Department;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
    
    List<Department> listAll();
    
    List<Department> listByDep(@Param("dep_id") String depId,@Param("dep_name") String depName);
}