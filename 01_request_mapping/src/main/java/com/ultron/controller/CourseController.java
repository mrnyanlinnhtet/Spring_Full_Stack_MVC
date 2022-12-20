package com.ultron.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ultron.model.dto.Course;
import com.ultron.model.dto.Level;
import com.ultron.model.dto.Result;
import com.ultron.model.dto.Result.Status;
import com.ultron.model.service.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {

	@Autowired
	CourseService service;

//	@GetMapping
//	public ModelAndView index(){
//		var mv = new ModelAndView();
//		mv.getModel().put("list", service.getAllCourse());
//		mv.setViewName("course-list");
//		return mv;
//	}
	
	

	@GetMapping
	public String index(Model model) {
		model.addAttribute("list", service.getAllCourse());
		return "course-list";
	}

	@GetMapping("/add")
	public String add() {
		return "course-edit";
	}
	
	@GetMapping("/edit")
	public String edit() {
		return "course-edit";
	}

	@PostMapping
	public String save(@ModelAttribute Course course, RedirectAttributes redirect) {
		
		int id = service.save(course);
		if(course.getId() != id) {
			redirect.addFlashAttribute("result", new Result(Status.SUCCESS, "New Course had been Created !"));
		}else {
			redirect.addFlashAttribute("result", new Result(Status.SUCCESS, "Course had been Edited !"));
		}
		
		return "redirect:/course/%d".formatted(id);
	}

	@GetMapping("{id:\\d+}")
	public String findById(@PathVariable int id, Model model) {
		model.addAttribute("course", service.findById(id));
		return "course-detail";
	}

//	@ModelAttribute
//	public void loadLevels(ModelMap model) {
//		model.put("levels", Level.values());
//	}
	
	@ModelAttribute("levels")
	public Level[] loadLevels() {
		return Level.values();
	}
	
	@ModelAttribute
	public void loadCourse(@RequestParam(required = false) Integer id , ModelMap model) {
		 if(null != id) {
			 model.put("course", service.findById(id));
		 }
	}
	
	
}
