package tn.booky.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import tn.booky.spring.DAO.entities.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

}
