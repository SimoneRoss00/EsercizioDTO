package it.objectmethod.ecommercedto.entity;

import java.util.Date;
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
	private Integer orderId;

	@Column(name = "numero_ordine")
	private String numberOrder;

	@ManyToOne
	@JoinColumn(name = "id_utente")
	private User user;

	@Column(name = "data_ordine")
	private Date orderDate;

	@JsonIgnore
	@OneToMany
	private List<OrderRow> orderRowList;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
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

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	/*
	 * public List<OrderRow> getOrderRowList() { return orderRowList; }
	 * 
	 * public void setOrderRowList(List<OrderRow> orderRowList) { this.orderRowList
	 * = orderRowList; }
	 */

}
