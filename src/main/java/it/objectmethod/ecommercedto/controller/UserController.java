package it.objectmethod.ecommercedto.controller;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.ecommercedto.service.JWTService;
import it.objectmethod.ecommercedto.service.UserService;
import it.objectmethod.ecommercedto.service.dto.CompleteUserDTO;
import it.objectmethod.ecommercedto.service.dto.UserDTO;

@RestController
public class UserController {

	Logger log = LoggerFactory.logger(UserController.class);

	@Autowired
	private UserService userService;
	@Autowired
	private JWTService jwtService;

	@PostMapping("/login")
	@ResponseBody
	public String viewUserLogin(@RequestBody CompleteUserDTO completeUserDTO, HttpServletResponse response) {
		UserDTO userDTO = userService.loginUser(completeUserDTO);
		String token = "";
		if (userDTO == null) {
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		} else {
			token = jwtService.createJWTToken(userDTO);
		}

		return token;
	}
}
