package com.ultron.controller;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.ultron.model.Counter;

@Controller
public class HomeController {

	@Autowired
	private Counter requestCounter;

	@Autowired
	private Counter sessionCounter;

	@Autowired
	private Counter applicationCounter;

	@Autowired
	private ServletContext context;

	@PostConstruct
	public void init() {
		context.setAttribute("counter", new Counter());
	}

	@GetMapping("/")
	public String index(ModelMap model, @RequestAttribute("counter") Counter request,
			@SessionAttribute("counter") Counter session) {

		model.put("request", requestCounter.countUp());
		model.put("session", sessionCounter.countUp());
		model.put("application", applicationCounter.countUp());

//		request.setAttribute("counter", requestCounter);
//		session.setAttribute("counter", sessionCounter);
//		request.getServletContext().setAttribute("counter", applicationCounter);

		var appCounter = (Counter) context.getAttribute("counter");

		appCounter.countUp();
		request.countUp();
		session.countUp();

		return "home";
	}

	@ModelAttribute
	public void loadRequestAndSession(HttpServletRequest request) {
		request.setAttribute("counter", new Counter());

		var session = request.getSession();

		if (session.getAttribute("counter") == null) {
			session.setAttribute("counter", new Counter());
		}
	}

}
