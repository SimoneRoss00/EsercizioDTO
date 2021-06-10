package it.objectmethod.ecommercedto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "riga_ordine")
public class OrderRow {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id_riga_ordine")
	private Long idOrderRow;

	@Column(name = "quantita")
	private Integer quantityOrder;

	@ManyToOne
	@JoinColumn(name = "id_articolo")
	private Article article;

	@ManyToOne
	@JoinColumn(name = "id_ordine")
	private Order order;

	public Long getIdOrderRow() {
		return idOrderRow;
	}

	public void setIdOrderRow(Long idOrderRow) {
		this.idOrderRow = idOrderRow;
	}

	public Integer getQuantityOrder() {
		return quantityOrder;
	}

	public void setQuantityOrder(Integer quantityOrder) {
		this.quantityOrder = quantityOrder;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
