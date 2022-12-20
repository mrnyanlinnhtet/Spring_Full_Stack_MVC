package com.ultron.mvc.inteceptor;

import java.util.concurrent.Callable;

import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.CallableProcessingInterceptor;

public class CallableResultInterceptor implements CallableProcessingInterceptor {

	 @Override
	public <T> void beforeConcurrentHandling(NativeWebRequest request, Callable<T> task) throws Exception {
		System.out.println("""
				===============> Before Callable Concurrent Processing Handling
				""");
	}
}
