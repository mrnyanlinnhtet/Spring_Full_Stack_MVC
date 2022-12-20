package com.ultron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.ultron.model.StringCart;

@Controller
public class AddItemController {

	@PostMapping("/add-item")
	public String add(@RequestParam String data, @SessionAttribute StringCart cart) {
		cart.addToList(data);
		return "cart-view";
	}

}
