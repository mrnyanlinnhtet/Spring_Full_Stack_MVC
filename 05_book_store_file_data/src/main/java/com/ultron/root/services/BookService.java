package com.ultron.root.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ultron.dto.Book;
import com.ultron.root.mapper.BookRowMapper;

@Service
public class BookService {

	@Autowired
	private NamedParameterJdbcTemplate template;

	@Autowired
	private BookRowMapper mapper;

	@Autowired
	private SimpleJdbcInsert jdbc;

	private static final String SELECT = """
			SELECT b.id,b.title,b.author,b.price,b.remark,
			c.id categoryId,c.name categoryName FROM book b JOIN category c
			ON c.id = b.category_id WHERE 1 = 1
				""";

	private static final String UPDATE = """
			UPDATE book SET title=:title,author=:author,price=:price,
			remark=:remark,category_id=:category_id
			WHERE id=:id;
			""";

	@PostConstruct
	public void init() {
		jdbc.setTableName("book");
		jdbc.setGeneratedKeyName("id");

	}

	// Search
	public List<Book> search(Integer categoryId, String keyword) {
		StringBuffer bf = new StringBuffer(SELECT);
		Map<String, Object> params = new HashMap<String, Object>();

		if (null != categoryId) {
			bf.append(" AND c.id =:categoryId");
			params.put("categoryId", categoryId);
		}

		if (StringUtils.hasLength(keyword)) {
			bf.append("""
					  AND(
					  lower(name) LIKE :keyword OR
					  lower(title) LIKE :keyword OR
					  lower(author) LIKE :keyword
					 )
					""");

			params.put("keyword", keyword.concat("%"));
		}
		return template.query(bf.toString(), params, mapper);
	}

	// Find By Id
	public Optional<Book> findById(Integer id) {
		return template.queryForStream(SELECT.concat(" AND b.id=:id"), Map.of("id", id), mapper).findFirst();
	}

	// Save
	public int save(Book book) {
		if (book.getId() == 0) {
			// Save(Insert)
			return jdbc.executeAndReturnKeyHolder(book.getInsertParam()).getKey               ().intValue();

		}

		// update
		template.update(UPDATE, book.getUpdateParams());
		return book.getId();
	}

}
