package it.objectmethod.ecommercedto.service.mapper;

import org.mapstruct.Mapper;

import it.objectmethod.ecommercedto.entity.Cart;
import it.objectmethod.ecommercedto.service.dto.CartDTO;

@Mapper(componentModel = "spring")
public interface CartMapper extends EntityMapper<CartDTO, Cart> {

	@Override
	CartDTO toDto(Cart entityList);

	@Override
	Cart toEntity(CartDTO dtoList);
}
