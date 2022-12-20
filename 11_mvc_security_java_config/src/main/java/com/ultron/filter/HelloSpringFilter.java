package com.ultron.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("helloFilter")
public class HelloSpringFilter implements Filter {

	@Autowired
	private String message;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Before Request Passing %s".formatted(message));
		chain.doFilter(request, response);
		System.out.println("After Request Passing %s".formatted(message));
	}
	
	@Override
	public void destroy() {
		
	}
	
	
	
}
