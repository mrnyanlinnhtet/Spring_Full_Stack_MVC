package com.ultron.root.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import com.ultron.dto.Book;
import com.ultron.dto.Category;
import com.ultron.root.utils.FileUploadAppException;

@Service
public class FileUploadService {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private BookService bookService;

	@Autowired
	private Validator validator;

	@Transactional
	public String upload(MultipartFile file) {

		// Map-> Category:Book Object
		var categoryBookMap = bookList(file).stream().collect(Collectors.groupingBy(a -> a.getCategory().getName()));

		for (var entry : categoryBookMap.entrySet()) {

			var categories = categoryService.getCategory(entry.getKey());

			for (var book : entry.getValue()) {
				if (categories != null) {
					book.setCategory(categories);

					var result = new BeanPropertyBindingResult(book, "target");
					validator.validate(book, result);

					if (result.hasErrors()) {
						var message = result.getAllErrors().stream().map(a -> a.getDefaultMessage()).findFirst().get();
						throw new FileUploadAppException(message);
					}

				}
				bookService.save(book);
			}

		}

		return "%d books had been uploaded !".formatted(categoryBookMap.size());
	}

	public List<Book> bookList(MultipartFile file) {

		var list = new ArrayList<Book>();

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			String line = null;

			while (null != (line = reader.readLine())) {
				var book = convertBook(line);
				list.add(book);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}

	private Book convertBook(String line) {
		var array = line.split("\t");

		if (array.length < 4 && array.length > 5) {
			// TODO Exception Handaling
		}

		Book b = new Book();

		b.setTitle(array[0].trim());
		b.setAuthor(array[1].trim());
		b.setCategory(new Category(array[2].trim()));
		b.setPrice(Integer.parseInt(array[3].trim()));

		if (array.length > 4) {
			b.setRemark(array[4].trim());
		}

		return b;
	}

}
