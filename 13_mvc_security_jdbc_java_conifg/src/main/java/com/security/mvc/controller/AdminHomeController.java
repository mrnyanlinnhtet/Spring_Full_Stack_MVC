package com.security.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.security.root.services.AccessInfoService;

@Controller
@RequestMapping("/admin")
public class AdminHomeController {
	

	@Autowired
	private AccessInfoService service;

	@GetMapping
	public String index(ModelMap model) {
		model.addAttribute("infoList", service.getAllInfo());
		return "admin-home";
	}
}
