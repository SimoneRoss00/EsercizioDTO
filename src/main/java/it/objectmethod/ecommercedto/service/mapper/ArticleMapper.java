package it.objectmethod.ecommercedto.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.objectmethod.ecommercedto.entity.Article;
import it.objectmethod.ecommercedto.service.dto.ArticleDTO;

@Mapper(componentModel = "spring")
public interface ArticleMapper extends EntityMapper<ArticleDTO, Article> {

	@Override
	@Mapping(source = "idArticle", target = "articleId")
	@Mapping(source = "codeArticle", target = "articleCode")
	@Mapping(source = "unitaryPrice", target = "articlePrice")
	ArticleDTO toDto(Article entityList);

	@Override
	@Mapping(target = "quantity", ignore = true)
	@Mapping(source = "articleId", target = "idArticle")
	@Mapping(source = "articleCode", target = "codeArticle")
	@Mapping(source = "articlePrice", target = "unitaryPrice")
	Article toEntity(ArticleDTO dtoList);
}
