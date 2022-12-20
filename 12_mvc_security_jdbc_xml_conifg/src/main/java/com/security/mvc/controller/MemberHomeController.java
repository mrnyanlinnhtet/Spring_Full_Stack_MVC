package com.security.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberHomeController {

	@GetMapping
	 public String index() {
		 return "member-home";
	 }
}
