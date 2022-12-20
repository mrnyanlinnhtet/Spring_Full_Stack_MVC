package com.ultron.model.dto;

import lombok.Data;

@Data
public class Course {

	private int id;
	private String name;
	private Level level;
	private Integer fees;
	private Integer duration;
	
	
    public Course() {
    	
    }


	public Course(String name, Level level, Integer fees, Integer duration) {
		super();
		this.name = name;
		this.level = level;
		this.fees = fees;
		this.duration = duration;
	}
    
    
}
