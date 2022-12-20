package com.ultron.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.ultron.model.Counter;

@Configuration
@ComponentScan("com.ultron.model")
public class RootConfig {

	@Bean
	@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public Counter requestCounter() {
		return new Counter();
	}

	@Bean
	@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public Counter sessionCounter() {
		return new Counter();
	}

	@Bean
	@Scope(scopeName = "application", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public Counter applicationCounter() {
		return new Counter();
	}
}
