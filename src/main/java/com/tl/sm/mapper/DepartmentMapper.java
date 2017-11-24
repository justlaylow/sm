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
	
	List<Department> DepName(@Param("id") Integer id);

	int updateByPrimaryKey(Department record);
	
	int updateEmpDep(@Param("sal_dep") String salDep,@Param("sal_dep2") String salDepName);

	List<Department> listAll();

	List<Department> listByDep(@Param("dep_id") String depId, @Param("dep_name") String depName);
}