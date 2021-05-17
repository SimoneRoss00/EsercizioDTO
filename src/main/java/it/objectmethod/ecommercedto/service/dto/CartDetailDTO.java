package it.objectmethod.ecommercedto.service.dto;

public class CartDetailDTO {

	private Integer cartDetailId;

	private String articleName;

	private Integer cartQuantity;

	public Integer getCartDetailId() {
		return cartDetailId;
	}

	public void setCartDetailId(Integer cartDetailId) {
		this.cartDetailId = cartDetailId;
	}

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	public Integer getCartQuantity() {
		return cartQuantity;
	}

	public void setCartQuantity(Integer cartQuantity) {
		this.cartQuantity = cartQuantity;
	}

}
