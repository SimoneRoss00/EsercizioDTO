package it.objectmethod.ecommercedto.service.dto;

public class ArticleDTO {

	private Integer articleId;

	private String articleName;

	private String articleCode;

	private String articlePrice;

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	public String getArticleCode() {
		return articleCode;
	}

	public void setArticleCode(String articleCode) {
		this.articleCode = articleCode;
	}

	public String getArticlePrice() {
		return articlePrice;
	}

	public void setArticlePrice(String articlePrice) {
		this.articlePrice = articlePrice;
	}

}
