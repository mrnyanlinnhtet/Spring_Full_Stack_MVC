package com.ultron.model;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

	 public String getInfo() {
		 return "Message From Root Application Context";
	 }
}
