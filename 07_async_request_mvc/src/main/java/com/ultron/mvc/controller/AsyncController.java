package com.ultron.mvc.controller;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.ModelAndView;

import com.ultron.mvc.tasks.CallableTasks;
import com.ultron.mvc.tasks.DeferredTask;
import com.ultron.root.services.DelayService;

@Controller
@RequestMapping("async")
public class AsyncController {

	@Autowired
	private DelayService service;

	@GetMapping("callable")
	public Callable<ModelAndView> callableExecution(ModelMap model) {
		model.addAttribute("message", "Message from callable Execution");
		return new CallableTasks();
	}

	@GetMapping("deferred")
	public DeferredResult<ModelAndView> deferredExecution() {
		var result = new DeferredTask(3000L);

//		result.onTimeout(() -> {
//			var mv = new ModelAndView("error-result");
//			mv.getModel().put("message", "Deferred Result Execution is Timeout");
//			result.setErrorResult(mv);
//		});

		result.onCompletion(() -> {
			System.out.println("Result has been completed !");
		});

		result.onError(e -> {
			e.printStackTrace();
		});

		result.setResultHandler(value -> {
			System.out.println("Result is %s".formatted(value));
		});

		service.execute(result);

		return result;
	}

	// for callable result
	@ExceptionHandler({
		RuntimeException.class,IllegalStateException.class
	})
	ModelAndView handlingExection(Exception e) {
		var mv = new ModelAndView("error-result");
		mv.getModel().put("message", e.getMessage());

		return mv;
	}
}
