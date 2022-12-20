package com.ultron.mvc.controller.advices;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.ultron.root.utils.FileUploadAppException;

@ControllerAdvice
public class ExceptionHandlerAdvice {

	@ExceptionHandler
	ModelAndView exceptionHandler(FileUploadAppException e) {
		var modelAndView = new ModelAndView("home");
		modelAndView.getModel().put("uploadMessage", "Fails File Upload : %s".formatted(e.getMessage()));
		return modelAndView;
	}
}
