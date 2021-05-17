package it.objectmethod.ecommercedto.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.objectmethod.ecommercedto.entity.Order;
import it.objectmethod.ecommercedto.service.dto.OrderDTO;

@Mapper(componentModel = "spring")
public interface OrderMapper extends EntityMapper<OrderDTO, Order> {

	@Override
	@Mapping(source = "numberOrder", target = "orderNumber")
	@Mapping(source = "orderDate", target = "dateOrder")
	public OrderDTO toDto(Order entity);

	@Override
	@Mapping(target = "user", ignore = true)
	@Mapping(source = "orderNumber", target = "numberOrder")
	@Mapping(source = "dateOrder", target = "orderDate")
	public Order toEntity(OrderDTO dto);

}
