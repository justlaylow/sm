package com.tl.sm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tl.sm.pojo.Insurance;

public interface InsuranceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Insurance record);

    int insertSelective(Insurance record);

    Insurance selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Insurance record);

    int updateByPrimaryKey(Insurance record);
    
    //查询所有
    List<Insurance> listIns();
    
    //模糊查询
    List<Insurance> listInsBlurry(@Param("ins_id") String insId,@Param("ins_name") String insName);
    
    
}