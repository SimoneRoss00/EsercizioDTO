package it.objectmethod.ecommercedto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.ecommercedto.service.ArticleService;
import it.objectmethod.ecommercedto.service.dto.ArticleDTO;

@RestController
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@GetMapping("/article")
	public List<ArticleDTO> viewArticleList() {
		List<ArticleDTO> articleDTOList = articleService.listOfArtcle();
		return articleDTOList;
	}

	@GetMapping("/showArticle/{idArticolo}")
	public ArticleDTO viewArticleById(@PathVariable("idArticolo") Integer idArticle) {
		ArticleDTO articleDTO = articleService.showArticleById(idArticle);
		return articleDTO;
	}

}
