package it.objectmethod.ecommercedto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.objectmethod.ecommercedto.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	public List<Order> findByUserIdUser(Integer userId);

	public Order findByOrderId(Integer orderId);

}
