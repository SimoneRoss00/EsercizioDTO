package it.objectmethod.ecommercedto.controller;

import java.util.List;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.ecommercedto.service.JWTService;
import it.objectmethod.ecommercedto.service.OrderService;
import it.objectmethod.ecommercedto.service.dto.OrderDTO;

@RestController
public class OrderController {

	Logger log = LoggerFactory.logger(OrderController.class);

	@Autowired
	private OrderService serviceOrder;
	@Autowired
	private JWTService jwtService;

	@GetMapping("/viewUserOrder")
	public List<OrderDTO> viewUserOrderList(@RequestHeader("auth-token") String token) {
		List<OrderDTO> orderDTOList = serviceOrder.showUserOrder(jwtService.getUserIdByToken(token));
		return orderDTOList;

	}

	@GetMapping("/addOrder")
	public void addNewOrder(@RequestParam("numeroOrdine") String numberOrder,
			@RequestHeader("auth-token") String token) {
		Long userId = jwtService.getUserIdByToken(token);
		serviceOrder.createOrder(userId);
	}

}
