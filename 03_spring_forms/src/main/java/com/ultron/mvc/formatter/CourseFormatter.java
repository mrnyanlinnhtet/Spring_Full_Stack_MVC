package com.ultron.mvc.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.ultron.dto.Course;
import com.ultron.root.services.CourseService;

@Component("courseFormatter")
public class CourseFormatter implements Formatter<Course> {

	@Autowired
	private CourseService service;

	@Override
	public String print(Course object, Locale locale) {
		if (object != null) {
			return object.getName();
		}
		return null;
	}

	@Override
	public Course parse(String value, Locale locale) throws ParseException {

		if (value != null) {
			int id = Integer.parseInt(value);
			var obj = service.findById(id);
			System.out.println(obj);
			return obj;
		}
		return null;
	}

}
