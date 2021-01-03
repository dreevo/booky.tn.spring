package tn.booky.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.booky.spring.DAO.entities.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {
	

}
