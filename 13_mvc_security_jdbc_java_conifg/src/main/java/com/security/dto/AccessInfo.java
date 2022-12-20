package com.security.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class AccessInfo {

	private int id;
	private String userName;
	private String loginId;
	private LocalDateTime accessTime;
	private Type type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public LocalDateTime getAccessTime() {
		return accessTime;
	}

	public void setAccessTime(LocalDateTime accessTime) {
		this.accessTime = accessTime;
	}
	
	public void setAccessTimeStamp(Timestamp accessTime) {
		
		if(null != accessTime) {
			this.accessTime = accessTime.toLocalDateTime();
		}
		
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	//Enum Type
	public enum Type {
		LOGIN, LOGOUT
	}

}
