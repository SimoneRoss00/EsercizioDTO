package it.objectmethod.ecommercedto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.ecommercedto.service.OrderRowService;
import it.objectmethod.ecommercedto.service.dto.ArticleDTO;
import it.objectmethod.ecommercedto.service.dto.OrderRowDTO;

@RestController
public class OrderRowController {

	@Autowired
	private OrderRowService orderRowService;

	@GetMapping("/viewArticleOrderRow")
	public List<OrderRowDTO> viewArticleOrderRowList(@RequestBody ArticleDTO articleDTO) {
		List<OrderRowDTO> orderRowDTOList = orderRowService.orederRowOfUser(articleDTO);
		return orderRowDTOList;

	}

	@GetMapping("/addOrderRow/{idOrder}/{idArticle}")
	public void insertOrderRow(@PathVariable("idOrder") Integer orderId,
			@RequestParam("quantity") Integer quantityOrder, @PathVariable("idArticle") Integer articleId) {
		orderRowService.addOrderRow(orderId, quantityOrder, articleId);
	}
}
