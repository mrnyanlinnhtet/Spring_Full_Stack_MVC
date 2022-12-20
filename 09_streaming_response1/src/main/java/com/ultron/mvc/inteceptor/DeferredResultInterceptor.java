package com.ultron.mvc.inteceptor;

import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.DeferredResultProcessingInterceptor;

public class DeferredResultInterceptor implements DeferredResultProcessingInterceptor {
	
	@Override
	public <T> void beforeConcurrentHandling(NativeWebRequest request, DeferredResult<T> deferredResult)
			throws Exception {
		System.out.println("""
				========================> Before Deferred Concurrent Handling 
				""");
	}
	
	@Override
	public <T> boolean handleTimeout(NativeWebRequest request, DeferredResult<T> deferredResult) throws Exception {
	
		System.out.println("""
			===========================> Handle Time Out in Deferred Result
				""");
		return true;
	}

}
