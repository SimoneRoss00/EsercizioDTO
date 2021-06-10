package it.objectmethod.ecommercedto.service.mapper;

import org.mapstruct.Mapper;

import it.objectmethod.ecommercedto.entity.Cart;
import it.objectmethod.ecommercedto.service.dto.CompleteCartDTO;

@Mapper(componentModel = "spring")
public interface CartMapper extends EntityMapper<CompleteCartDTO, Cart> {

	@Override
	CompleteCartDTO toDto(Cart entityList);

	@Override
	Cart toEntity(CompleteCartDTO dtoList);
}
