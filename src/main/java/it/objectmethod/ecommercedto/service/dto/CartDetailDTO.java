package it.objectmethod.ecommercedto.service.dto;

import it.objectmethod.ecommercedto.entity.Article;

public class CartDetailDTO {

	private Long cartDetailId;

	private Integer cartQuantity;

	private Article article;

	public Long getCartDetailId() {
		return cartDetailId;
	}

	public void setCartDetailId(Long cartDetailId) {
		this.cartDetailId = cartDetailId;
	}

	public Integer getCartQuantity() {
		return cartQuantity;
	}

	public void setCartQuantity(Integer cartQuantity) {
		this.cartQuantity = cartQuantity;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

}
