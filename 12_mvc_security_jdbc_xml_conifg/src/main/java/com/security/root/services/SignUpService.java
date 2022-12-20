package com.security.root.services;

import org.springframework.security.core.Authentication;

import com.security.dto.SignupDto;


public interface SignUpService {
	
 //Jdbc Insert
 public Authentication signup(SignupDto dto) ;
		
	

}
