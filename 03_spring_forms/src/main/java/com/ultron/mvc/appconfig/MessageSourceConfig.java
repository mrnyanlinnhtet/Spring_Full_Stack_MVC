package com.ultron.mvc.appconfig;



import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class MessageSourceConfig {

	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		var messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:message");
		messageSource.setDefaultEncoding("UTF-8");

		return messageSource;
	}
	
	@Bean
	@Qualifier("localValidator")
	public LocalValidatorFactoryBean localValidator() {
		var factoryValidator = new LocalValidatorFactoryBean();
		factoryValidator.setValidationMessageSource(messageSource());
		return  factoryValidator;
	}
	
	

}
