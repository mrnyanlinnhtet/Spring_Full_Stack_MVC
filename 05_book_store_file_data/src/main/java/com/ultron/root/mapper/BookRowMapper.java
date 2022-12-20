package com.ultron.root.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.ultron.dto.Book;
import com.ultron.dto.Category;

@Component
public class BookRowMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		Book b = new Book();
		b.setCategory(new Category());
		b.getCategory().setId(rs.getInt("categoryId"));
		b.getCategory().setName(rs.getString("categoryName"));
		b.setId(rs.getInt("id"));
		b.setTitle(rs.getString("title"));
		b.setAuthor(rs.getString("author"));
		b.setPrice(rs.getInt("price"));
		b.setRemark(rs.getString("remark"));

		return b;
	}

}
