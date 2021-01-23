package tn.booky.corp.DAO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.booky.corp.DAO.entities.Book;
import tn.booky.corp.DAO.entities.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
	public CartItem findByBook(Book b);
}