package it.objectmethod.ecommercedto.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ordine")
public class Order {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id_ordine")
	private Long orderId;

	@Column(name = "numero_ordine")
	private String numberOrder;

	@ManyToOne
	@JoinColumn(name = "id_utente")
	private User user;

	@Column(name = "data_ordine")
	private String orderDate;

	@JsonIgnore
	@OneToMany
	private List<OrderRow> orderRowList;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getNumberOrder() {
		return numberOrder;
	}

	public void setNumberOrder(String numberOrder) {
		this.numberOrder = numberOrder;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public List<OrderRow> getOrderRowList() {
		return orderRowList;
	}

	public void setOrderRowList(List<OrderRow> orderRowList) {
		this.orderRowList = orderRowList;
	}

}
