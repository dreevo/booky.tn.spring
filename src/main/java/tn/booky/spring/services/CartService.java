package tn.booky.spring.services;

import java.util.List;

import tn.booky.spring.DAO.entities.Cart;

public interface CartService {
	public Cart addCart(Cart c);
	public String deleteCart(int id);
	public String deleteCarts();
	public Cart getCart(int id);
	public List<Cart> getCarts();
	public Cart updateCart(Cart c);
	
	
}
