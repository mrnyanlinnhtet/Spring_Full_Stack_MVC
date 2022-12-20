package com.ultron.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ultron.mvc.inteceptor.AsyncInterceptorDemo;
import com.ultron.mvc.inteceptor.CallableResultInterceptor;
import com.ultron.mvc.inteceptor.DeferredResultInterceptor;

@Configuration
@ComponentScan("com.ultron.mvc")
@EnableWebMvc
public class ServletConfig implements WebMvcConfigurer {

	@Autowired
	private AsyncTaskExecutor executor;

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp().suffix(".jsp").prefix("/views/");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
	}

	@Override
	public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
		configurer.setTaskExecutor(executor);
		configurer.registerCallableInterceptors(new CallableResultInterceptor());
		configurer.registerDeferredResultInterceptors(new DeferredResultInterceptor());
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AsyncInterceptorDemo());
	}
}
