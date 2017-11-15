package com.tl.sm.mapper;

import com.tl.sm.pojo.Insurance;

public interface InsuranceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Insurance record);

    int insertSelective(Insurance record);

    Insurance selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Insurance record);

    int updateByPrimaryKey(Insurance record);
}