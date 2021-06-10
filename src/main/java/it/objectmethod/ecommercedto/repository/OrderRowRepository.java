package it.objectmethod.ecommercedto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.objectmethod.ecommercedto.entity.OrderRow;

@Repository
public interface OrderRowRepository extends JpaRepository<OrderRow, Long> {

	public List<OrderRow> findByArticleIdArticle(Long idArticle);

	public List<OrderRow> findByOrderUserId(Long idUser);
}
