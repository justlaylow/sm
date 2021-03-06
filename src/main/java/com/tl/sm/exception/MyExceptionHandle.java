package com.tl.sm.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.tl.sm.pojo.BusinessException;

public class MyExceptionHandle implements HandlerExceptionResolver {  
	  
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,  
            Exception ex) {  
        Map<String, Object> model = new HashMap<String, Object>();  
        model.put("ex", ex);  
          
        // 根据不同错误转向不同页面  
        if(ex instanceof BusinessException) {  
            return new ModelAndView("error-business", model);  
        }else if(ex instanceof DuplicateKeyException) {  
        	ex.printStackTrace();
            return new ModelAndView("error/error-idRepetition", model);  
        }else {
        	ex.printStackTrace();
            return new ModelAndView("error", model);  
        }  
    }  
}
