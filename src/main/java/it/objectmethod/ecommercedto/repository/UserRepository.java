package it.objectmethod.ecommercedto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.objectmethod.ecommercedto.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUserNameAndPassword(String userName, String password);

	public User findByIdUser(Integer idUser);

}
