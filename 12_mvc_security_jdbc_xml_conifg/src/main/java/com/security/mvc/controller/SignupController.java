package com.security.mvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.security.dto.SignupDto;
import com.security.root.services.SignUpService;

@Controller
public class SignupController {

	@Autowired
	private SignUpService service;

	@PostMapping("signup")
	public String index(@Valid @ModelAttribute SignupDto dto, BindingResult result) {

		if (result.hasErrors()) {
			return "signup";
		}

		var auth = service.signup(dto);
		SecurityContextHolder.getContext().setAuthentication(auth);

		return "redirect:/member";
	}
}
