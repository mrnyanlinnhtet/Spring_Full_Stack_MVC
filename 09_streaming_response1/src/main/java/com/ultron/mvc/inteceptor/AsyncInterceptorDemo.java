package com.ultron.mvc.inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AsyncInterceptorDemo implements AsyncHandlerInterceptor {
	
	 @Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("""
			 ==============> After ConcurrentHandling Start
				""");
	}
	 
	 @Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		 System.out.println("""
				 ==============> Pre Handle
					""");
		return true;
	}
	 
	 @Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		 System.out.println("""
				 ==============> Post Handle
					""");
	}
	 
	 @Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		 
		 System.out.println("""
				 ==============> After Completion
					""");
		
	}

}
