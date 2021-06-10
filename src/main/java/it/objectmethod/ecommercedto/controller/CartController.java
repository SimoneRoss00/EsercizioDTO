package it.objectmethod.ecommercedto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.ecommercedto.service.CartService;
import it.objectmethod.ecommercedto.service.JWTService;
import it.objectmethod.ecommercedto.service.dto.CompleteCartDTO;

@RestController
public class CartController {

	@Autowired
	private CartService cartService;
	@Autowired
	private JWTService jwtService;

	@GetMapping("/showCart")
	public CompleteCartDTO viewCartByUserId(@RequestHeader("auth-token") String token) {
		Long userId = jwtService.getUserIdByToken(token);
		CompleteCartDTO cartDTO = cartService.showCartByUserId(userId);
		return cartDTO;
	}

}
