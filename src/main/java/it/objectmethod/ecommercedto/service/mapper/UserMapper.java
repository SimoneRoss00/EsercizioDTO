package it.objectmethod.ecommercedto.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.objectmethod.ecommercedto.entity.User;
import it.objectmethod.ecommercedto.service.dto.UserDTO;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDTO, User> {

	@Override
	UserDTO toDto(User entity);

	@Override
	@Mapping(target = "password", ignore = true)
	User toEntity(UserDTO userDTO);
}
