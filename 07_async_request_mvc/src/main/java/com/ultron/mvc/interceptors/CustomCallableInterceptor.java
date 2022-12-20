package com.ultron.mvc.interceptors;

import java.util.concurrent.Callable;

import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.CallableProcessingInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ultron.mvc.tasks.CallableTasks;

public class CustomCallableInterceptor implements CallableProcessingInterceptor {
	

	@Override
	public <T> void beforeConcurrentHandling(NativeWebRequest request, Callable<T> task) throws Exception {
		System.out.println("=============================");
		System.out.println("=====Concurrent Handling=====");
		System.out.println("==============================");
		if (task instanceof CallableTasks custom) {
			custom.addMessage("Message From : Concurrent Handling");
		}

	}

	@Override
	public <T> void preProcess(NativeWebRequest request, Callable<T> task) throws Exception {
		System.out.println("=============================");
		System.out.println("=====Pre Process=====");
		System.out.println("==============================");
		
		if (task instanceof CallableTasks custom) {
			custom.addMessage("Message From : Pre Process ");
			custom.setError(request.getParameter("error"));
		}
	}

	@Override
	public <T> void postProcess(NativeWebRequest request, Callable<T> task, Object concurrentResult) throws Exception {
		System.out.println("=============================");
		System.out.println("=====Post Process=====");
		System.out.println("==============================");
		
		if (task instanceof CallableTasks custom) {
			custom.addMessage("Message From : Post Process ");
		}
	}

	@Override
	public <T> Object handleError(NativeWebRequest request, Callable<T> task, Throwable t) throws Exception {
		System.out.println("=============================");
		System.out.println("=====Handle Error=====");
		System.out.println("==============================");
		return RESULT_NONE;
	}

	@Override
	public <T> Object handleTimeout(NativeWebRequest request, Callable<T> task) throws Exception {
		System.out.println("=============================");
		System.out.println("=====Handle Timeout=====");
		System.out.println("==============================");
		
		var mv = new ModelAndView("async-result");
		mv.getModel().put("message", "Timeout in Callable Processing !");
		
		 if(task instanceof CallableTasks custom) {
			 mv.getModel().put("interceptorMessage",custom.getMessage());
		 }
		
		return mv;
	}

	@Override
	public <T> void afterCompletion(NativeWebRequest request, Callable<T> task) throws Exception {
		System.out.println("=============================");
		System.out.println("=====After Completion=====");
		System.out.println("==============================");
		
		if (task instanceof CallableTasks custom) {
			custom.addMessage("Message From : After Completion ");
		}
	}

}
