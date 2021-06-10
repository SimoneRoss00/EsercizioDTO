package it.objectmethod.ecommercedto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.objectmethod.ecommercedto.entity.CartDetail;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {

	public List<CartDetail> findByCartUserId(Long userId);

	public CartDetail findBycartDetailId(Long cartDetailId);

	public void deleteByCartUserId(Long userId);
}
