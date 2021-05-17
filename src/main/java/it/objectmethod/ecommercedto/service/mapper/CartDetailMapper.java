package it.objectmethod.ecommercedto.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.objectmethod.ecommercedto.entity.CartDetail;
import it.objectmethod.ecommercedto.service.dto.CartDetailDTO;

@Mapper(componentModel = "spring")
public interface CartDetailMapper extends EntityMapper<CartDetailDTO, CartDetail> {

	@Override
	@Mapping(source = "article.articleName", target = "articleName")
	public CartDetailDTO toDto(CartDetail entity);

	@Override
	@Mapping(target = "cart", ignore = true)
	@Mapping(source = "articleName", target = "article.articleName")
	public CartDetail toEntity(CartDetailDTO dto);
}
