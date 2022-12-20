package com.ultron.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ultron.dto.Course;
import com.ultron.dto.UserInput;
import com.ultron.dto.UserInput.Gender;
import com.ultron.mvc.validator.UserInputValidator;
import com.ultron.root.services.CourseService;
import com.ultron.root.services.UserService;

@Controller
@RequestMapping("/form")
public class FormController {

	@Autowired
	private UserService service;
	@Autowired
	private CourseService courseService;

	@Autowired
	private UserInputValidator validator;
//	@Autowired
//	private CourseConverter convertor;

	@InitBinder
	public void webInitBinder(WebDataBinder binder) {
//		if (binder.getConversionService() instanceof ConfigurableConversionService registry) {
//			registry.addConverter(convertor);
//		}

		binder.addValidators(validator);
	}

	@GetMapping
	public String index(ModelMap model) {
		model.put("list", service.getAllUser());
		return "index";
	}

	@PostMapping
	public String createUser(@Validated @ModelAttribute("userInput") UserInput data, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			model.put("hasErrors", true);
			return "index";
		}

		service.createUser(data);
		return "redirect:/form";
	}

	@ModelAttribute("courses") // For Selection Box
	List<Course> getCourses() {
		return courseService.getAllData();
	}

	@ModelAttribute("userInput")
	public UserInput userInput() {
		return new UserInput();
	}

	@ModelAttribute("genders")
	Gender[] gender() {
		return Gender.values();
	}

	@ModelAttribute("foundations")
	List<String> foundations() {
		return List.of("HTML", "CSS", "JavaScript", "Database");
	}
}
