package it.objectmethod.ecommercedto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.ecommercedto.service.CartDetailService;
import it.objectmethod.ecommercedto.service.dto.CartDTO;
import it.objectmethod.ecommercedto.service.dto.CartDetailDTO;

@RestController
public class CartDetailController {

	@Autowired
	private CartDetailService cartDetailService;

	@GetMapping("/addArticle-Cart/{idUser}/{idArticolo}")
	public void addArticleInCartDetail(@PathVariable("idUser") Integer idUser,
			@RequestParam("quantita") Integer quantity, @PathVariable("idArticolo") Integer articleId) {
		cartDetailService.addArticleInCart(idUser, quantity, articleId);

	}

	@GetMapping("/showArticle-Cart")
	public List<CartDetailDTO> viewArticleInCart(@RequestBody CartDTO cartDTO) {
		List<CartDetailDTO> cartDetailDTO = cartDetailService.showArticleCart(cartDTO);
		return cartDetailDTO;
	}

	@GetMapping("/deleteArticle/{cartDetailId}")
	public void deleteArticleInCartDetail(@PathVariable("cartDetailId") Integer cartDetailId) {
		cartDetailService.deleteArticleInCart(cartDetailId);

	}

	@GetMapping("/buyArticle/{cartDetailId}")
	public CartDetailDTO buyArticle(@PathVariable("cartDetailId") Integer cartDetailId) {
		CartDetailDTO cart = cartDetailService.findArticleBounght(cartDetailId);
		return cart;
	}
}
