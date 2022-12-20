package com.security.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.security.root.services.AccessInfoService;

@Controller
@RequestMapping("/member")
public class MemberHomeController {
	
	@Autowired
	private AccessInfoService service;

	@GetMapping
	 public String index(ModelMap model) {
		
		if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User user)
		 model.addAttribute("infoList",service.getInfo(user.getUsername()));
		 return "member-home";
	 }
}
