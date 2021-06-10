package it.objectmethod.ecommercedto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.objectmethod.ecommercedto.entity.User;
import it.objectmethod.ecommercedto.repository.UserRepository;
import it.objectmethod.ecommercedto.service.dto.CompleteUserDTO;
import it.objectmethod.ecommercedto.service.dto.UserDTO;
import it.objectmethod.ecommercedto.service.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private UserMapper userMapper;

	public UserDTO loginUser(CompleteUserDTO completeUser) {
		String userName = completeUser.getUserName();
		String password = completeUser.getPassword();
		User user = userRepo.findByUserNameAndPassword(userName, password);
		UserDTO userDTO = userMapper.toDto(user);
		return userDTO;
	}

}
