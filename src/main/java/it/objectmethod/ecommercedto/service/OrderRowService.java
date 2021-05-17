package it.objectmethod.ecommercedto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.objectmethod.ecommercedto.entity.Article;
import it.objectmethod.ecommercedto.entity.Order;
import it.objectmethod.ecommercedto.entity.OrderRow;
import it.objectmethod.ecommercedto.repository.ArticleRepository;
import it.objectmethod.ecommercedto.repository.OrderRepository;
import it.objectmethod.ecommercedto.repository.OrderRowRepository;
import it.objectmethod.ecommercedto.service.dto.ArticleDTO;
import it.objectmethod.ecommercedto.service.dto.OrderRowDTO;
import it.objectmethod.ecommercedto.service.mapper.OrderRowMapper;

@Service
public class OrderRowService {

	@Autowired
	private OrderRowRepository orderRowRepo;
	@Autowired
	private ArticleRepository articleRepo;
	@Autowired
	private OrderRepository orderRepo;
	@Autowired
	private OrderRowMapper orderRowMapper;

	public List<OrderRowDTO> orederRowOfUser(ArticleDTO articeDTO) {
		Integer articleId = articeDTO.getArticleId();
		List<OrderRow> orderRowList = orderRowRepo.findByArticleIdArticle(articleId);
		List<OrderRowDTO> orderRowDTOList = orderRowMapper.toDto(orderRowList);
		return orderRowDTOList;
	}

	public void addOrderRow(Integer orderId, Integer quantityOrder, Integer articleId) {
		OrderRow orderRow = new OrderRow();
		orderRow.setQuantityOrder(quantityOrder);
		Article article = articleRepo.findByIdArticle(articleId);
		orderRow.setArticle(article);
		Order order = orderRepo.findByOrderId(orderId);
		orderRow.setOrder(order);
		orderRowRepo.save(orderRow);

	}
}
