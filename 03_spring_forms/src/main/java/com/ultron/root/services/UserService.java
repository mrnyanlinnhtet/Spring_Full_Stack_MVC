package com.ultron.root.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import com.ultron.dto.UserInput;

@Service
@ApplicationScope
public class UserService {

	private List<UserInput> list;

	public UserService() {
		list = new ArrayList<UserInput>();
	}

	public List<UserInput> getAllUser() {
		return new ArrayList<>(list);
	}

	public void createUser(UserInput data) {
		list.add(data);
	}
}
