package it.objectmethod.ecommercedto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "carrello_dettaglio")
public class CartDetail {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id_carrello_dettaglio")
	private Long cartDetailId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_carrello")
	private Cart cart;

	@Column(name = "quantita")
	private Integer cartQuantity;

	@ManyToOne
	@JoinColumn(name = "id_articolo")
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

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

}
