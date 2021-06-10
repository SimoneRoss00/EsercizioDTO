package it.objectmethod.ecommercedto.controller;

import java.util.List;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.ecommercedto.service.JWTService;
import it.objectmethod.ecommercedto.service.OrderRowService;
import it.objectmethod.ecommercedto.service.dto.ArticleDTO;
import it.objectmethod.ecommercedto.service.dto.OrderRowDTO;

@RestController
public class OrderRowController {

	Logger log = LoggerFactory.logger(OrderRowController.class);

	@Autowired
	private OrderRowService orderRowService;
	@Autowired
	private JWTService jwtService;

	@GetMapping("/viewArticleOrderRow")
	public List<OrderRowDTO> viewArticleOrderRowList(@RequestBody ArticleDTO articleDTO,
			@RequestHeader("auth-token") String token) {
		List<OrderRowDTO> orderRowDTOList = orderRowService.orederRowOfUser(articleDTO);
		return orderRowDTOList;

	}

	@GetMapping("/addOrderRow/{idOrder}/{idArticle}")
	public void insertOrderRow(@PathVariable("idOrder") Long orderId, @RequestParam("quantity") Integer quantityOrder,
			@PathVariable("idArticle") Long articleId, @RequestHeader("auth-token") String token) {
		orderRowService.addOrderRow(orderId, quantityOrder, articleId);
	}

	@GetMapping("/viewOrderRowUser")
	public List<OrderRowDTO> viewUserOrderList(@RequestHeader("auth-token") String token) {
		List<OrderRowDTO> orderRowDTOList = orderRowService.userOrderRow(jwtService.getUserIdByToken(token));
		return orderRowDTOList;

	}
}
