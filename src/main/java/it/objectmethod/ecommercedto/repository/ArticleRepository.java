package it.objectmethod.ecommercedto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.objectmethod.ecommercedto.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

	@Query(value = "SELECT article FROM Article article")
	public List<Article> findAllArticle();

	public Article findByIdArticle(Integer idArticle);

}
