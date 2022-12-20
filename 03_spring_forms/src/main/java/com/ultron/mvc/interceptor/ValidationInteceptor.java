package com.ultron.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class ValidationInteceptor implements HandlerInterceptor {
	
	private static final String BINDING = "org.springframework.validation.BindingResult";
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		var errors = modelAndView.getModel().entrySet().stream()
	    .filter(a->a.getKey().startsWith(BINDING))
	    .map(a->a.getValue()).filter(a-> a instanceof BindingResult result)
	    .map(a->(BindingResult)a)
	    .flatMap(a->a.getAllErrors().stream())
	    .map(a->a.getDefaultMessage()).toList();
	    
		 modelAndView.getModel().put("allErrors", errors);
	}

}
