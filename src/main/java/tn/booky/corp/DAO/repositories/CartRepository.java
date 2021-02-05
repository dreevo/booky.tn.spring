package tn.booky.corp.DAO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.booky.corp.DAO.entities.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
	
	@Query("select c from Cart c where c.id = :id")
	public Cart findcart(@Param ("id")int id);
	

}