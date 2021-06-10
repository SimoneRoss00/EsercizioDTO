package it.objectmethod.ecommercedto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.objectmethod.ecommercedto.entity.Article;
import it.objectmethod.ecommercedto.repository.ArticleRepository;
import it.objectmethod.ecommercedto.service.dto.ArticleDTO;
import it.objectmethod.ecommercedto.service.mapper.ArticleMapper;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository articleRepo;

	@Autowired
	private ArticleMapper articleMapper;

	public List<ArticleDTO> listOfArtcle() {
		List<Article> articleList = articleRepo.findAllArticle();
		List<ArticleDTO> articleListDTO = articleMapper.toDto(articleList);
		return articleListDTO;
	}

	public ArticleDTO showArticleById(Long idArticle) {
		Article article = articleRepo.findByIdArticle(idArticle);
		ArticleDTO articleDto = articleMapper.toDto(article);
		return articleDto;
	}

}
