package com.security.dto;

import javax.validation.constraints.NotBlank;

public class SignupDto {

	@NotBlank(message = "Username must not be empty !")
	private String name;
	@NotBlank(message = "Login Id must not be empty !")
	private String loginId;
	@NotBlank(message = "Password must not be empty !")
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
