package com.ultron.root.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import com.ultron.dto.Course;

@Service
@ApplicationScope
public class CourseService {

	private List<Course> data;

	public CourseService() {
		data = List.of(new Course(1, "Spring", 200000), new Course(2, "Angular", 100000),
				new Course(2, "JavaSE", 150000), new Course(4, "JavaEE", 200000), new Course(5, "Flutter", 100000));
	}

	public List<Course> getAllData() {
		return data;
	}

	public Course findById(int id) {
		return data.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
	}

}
