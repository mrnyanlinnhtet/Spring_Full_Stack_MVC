package com.ultron.dto;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Book {

	private int id;
	@NotBlank(message = "{error.title}")
	private String title;
	@NotBlank(message = "{error.author}")
	private String author;
	@NotNull(message = "{error.category}")
	private Category category;
	@Min(value = 300,message = "{error.price}")
	private int price;
	private String remark;

	public Map<String, Object> getInsertParam() {
		var map = new HashMap<String, Object>();
		map.put("title", title);
		map.put("author", author);
		map.put("price", price);
		map.put("remark", remark);
		map.put("category_id", category.getId());

		return map;
	}

	public Map<String, Object> getUpdateParams() {
		var map = new HashMap<String, Object>(getInsertParam());
		map.put("id", id);
		return map;
	}

}
