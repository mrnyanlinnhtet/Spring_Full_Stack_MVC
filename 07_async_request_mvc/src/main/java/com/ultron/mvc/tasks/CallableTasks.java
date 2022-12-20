package com.ultron.mvc.tasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

import org.springframework.web.servlet.ModelAndView;

public class CallableTasks implements Callable<ModelAndView> {

	private List<String> dataMessage;
	private String error;

	public void setError(String error) {
		this.error = error;
	}

	public CallableTasks() {
		dataMessage = Collections.synchronizedList(new ArrayList<String>());
	}

	public void addMessage(String message) {
		System.out.println(message);
		this.dataMessage.add(message);
	}

	public List<String> getMessage() {
		return this.dataMessage;
	}

	@Override
	public ModelAndView call() throws Exception {
		var mv = new ModelAndView();
		Thread.sleep(1500L);
		if(null != error) {
			throw new IllegalStateException(error);
		}
		mv.setViewName("async-result");
		mv.getModel().put("message", "Callable Test Processing is Sucessful !");
		mv.getModel().put("interceptorMessage", dataMessage);
		return mv;
	}

}
