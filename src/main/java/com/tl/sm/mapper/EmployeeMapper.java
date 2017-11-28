package com.tl.sm.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tl.sm.pojo.Department;
import com.tl.sm.pojo.Employee;

public interface EmployeeMapper {
    int deleteByPrimaryKey(String id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
    
    List<Employee> listEmp();
    
    List<Department> listDep();
    
    List<Employee> listEmpBlurry(@Param("sal_name") String salName,@Param("sal_id") String salId,
    		@Param("sal_oa") String salOa,@Param("sal_name2") String salName2,@Param("sal_id2") String salId2,
    		@Param("sal_oa2") String salOa2);
    
    List<Employee> listInner();
    
    //三表查询
    List<Employee> listAll(@Param("cal_date") String calDate,@Param("sal_id") String salId);
    
}