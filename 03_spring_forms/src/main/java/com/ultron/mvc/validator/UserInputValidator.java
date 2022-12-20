package com.ultron.mvc.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ultron.dto.UserInput;

@Component
public class UserInputValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserInput.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		 if(target instanceof UserInput input) {
			 
			 if(!StringUtils.hasLength(input.getName())) {
				 errors.rejectValue("name", "empty", "Enter Uername !");
			 }
//			 
//			 if(null == input.getCourse()) {
//				errors.rejectValue("course", "not_select", "Please Select Course !");
//			 }
//			 
//			 if(!StringUtils.hasLength(input.getEmail())) {
//				 errors.rejectValue("email", "empty", "Enter Email !");
//			 }
//			 
//			 if(!StringUtils.hasLength(input.getPhone())) {
//				 errors.rejectValue("phone", "empty", "Enter Phone Number !");
//			 }
//			 
//			 if(!StringUtils.hasLength(input.getPassword())) {
//				 errors.rejectValue("password", "empty", "Enter Password !");
//				 
//			 }
		 }
		 
		 

	}

}
