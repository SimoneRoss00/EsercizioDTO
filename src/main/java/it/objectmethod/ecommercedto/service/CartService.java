package it.objectmethod.ecommercedto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.objectmethod.ecommercedto.entity.Cart;
import it.objectmethod.ecommercedto.repository.CartRepository;
import it.objectmethod.ecommercedto.service.dto.CartDTO;
import it.objectmethod.ecommercedto.service.mapper.CartMapper;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepo;
	@Autowired
	private CartMapper cartMapper;

	public CartDTO showCartByUserId(Integer userId) {
		Cart cart = cartRepo.findByuserId(userId);
		CartDTO cartDTO = cartMapper.toDto(cart);
		return cartDTO;
	}
}
