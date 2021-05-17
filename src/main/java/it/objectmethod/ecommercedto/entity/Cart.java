package it.objectmethod.ecommercedto.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "carrello")
public class Cart {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id_carrello")
	private Integer cartId;
	@Column(name = "id_utente")
	private Integer userId;
	@JsonIgnore
	@OneToMany
	private List<CartDetail> cartDetailList;

	public List<CartDetail> getCartDetailList() {
		return cartDetailList;
	}

	public void setCartDetailList(List<CartDetail> cartDetailList) {
		this.cartDetailList = cartDetailList;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
