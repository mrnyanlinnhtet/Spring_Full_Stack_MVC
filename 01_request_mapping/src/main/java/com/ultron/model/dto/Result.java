package com.ultron.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

	private Status status;
	private String message;

	public enum Status {
		SUCCESS, WARNING, ERROR
	}
	
	
}
