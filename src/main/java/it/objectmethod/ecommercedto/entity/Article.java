package it.objectmethod.ecommercedto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "articolo")
public class Article {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id_articolo")
	private Long idArticle;

	@Column(name = "disponibilita")
	private Integer quantity;

	@Column(name = "codice_articolo")
	private String codeArticle;

	@Column(name = "nome_articolo")
	private String articleName;

	@Column(name = "prezzo_unitario")
	private Integer unitaryPrice;

	@Column(name = "image")
	private String articleImg;

	public Long getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(Long idArticle) {
		this.idArticle = idArticle;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getCodeArticle() {
		return codeArticle;
	}

	public void setCodeArticle(String codeArticle) {
		this.codeArticle = codeArticle;
	}

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	public Integer getUnitaryPrice() {
		return unitaryPrice;
	}

	public void setUnitaryPrice(Integer unitaryPrice) {
		this.unitaryPrice = unitaryPrice;
	}

	public String getArticleImg() {
		return articleImg;
	}

	public void setArticleImg(String articleImg) {
		this.articleImg = articleImg;
	}

}
