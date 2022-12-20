package com.security.root.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.security.dto.AccessInfo.Type;
import com.security.root.services.AccessInfoService;

@Component
public class LoginSuccessListener implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {

	@Autowired
	 private AccessInfoService infoService;
	
	@Override
	public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event) {
		
		 if(event.getAuthentication().getPrincipal() instanceof User user) {
			 infoService.create(user.getUsername(),Type.LOGIN);
		 }
		
	}

}
