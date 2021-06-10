package it.objectmethod.ecommercedto.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.objectmethod.ecommercedto.entity.Order;
import it.objectmethod.ecommercedto.entity.User;
import it.objectmethod.ecommercedto.repository.OrderRepository;
import it.objectmethod.ecommercedto.repository.UserRepository;
import it.objectmethod.ecommercedto.service.dto.OrderDTO;
import it.objectmethod.ecommercedto.service.mapper.OrderMapper;

@Service
public class OrderService {

	Logger log = LoggerFactory.logger(OrderService.class);

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private UserRepository userRepo;

	public List<OrderDTO> showUserOrder(Long userId) {
		List<Order> orderList = orderRepo.findByUserId(userId);
		List<OrderDTO> orderDTOList = orderMapper.toDto(orderList);
		return orderDTOList;
	}

	public void createOrder(Long userId) {
		Date date = new Date();
		Order order = new Order();
		String numberOrder = "A000" + Math.round(Math.random() * 999);
		order.setNumberOrder(numberOrder);
		order.setOrderDate(formatter.format(date));
		User user = userRepo.findByid(userId);
		order.setUser(user);
		orderRepo.save(order);
		log.info("ORDINE INSERITO");

	}

	public List<OrderDTO> getDateOfYesterday(Date date) {
		List<Order> orderList = orderRepo.findByOrderDate(date);
		List<OrderDTO> orderDTOList = orderMapper.toDto(orderList);
		return orderDTOList;
	}

	public Long getLastOrderId(Long userId) {
		List<Order> orderList = orderRepo.findByUserId(userId);
		List<OrderDTO> orderDTOList = orderMapper.toDto(orderList);
		OrderDTO orderDTO = orderDTOList.get(orderDTOList.size() - 1);
		Long orderId = orderDTO.getOrderId();
		return orderId;
	}
}
