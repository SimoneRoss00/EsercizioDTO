package it.objectmethod.ecommercedto.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.objectmethod.ecommercedto.entity.OrderRow;
import it.objectmethod.ecommercedto.service.dto.OrderRowDTO;

@Mapper(componentModel = "spring")
public interface OrderRowMapper extends EntityMapper<OrderRowDTO, OrderRow> {

	@Override
	@Mapping(source = "idOrderRow", target = "orderRowId")
	@Mapping(source = "quantityOrder", target = "quantity")
	@Mapping(source = "article.articleName", target = "articleNme")
	public OrderRowDTO toDto(OrderRow entity);

	@Override
	@Mapping(target = "order", ignore = true)
	@Mapping(source = "orderRowId", target = "idOrderRow")
	@Mapping(source = "quantity", target = "quantityOrder")
	@Mapping(source = "articleNme", target = "article.articleName")
	public OrderRow toEntity(OrderRowDTO dto);

}
