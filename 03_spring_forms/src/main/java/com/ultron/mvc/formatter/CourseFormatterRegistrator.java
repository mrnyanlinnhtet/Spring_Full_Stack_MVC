package com.ultron.mvc.formatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;

@Configuration
public class CourseFormatterRegistrator {
	
	@Autowired
	private CourseFormatter formattor;
	
	
	@Autowired
	void addFormattor(FormatterRegistry registry) {
		registry.addFormatter(formattor);
	}

}
