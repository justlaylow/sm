package com.tl.sm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tl.sm.pojo.Employee;

public interface EmployeeMapper {
    int deleteByPrimaryKey(String id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
    
    List<Employee> listEmp();
    
    List<Employee> listEmpBlurry(@Param("sal_name") String salName,@Param("sal_id") String salId,
    		@Param("sal_oa") String salOa);
    
    List<Employee> listInner();
}