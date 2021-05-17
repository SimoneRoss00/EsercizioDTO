package it.objectmethod.ecommercedto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.objectmethod.ecommercedto.entity.CartDetail;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Integer> {

	public List<CartDetail> findByCartCartId(Integer cartId);

	public CartDetail findBycartDetailId(Integer cartDetailId);
}
