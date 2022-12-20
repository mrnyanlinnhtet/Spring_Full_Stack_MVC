package com.ultron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/multi")
public class MultiActionController {

	@RequestMapping
	public void index() {

	}

	@GetMapping("/action1")
	public String action1(Model model) {
		model.addAttribute("message", "Message From Action 1 Path !");
		return "multi";
	}
	
	@GetMapping(value = "/action1",params = "id")
	public String action1WithParam(Model model) {
		model.addAttribute("message","Message From Action 1 With Param !");
		return "multi";
	}
	
	@RequestMapping("/action2")
	public String action2(Model model) {
		model.addAttribute("message","Message From Action 2 Path !");
		return "multi";
	}
	
	@RequestMapping("**")
	public String other(Model model) {
		model.addAttribute("message","Messsage From Other Path !");
		return "multi";
	}
	

    @RequestMapping("{:\\d+}")	
	public String digit(Model model) {
	   model.addAttribute("message","Message From Digit !");	
		return "multi";
	}

}
