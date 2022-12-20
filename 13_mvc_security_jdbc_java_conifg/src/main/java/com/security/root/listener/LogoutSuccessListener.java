package com.security.root.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.LogoutSuccessEvent;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.security.dto.AccessInfo.Type;
import com.security.root.services.AccessInfoService;

@Component
public class LogoutSuccessListener implements ApplicationListener<LogoutSuccessEvent> {

	@Autowired
	private AccessInfoService infoService;
	
	@Override
	public void onApplicationEvent(LogoutSuccessEvent event) {
		if( event.getAuthentication().getPrincipal() instanceof User user) {
			infoService.create(user.getUsername(),Type.LOGOUT);
		}
		
	}

}
