package it.objectmethod.ecommercedto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.objectmethod.ecommercedto.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

	public Cart findByUserId(Long userId);

}
