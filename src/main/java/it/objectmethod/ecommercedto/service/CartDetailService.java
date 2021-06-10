package it.objectmethod.ecommercedto.service;

import javax.transaction.Transactional;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.objectmethod.ecommercedto.entity.Article;
import it.objectmethod.ecommercedto.entity.Cart;
import it.objectmethod.ecommercedto.entity.CartDetail;
import it.objectmethod.ecommercedto.repository.ArticleRepository;
import it.objectmethod.ecommercedto.repository.CartDetailRepository;
import it.objectmethod.ecommercedto.repository.CartRepository;
import it.objectmethod.ecommercedto.service.dto.CartDetailDTO;
import it.objectmethod.ecommercedto.service.dto.CompleteCartDTO;
import it.objectmethod.ecommercedto.service.mapper.CartDetailMapper;
import it.objectmethod.ecommercedto.service.mapper.CartMapper;

@Service
@Transactional
public class CartDetailService {

	Logger log = LoggerFactory.logger(CartDetailService.class);

	@Autowired
	private CartDetailRepository cartDetailRepo;

	@Autowired
	private CartDetailMapper cartDetailMapper;

	@Autowired
	private ArticleRepository articleRepo;

	@Autowired
	private CartMapper cartMapper;

	@Autowired
	private CartRepository cartRepo;

	public void addArticleInCart(Long userId, Integer quantity, Long articleId) {
		CartDetail cartDetail = new CartDetail();
		cartDetail.setCartQuantity(quantity);
		Article article = articleRepo.findByIdArticle(articleId);
		cartDetail.setArticle(article);
		Cart cart = cartRepo.findByUserId(userId);
		cartDetail.setCart(cart);
		cartDetailRepo.save(cartDetail);
		log.info("ARTICOLO INSERITO NEL CARRELLO DETTAGLIO");
	}

	public CompleteCartDTO showArticleCart(Long userId) {
		Cart cart = cartRepo.findByUserId(userId);
		CompleteCartDTO completeCartDTO = cartMapper.toDto(cart);
		return completeCartDTO;
	}

	public void deleteArticleInCart(Long cartDetailId) {
		cartDetailRepo.deleteById(cartDetailId);
		log.info("ARTICOLO ELIMINATO DAL CARRELLO DETTAGLIO CON L'ID" + cartDetailId);
	}

	public void deleteAllArticleInCart(Long userId) {
		cartDetailRepo.deleteByCartUserId(userId);
	}

	public CartDetailDTO findArticleBounght(Long cartDetailId) {
		CartDetail cartDetail = cartDetailRepo.findBycartDetailId(cartDetailId);
		CartDetailDTO cartDetailDTO = cartDetailMapper.toDto(cartDetail);
		log.info("ARTICOLO COMPRATO");
		return cartDetailDTO;
	}

	public CompleteCartDTO findAllArticleBounght(Long userId) {
		Cart cart = cartRepo.findByUserId(userId);
		CompleteCartDTO completeCartDTO = cartMapper.toDto(cart);
		return completeCartDTO;
	}

}
