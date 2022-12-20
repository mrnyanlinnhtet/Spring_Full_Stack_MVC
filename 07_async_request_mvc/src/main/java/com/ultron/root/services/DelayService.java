package com.ultron.root.services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import com.ultron.mvc.tasks.DeferredTask;

@Service
public class DelayService {

	@Async("rootTaskExecutor")
	public void execute(DeferredTask result) {

		try {
			var mv = new ModelAndView("async-result");
			
			if (StringUtils.hasLength(result.getError())) {
				result.setErrorResult(new IllegalStateException(result.getError()));
				return;
			}
			
			
			Thread.sleep(1000L);
			
			mv.getModel().put("message", "Message From Deferred Result Service !");
			result.setResult(mv);

		} catch (InterruptedException e) {
			result.setErrorResult(e);
		}

	}

}
