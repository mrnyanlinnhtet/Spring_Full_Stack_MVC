package com.ultron.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ultron.model.HelloService;

@Controller
@RequestMapping("/hello")
public class HelloController {

	@Autowired
	private HelloService service;

	@GetMapping
	public String index(Model model) {
		System.out.println("Hello");
		model.addAttribute("message", service.getInfo());
		return "index";
	}

}
