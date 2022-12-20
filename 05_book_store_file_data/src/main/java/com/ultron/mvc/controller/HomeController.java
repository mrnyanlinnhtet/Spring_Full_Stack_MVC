package com.ultron.mvc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ultron.dto.Book;
import com.ultron.root.services.BookService;

@Controller
@RequestMapping({ "/home", "/books" })
public class HomeController {
	@Autowired
	private BookService bookService;

	@GetMapping
	public String home(@RequestParam(required = false) Integer category, @RequestParam(required = false) String keyword,
			ModelMap model) {
		// Search Book With Request Parameter
		List<Book> list = bookService.search(category, keyword);
		// Add Search Result to Model
		model.put("list", list);

		return "home";
	}

	@GetMapping("edit")
	public String edit() {
		return "book-edit";
	}
	
	@GetMapping("details")
	public String details() {
		return "book-details";
	}
	
	@PostMapping
	public String save(@Validated @ModelAttribute Book book, BindingResult result,RedirectAttributes redirect) {
		
		   if(result.hasErrors()) {
			   System.out.println("Hello I am Error >>>>>>>>>>>>>>>>>>>>>>>>>>>");
			   return "book-edit";
		   }
		   
		   var id = bookService.save(book);
		   redirect.addAttribute("id", id);
		return "redirect:/books/details";
	}
	
	@ModelAttribute("book")
	public Book book(@RequestParam Optional<Integer>id) {
		return id.flatMap(a->bookService.findById(a)).orElse(new Book());
	}

}
