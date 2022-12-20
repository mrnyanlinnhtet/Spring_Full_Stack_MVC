package com.ultron.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import com.ultron.model.dto.Course;

@Service
public class CourseService {

	@Autowired
	private SimpleJdbcInsert jdbc;

	private RowMapper<Course> mapper;

	public CourseService() {
		mapper = new BeanPropertyRowMapper<Course>(Course.class);
	}

	public int save(Course c) {
		if (c.getId() > 0) {
			return updateCourse(c);
		}
		var params = new HashMap<String, Object>();
		params.put("name", c.getName());
		params.put("level", c.getLevel().name());
		params.put("fees", c.getFees());
		params.put("duration", c.getDuration());
		return jdbc.executeAndReturnKeyHolder(params).getKey().intValue();

	}

	// Update Course
	public int updateCourse(Course c) {
		final String UPDATE = "UPDATE courses SET name = ?,level=?,fees=?,duration=? WHERE id = ?";
		jdbc.getJdbcTemplate().update(UPDATE, c.getName(), c.getLevel().name(), c.getFees(), c.getDuration(),
				c.getId());

		return c.getId();
	}

	// FindById
	public Course findById(int id) {
		final String FIND_BY_ID = "SELECT * FROM courses WHERE id = ?";
		return jdbc.getJdbcTemplate().query(FIND_BY_ID, mapper, id).stream().findAny().orElse(null);
	}

	// Get All Course
	public List<Course> getAllCourse() {
		final String SELECT_ALL = "SELECT * FROM courses";
		return jdbc.getJdbcTemplate().query(SELECT_ALL, mapper);
	}

}
