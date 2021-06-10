package it.objectmethod.ecommercedto.service.dto;

import java.util.List;

import it.objectmethod.ecommercedto.entity.CartDetail;

public class CompleteCartDTO {

	private Long id;

	private List<CartDetail> cartDetailList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<CartDetail> getCartDetailList() {
		return cartDetailList;
	}

	public void setCartDetailList(List<CartDetail> cartDetailList) {
		this.cartDetailList = cartDetailList;
	}

}
