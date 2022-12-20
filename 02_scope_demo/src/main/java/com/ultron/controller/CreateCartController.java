package com.ultron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ultron.model.StringCart;

@Controller
@SessionAttributes("cart")
public class CreateCartController {

	@GetMapping("/create-session")
	public String index() {
		return "cart-view";
	}

	

	@ModelAttribute("cart")
	StringCart loadCart() {
		return new StringCart();
	}

}
