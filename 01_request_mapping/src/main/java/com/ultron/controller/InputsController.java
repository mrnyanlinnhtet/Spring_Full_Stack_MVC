package com.ultron.controller;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ultron.model.dto.Level;

@Controller
@RequestMapping("/inputs")
public class InputsController {

	@GetMapping
	public void index() {

	}

	@GetMapping("{type}/search/{id:\\d+}")
	public String findByType(@PathVariable String type, @PathVariable int id, Model model) {
		model.addAttribute("type", type);
		model.addAttribute("id", id);
		return "inputs";
	}

	@GetMapping("/{date:\\d{4}\\-\\d{2}\\-\\d{2}}")
	public String dateParameter(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, Model model) {
		model.addAttribute("date", date);
		return "inputs";
	}

	@GetMapping("/{level:Basic|Intermediate|Advence}")
	public String enumParameter(@PathVariable Level level, Model model) {
		model.addAttribute("date", level);
		return "inputs";
	}
	
	@GetMapping("/matrix/{products}")
	public String useMatrixParameter(
			@PathVariable String products,
		    @MatrixVariable(name = "s",pathVar = "products") String size,
		    @MatrixVariable(value = "c",required = false,defaultValue = "1") int count,
		    Model model
			) {
		
		 var message = "Products:%s , Size:%s , Count:%d".formatted(products,size,count);
		 model.addAttribute("date", message);
		
		return "inputs";
	}
	
	@GetMapping("/requestParam")
	public String useRequestParameter(
		@RequestParam(name = "p")String product,
		@RequestParam(name = "c")String carModel,
		@RequestParam(name="m",required = false,defaultValue = "2022")int madeYear,
			Model model
			) {
		
		 String date = "Product : %s , Car Model : %s , Made Year : %d".formatted(product,carModel,madeYear);
		 model.addAttribute("date", date);
		
		return "inputs";
	}

}
