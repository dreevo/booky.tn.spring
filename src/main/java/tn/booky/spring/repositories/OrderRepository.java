package tn.booky.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import tn.booky.spring.DAO.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>  {

}
