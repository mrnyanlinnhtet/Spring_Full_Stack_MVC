package com.ultron.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
@ComponentScan("com.ultron.root")
public class RootConfig {
	
	

	@Bean
	public AsyncTaskExecutor executor() {
		var exe = new ThreadPoolTaskExecutor();
		exe.setCorePoolSize(25);
		return exe;
	}

}
