package tn.booky.corp.services;

import java.util.List;


import tn.booky.corp.DAO.entities.CartItem;

public interface CartItemService {
	public CartItem addCartItem(CartItem c);
	public String deleteCartItem(int id);

	public String deleteCartitems();

	public CartItem getCartItem(int id);
	public List<CartItem> getCartItems();
	public CartItem updateCartItem(CartItem c);

}