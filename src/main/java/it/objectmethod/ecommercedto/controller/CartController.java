package it.objectmethod.ecommercedto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.ecommercedto.service.CartService;
import it.objectmethod.ecommercedto.service.dto.CartDTO;

@RestController
public class CartController {

	@Autowired
	private CartService cartService;

	@GetMapping("/showCart/{userId}")
	public CartDTO viewCartByUserId(@PathVariable("userId") Integer userId) {
		CartDTO cartDTO = cartService.showCartByUserId(userId);
		return cartDTO;
	}

}
