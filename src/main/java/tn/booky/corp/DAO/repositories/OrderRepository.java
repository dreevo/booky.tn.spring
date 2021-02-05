package tn.booky.corp.DAO.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.booky.corp.DAO.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	//@Query("select o from Order o join O.cart C join C.customer CU where o.isDone = false")
	@Query("select o from Order o join Cart c on o.cart = c.id join Customer CU on c.customer = CU.id where o.isDone = false")
	public List<Order> getordersnotdone();
}
