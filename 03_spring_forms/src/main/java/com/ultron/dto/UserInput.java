package com.ultron.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class UserInput {

	
	private int id;
	
	private String name;
	@NotBlank(message = "Please Enter Phone !")
	@Pattern(regexp = "09(-\\d{4}){2}" ,message = "Invalid Phone Number !")
	private String phone;
	@NotBlank(message = "{empty.email}")
	private String email;
	@NotBlank(message = "Please Enter Password !")
	private String password;
	@NotNull(message = "Please Select Course !")
	private Course course;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate registrationDate;
	private Gender genders;
	private List<String> foundations;
	private boolean agree;
	private String remark;

	public enum Gender {
		Male, Female
	}

}
