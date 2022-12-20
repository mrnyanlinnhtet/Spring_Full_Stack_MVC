package com.ultron.root.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import com.ultron.dto.Category;

@Service
public class CategoryService {

	private static final String SELECT = "SELECT * FROM category WHERE id = :id";
	private static final String SELECT_CATEGORY_BY_NAME = "SELECT * FROM category WHERE name = :name";
	@Autowired
	private NamedParameterJdbcTemplate template;

	@Autowired
	private SimpleJdbcInsert jdbc;

	@Autowired
	private BeanPropertyRowMapper<Category> mapper;

	@PostConstruct
	public void init() {
		jdbc.setTableName("category");
		jdbc.setGeneratedKeyName("id");
	}

	// Get All To Category
	public List<Category> getAll() {
		final String SELECT_ALL = "SELECT * FROM category ORDER BY id ASC";
		return template.query(SELECT_ALL, mapper);
	}

	public Optional<Category> findById(int id) {
		return template.queryForStream(SELECT, Map.of("id", id), mapper).findFirst();
	}

	public Category getCategory(String name) {

		var searchResult = template.queryForStream(SELECT_CATEGORY_BY_NAME, Map.of("name", name), mapper).findFirst();
		if (searchResult.isEmpty() || searchResult == null) {
			var id = jdbc.executeAndReturnKey(Map.of("name", name)).intValue();
			return new Category(id, name);
		}

		return searchResult.orElse(null);
	}

}
