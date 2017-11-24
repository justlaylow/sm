package com.tl.sm.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tl.sm.mapper.ExceptionHandle;
import com.tl.sm.pojo.BusinessException;
import com.tl.sm.pojo.ParameterException;
import com.tl.sm.service.ExceptionService;
@Service
public class ExceptionServiceImpl implements ExceptionService{
	@Resource
	private ExceptionHandle exceptionHandle;

	@Override
	public void exception(Integer id) throws Exception {
		switch(id) {
		case 1:
			throw new BusinessException("11","service11");
		case 2:
			throw new BusinessException("21","service21");
		case 3:
			throw new BusinessException("31","service31");
		case 4:
			throw new BusinessException("41","service41");
		case 5:
			throw new BusinessException("51","service51");
		default:
			throw new ParameterException("service Parameter error");
		}
		
	}

	@Override
	public void dao(Integer id) throws Exception {
		exceptionHandle.exception(id);
		
	}
	
	
}
