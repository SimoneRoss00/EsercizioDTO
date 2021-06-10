package it.objectmethod.ecommercedto.service;

import java.util.List;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.objectmethod.ecommercedto.entity.Article;
import it.objectmethod.ecommercedto.entity.CartDetail;
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

	Logger log = LoggerFactory.logger(OrderRowService.class);

	@Autowired
	private OrderRowRepository orderRowRepo;
	@Autowired
	private ArticleRepository articleRepo;
	@Autowired
	private OrderRepository orderRepo;
	@Autowired
	private OrderRowMapper orderRowMapper;

	public List<OrderRowDTO> orederRowOfUser(ArticleDTO articeDTO) {
		Long articleId = articeDTO.getArticleId();
		List<OrderRow> orderRowList = orderRowRepo.findByArticleIdArticle(articleId);
		List<OrderRowDTO> orderRowDTOList = orderRowMapper.toDto(orderRowList);
		return orderRowDTOList;
	}

	public void addOrderRowList(List<CartDetail> completecartDTOList, Long orderId) {
		for (CartDetail cart : completecartDTOList) {
			OrderRow orderRow = new OrderRow();
			orderRow.setQuantityOrder(cart.getCartQuantity());
			Article article = articleRepo.findByIdArticle(cart.getArticle().getIdArticle());
			orderRow.setArticle(article);
			Order order = orderRepo.findByOrderId(orderId);
			orderRow.setOrder(order);
			orderRowRepo.save(orderRow);
			log.info("ORDINE INSERITO");
		}

	}

	public void addOrderRow(Long orderId, Integer quantity, Long idArticle) {
		OrderRow orderRow = new OrderRow();
		orderRow.setQuantityOrder(quantity);
		Article article = articleRepo.findByIdArticle(idArticle);
		orderRow.setArticle(article);
		Order order = orderRepo.findByOrderId(orderId);
		orderRow.setOrder(order);
		orderRowRepo.save(orderRow);
		log.info("ORDINE INSERITO");

	}

	public List<OrderRowDTO> userOrderRow(Long userId) {
		List<OrderRow> orderRowList = orderRowRepo.findByOrderUserId(userId);
		List<OrderRowDTO> orderRowDTOList = orderRowMapper.toDto(orderRowList);
		return orderRowDTOList;
	}
}
