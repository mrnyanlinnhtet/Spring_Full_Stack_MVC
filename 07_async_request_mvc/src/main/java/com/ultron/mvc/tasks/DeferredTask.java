package com.ultron.mvc.tasks;

import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.ModelAndView;

public class DeferredTask extends DeferredResult<ModelAndView> {
	
	private String error;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public DeferredTask(long timeOut) {
		super(timeOut);
	}
	
	
	

}
