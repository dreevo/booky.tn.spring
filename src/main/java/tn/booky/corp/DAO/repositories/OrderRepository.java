package tn.booky.corp.DAO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.booky.corp.DAO.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
