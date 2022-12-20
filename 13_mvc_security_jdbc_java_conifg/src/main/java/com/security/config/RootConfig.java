package com.security.config;

import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutFilter;

import com.security.root.custom_filter.CustomSecurityFilter;

@SuppressWarnings("deprecation")
@Configuration
@ComponentScan(basePackages = "com.security.root")
@EnableWebSecurity
public class RootConfig extends WebSecurityConfigurerAdapter {
	 
	@Autowired
	 private CustomSecurityFilter customFilter;
	
	@Bean
	public DataSource dataSource() {
		var ds = new BasicDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/auth_jdc_db");
		ds.setUsername("root");
		ds.setPassword("admin");
		return ds;
	}
	
	@Bean
	@Qualifier("user")
	public SimpleJdbcInsert insert(DataSource dataSource) {
		var insert = new SimpleJdbcInsert(dataSource);
		insert.setTableName("users");
		insert.setColumnNames(List.of("name","login","password"));
		return insert;
	}
	
	@Bean
	@Qualifier("access")
	public SimpleJdbcInsert insertAccessInfo(DataSource dataSource) {
		var insert = new SimpleJdbcInsert(dataSource);
		insert.setTableName("access_info");
		insert.setColumnNames(List.of("login_id","type"));
		return insert;
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	
	 @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		    .withUser(User.builder().username("admin").authorities("Admin").password(encoder().encode("admin")));
		
		auth.jdbcAuthentication()
		    .dataSource(dataSource())
		    .passwordEncoder(encoder())
		    .usersByUsernameQuery("SELECT login,password,valid FROM users WHERE login = ?")
		    .authoritiesByUsernameQuery("SELECT login,role FROM users WHERE login = ?");
	}
	 
	 @Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.csrf().disable();
		 
		 http.authorizeRequests().antMatchers("/admin/**").hasAuthority("Admin");
		 http.authorizeRequests().antMatchers("/member/**").hasAnyAuthority("Member","Admin");
		 
		 http.formLogin()
		     .loginPage("/signin")
		     .loginProcessingUrl("/signin")
		     .usernameParameter("loginId")
		     .passwordParameter("password");
		 
		 http.logout()
		     .invalidateHttpSession(true)
		     .logoutUrl("/signout")
		     .logoutSuccessUrl("/");
		 
		 http.addFilterAfter(customFilter,LogoutFilter.class);
	}
	 
	 @Bean
	 @Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	
}
