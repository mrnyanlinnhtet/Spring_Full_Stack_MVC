package com.ultron.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import com.ultron.root.services.DataProvider;

@Controller
@RequestMapping("stream")
public class StreamController {

	@Autowired
	private DataProvider provider;

	@GetMapping
	public ResponseBodyEmitter index() {
		var emitter = new ResponseBodyEmitter(3000L);
		provider.stream(emitter);

		return emitter;
	}

}
