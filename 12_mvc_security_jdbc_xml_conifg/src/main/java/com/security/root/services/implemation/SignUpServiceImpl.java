package com.security.root.services.implemation;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.dto.SignupDto;
import com.security.root.services.SignUpService;

@Service
public class SignUpServiceImpl implements SignUpService {

	@Autowired
	private SimpleJdbcInsert insert;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	@Autowired
	@Qualifier("authManager")
	private AuthenticationManager authManager;

	@Override
	public Authentication signup(SignupDto dto) {
		// jdbc insert
		var params = new HashMap<String, Object>();
		params.put("name", dto.getName());
		params.put("login", dto.getLoginId());
		params.put("password", bcryptEncoder.encode(dto.getPassword()));
		var count = insert.execute(params);

		// Programmatic Login
		if (count == 1) {
			var token = new UsernamePasswordAuthenticationToken(dto.getLoginId(), dto.getPassword());
			return authManager.authenticate(token);
		}

		return null;
	}

}
