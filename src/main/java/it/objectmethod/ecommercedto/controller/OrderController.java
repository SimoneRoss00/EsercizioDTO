package it.objectmethod.ecommercedto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.ecommercedto.service.OrderService;
import it.objectmethod.ecommercedto.service.dto.OrderDTO;
import it.objectmethod.ecommercedto.service.dto.UserDTO;

@RestController
public class OrderController {

	@Autowired
	private OrderService serviceOrder;

	@GetMapping("/viewUserOrder")
	public List<OrderDTO> viewUserOrderList(@RequestBody UserDTO userDTO) {
		List<OrderDTO> orderDTOList = serviceOrder.showUserOrder(userDTO);
		return orderDTOList;

	}

	@GetMapping("/addOrder/{idUser}")
	public void addNewOrder(@RequestParam("numeroOrdine") String numberOrder, @PathVariable("idUser") Integer idUser) {
		serviceOrder.createOrder(numberOrder, idUser);
	}

}
