package tn.booky.corp.DAO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.booky.corp.DAO.entities.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {
	

}