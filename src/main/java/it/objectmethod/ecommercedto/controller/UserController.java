package it.objectmethod.ecommercedto.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.ecommercedto.service.UserService;
import it.objectmethod.ecommercedto.service.dto.CompleteUserDTO;
import it.objectmethod.ecommercedto.service.dto.UserDTO;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public UserDTO viewUserLogin(@RequestBody CompleteUserDTO userDTO, HttpServletResponse response) {
		UserDTO user = userService.loginUser(userDTO, response);
		return user;
	}
}
