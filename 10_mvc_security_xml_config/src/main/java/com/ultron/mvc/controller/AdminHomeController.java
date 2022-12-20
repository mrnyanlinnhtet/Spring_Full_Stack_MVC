package com.ultron.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminHomeController {

	@GetMapping
	 public String index(ModelMap model) {
		model.put("title", "Admin Home");
		model.put("message", "Message From Admin Controller !");
		 return "home";
	 }
}
