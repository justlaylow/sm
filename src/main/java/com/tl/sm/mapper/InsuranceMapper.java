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
    
    //通过工号查询
    Insurance selectByInsId(@Param("ins_id") String insId);
    
    //查询所有
    List<Insurance> listIns();
    
    //模糊查询
    List<Insurance> listInsBlurry(@Param("ins_id") String insId,@Param("ins_name") String insName);
    
    //批量更新
    int updateBatch(List<Insurance> list);
    
    //批量导入更新
    int importBatch(List<Insurance> list);
}