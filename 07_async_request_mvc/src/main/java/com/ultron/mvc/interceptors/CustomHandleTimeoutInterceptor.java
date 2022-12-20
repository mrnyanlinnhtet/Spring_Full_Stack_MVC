package com.ultron.mvc.interceptors;

import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.DeferredResultProcessingInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class CustomHandleTimeoutInterceptor implements DeferredResultProcessingInterceptor {

	@Override
	public <T> boolean handleTimeout(NativeWebRequest request, DeferredResult<T> deferredResult) throws Exception {

		System.out.println("""
				==========> Timeout : CustomHandleTimeoutInterceptor
				""");

		var mv = new ModelAndView("error-result");
		mv.getModel().put("message", "Handle Error From Custom Handle Timeout Interceptor");
		deferredResult.setErrorResult(mv);
		return false;

	}
}
