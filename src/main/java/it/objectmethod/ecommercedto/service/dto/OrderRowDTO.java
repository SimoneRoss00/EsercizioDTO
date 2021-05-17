package it.objectmethod.ecommercedto.service.dto;

public class OrderRowDTO {

	private Integer orderRowId;

	private Integer quantity;

	private String articleNme;

	public Integer getOrderRowId() {
		return orderRowId;
	}

	public void setOrderRowId(Integer orderRowId) {
		this.orderRowId = orderRowId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getArticleNme() {
		return articleNme;
	}

	public void setArticleNme(String articleNme) {
		this.articleNme = articleNme;
	}

}
