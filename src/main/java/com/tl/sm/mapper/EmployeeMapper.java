package com.tl.sm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tl.sm.pojo.Department;
import com.tl.sm.pojo.Employee;

public interface EmployeeMapper {
    int deleteByPrimaryKey(String id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);
    
    Employee selectByEmpId(String salId);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
    
    List<Employee> listEmp();
    
    List<Department> listDep();
    
    List<Employee> listEmpBlurry(@Param("sal_name") String salName,@Param("sal_id") String salId,
    		@Param("sal_oa") String salOa,@Param("sal_name2") String salName2,@Param("sal_id2") String salId2,
    		@Param("sal_oa2") String salOa2);
    
    //查询员工表联合保险表
    List<Employee> listInner();
    
    //三表查询
    List<Employee> listAll(@Param("cal_date") String calDate,@Param("sal_id") String salId,
    		@Param("sal_name") String salName);
    
    //查询三表信息,保险和工资为员工的属性集合
  	List<Employee> printAll();
  	
  	//通过部门名查询三表信息,保险和工资为员工的属性集合
  	List<Employee> printByDepName(@Param("sal_dep") String salDep);
  	
  	//批量导入
    int insertForeach(List<Employee> list);
    
}