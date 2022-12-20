package com.security.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.security.dto.SignupDto;
import com.security.root.services.SignUpService;

@Controller
public class SignupController {

	@Autowired
	private SignUpService service;
	
	@GetMapping("signup")
	public String index() {
		return "signup";
	}

	@PostMapping("signup")
	public String index(@Validated @ModelAttribute("dto") SignupDto dto, BindingResult result) {

		if (result.hasErrors()) {
			//result.getAllErrors().forEach(System.out::println);
			return "signup";
		}

		var auth = service.signup(dto);
		
		SecurityContextHolder.getContext().setAuthentication(auth);

		return "redirect:/member";
	}
	
	@ModelAttribute("dto")
	public SignupDto dto() {
		return new SignupDto();
	}
}
