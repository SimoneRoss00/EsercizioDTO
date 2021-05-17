package it.objectmethod.ecommercedto.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.objectmethod.ecommercedto.entity.Order;
import it.objectmethod.ecommercedto.entity.User;
import it.objectmethod.ecommercedto.repository.OrderRepository;
import it.objectmethod.ecommercedto.repository.UserRepository;
import it.objectmethod.ecommercedto.service.dto.OrderDTO;
import it.objectmethod.ecommercedto.service.dto.UserDTO;
import it.objectmethod.ecommercedto.service.mapper.OrderMapper;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private UserRepository userRepo;

	public List<OrderDTO> showUserOrder(UserDTO userDTO) {
		Integer userId = userDTO.getIdUser();
		List<Order> orderList = orderRepo.findByUserIdUser(userId);
		List<OrderDTO> orderDTOList = orderMapper.toDto(orderList);
		return orderDTOList;
	}

	public void createOrder(String numberOrder, Integer userId) {
		Date date = new Date();
		Order order = new Order();
		numberOrder = "A000" + numberOrder;
		order.setNumberOrder(numberOrder);
		order.setOrderDate(date);
		User user = userRepo.findByIdUser(userId);
		order.setUser(user);
		orderRepo.save(order);

	}
}
