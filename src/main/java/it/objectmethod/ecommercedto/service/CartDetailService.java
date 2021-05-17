package it.objectmethod.ecommercedto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.objectmethod.ecommercedto.entity.Article;
import it.objectmethod.ecommercedto.entity.Cart;
import it.objectmethod.ecommercedto.entity.CartDetail;
import it.objectmethod.ecommercedto.repository.ArticleRepository;
import it.objectmethod.ecommercedto.repository.CartDetailRepository;
import it.objectmethod.ecommercedto.repository.CartRepository;
import it.objectmethod.ecommercedto.service.dto.CartDTO;
import it.objectmethod.ecommercedto.service.dto.CartDetailDTO;
import it.objectmethod.ecommercedto.service.mapper.CartDetailMapper;

@Service
public class CartDetailService {

	@Autowired
	private CartDetailRepository cartDetailRepo;

	@Autowired
	private CartDetailMapper cartDetailMapper;

	@Autowired
	private ArticleRepository articleRepo;

	@Autowired
	private CartRepository cartRepo;

	public void addArticleInCart(Integer userId, Integer quantity, Integer articleId) {
		CartDetail cartDetail = new CartDetail();
		cartDetail.setCartQuantity(quantity);
		Article article = articleRepo.findByIdArticle(articleId);
		cartDetail.setArticle(article);
		Cart cart = cartRepo.findByuserId(userId);
		cartDetail.setCart(cart);
		cartDetailRepo.save(cartDetail);

	}

	public List<CartDetailDTO> showArticleCart(CartDTO cartDTO) {
		Integer cartId = cartDTO.getCartId();
		List<CartDetail> cartDetailList = cartDetailRepo.findByCartCartId(cartId);
		List<CartDetailDTO> cartDetailDTOList = cartDetailMapper.toDto(cartDetailList);
		return cartDetailDTOList;
	}

	public void deleteArticleInCart(Integer cartDetailId) {
		cartDetailRepo.deleteById(cartDetailId);
	}

	public CartDetailDTO findArticleBounght(Integer cartDetailId) {
		CartDetail cartDetail = cartDetailRepo.findBycartDetailId(cartDetailId);
		CartDetailDTO cartDetailDTO = cartDetailMapper.toDto(cartDetail);
		return cartDetailDTO;
	}

}
