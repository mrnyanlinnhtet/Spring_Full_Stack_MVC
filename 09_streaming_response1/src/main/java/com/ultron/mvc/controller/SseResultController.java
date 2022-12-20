package com.ultron.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.ultron.root.services.DataProvider;

@Controller
@RequestMapping("sse")
public class SseResultController {

	@Autowired
	private DataProvider service;

	@GetMapping
	public SseEmitter sseResult() {
		var emitter = new SseEmitter(3000L);
		service.stream(emitter);
		return emitter;

	}

}
