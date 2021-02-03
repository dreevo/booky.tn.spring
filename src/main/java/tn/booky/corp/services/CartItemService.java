package tn.booky.corp.services;

import java.util.List;

import tn.booky.corp.DAO.entities.CartItem;
import tn.booky.corp.DAO.entities.Book;

public interface CartItemService {
	public CartItem addCartItem(CartItem c);

	public String deleteCartItem(int id);

	public String deleteCartitems();

	public CartItem getCartItem(int id);

	public List<CartItem> getCartItems();

	public CartItem updateCartItem(CartItem c);

	public List<CartItem> getitemsbycat_id(int cart_id);

	public void deleteItemFromCart(int cart_id, int book_id);

	public List<Book> gettopfiveofbooks();

	public List<Book> getwortfiveofbooks();

}