package com.ultron.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		  auth.inMemoryAuthentication()
		      .withUser(User.builder().username("admin").authorities("ROLE_ADMIN").password("{noop}admin"))
		      .withUser(User.builder().username("member").authorities("ROLE_MEMBER").password("{noop}member"));
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 
		http.csrf().disable();
		
		http.authorizeRequests()
		    .antMatchers("/admin/**").hasRole("ADMIN")
		    .antMatchers("/member/**").hasAnyRole("ADMIN","MEMBER");
		
		http.formLogin()
		    .loginPage("/views/login.jsp")
		    .loginProcessingUrl("/login")
		    .usernameParameter("userId")
		    .passwordParameter("password");
		
		
	   http.logout()
	       .logoutUrl("/logout")
	       .logoutSuccessUrl("/")
	       .invalidateHttpSession(true);
	   
	   http.exceptionHandling()
	       .accessDeniedPage("/forbidden");
		
		
	}

}
