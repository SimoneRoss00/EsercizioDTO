package it.objectmethod.ecommercedto.controller;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.ecommercedto.service.CartDetailService;
import it.objectmethod.ecommercedto.service.JWTService;
import it.objectmethod.ecommercedto.service.OrderRowService;
import it.objectmethod.ecommercedto.service.OrderService;
import it.objectmethod.ecommercedto.service.dto.CartDetailDTO;
import it.objectmethod.ecommercedto.service.dto.CompleteCartDTO;

@RestController
public class CartDetailController {

	Logger log = LoggerFactory.logger(CartDetailController.class);

	@Autowired
	private CartDetailService cartDetailService;

	@Autowired
	private OrderService serviceOrder;

	@Autowired
	private OrderRowService orderRowService;

	@Autowired
	private JWTService jwtService;

	@GetMapping("/addArticle-Cart/{idArticolo}")
	public void addArticleInCartDetail(@RequestHeader("auth-token") String token,
			@RequestParam("quantita") Integer quantity, @PathVariable("idArticolo") Long articleId) {
		log.info("ESECUZIONE FUNZIONE DI AGGIUNTA DI UN ARTICOLO AL CARRELLO");
		Long userId = jwtService.getUserIdByToken(token);
		cartDetailService.addArticleInCart(userId, quantity, articleId);
		log.info("FUNZIONE TERMINATA CON SUCCESSO");
	}

	@GetMapping("/showArticle-Cart")
	public CompleteCartDTO viewArticleInCart(@RequestHeader("auth-token") String token) {
		log.info("ESECUZIONE FUNZIONE DI VISUALIZZAZIONE ARTICOLI NEL CARRELLO");
		Long userId = jwtService.getUserIdByToken(token);
		CompleteCartDTO cartDTO = cartDetailService.showArticleCart(userId);
		log.info("FUNZIONE TERMINATA CON SUCCESSO ID UTENTE" + userId);
		return cartDTO;
	}

	@GetMapping("/deleteArticle/{cartDetailId}")
	public void deleteArticleInCartDetail(@PathVariable("cartDetailId") Long cartDetailId,
			@RequestHeader("auth-token") String token) {
		cartDetailService.deleteArticleInCart(cartDetailId);

	}

	@GetMapping("/deleteAllArticle")
	public void deleteAllArticle(@RequestHeader("auth-token") String token) {
		Long userId = jwtService.getUserIdByToken(token);
		cartDetailService.deleteAllArticleInCart(userId);
	}

	@GetMapping("/buyArticle/{cartDetailId}")
	public CartDetailDTO buyArticle(@PathVariable("cartDetailId") Long cartDetailId,
			@RequestHeader("auth-token") String token) {
		CartDetailDTO cart = cartDetailService.findArticleBounght(cartDetailId);
		return cart;
	}

	@GetMapping("/buyAllArticle")
	public CompleteCartDTO buyAllArticle(@RequestHeader("auth-token") String token) {
		Long userId = jwtService.getUserIdByToken(token);
		CompleteCartDTO cartDTO = cartDetailService.findAllArticleBounght(userId);
		serviceOrder.createOrder(userId);
		Long orderId = serviceOrder.getLastOrderId(userId);
		orderRowService.addOrderRowList(cartDTO.getCartDetailList(), orderId);
		return cartDTO;
	}
}
