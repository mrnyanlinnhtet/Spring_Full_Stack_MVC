package com.ultron.mvc.convertor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ultron.dto.Course;
import com.ultron.root.services.CourseService;

@Component("courseConverter")
public class CourseConverter implements Converter<String, Course> {

	@Autowired
	private CourseService service;

	@Override
	public Course convert(String value) {

		if (value != null) {
			int id = Integer.parseInt(value);
			return service.findById(id);
		}

		return null;
	}

}
