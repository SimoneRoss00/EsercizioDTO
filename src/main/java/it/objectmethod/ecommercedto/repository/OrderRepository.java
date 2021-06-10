package it.objectmethod.ecommercedto.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.objectmethod.ecommercedto.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	public List<Order> findByUserId(Long userId);

	public Order findByOrderId(Long orderId);

	public List<Order> findByOrderDate(Date date);

}
