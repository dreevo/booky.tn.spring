package tn.booky.corp.services;

import tn.booky.corp.DAO.entities.Book;
import tn.booky.corp.DAO.entities.Cart;
import tn.booky.corp.DAO.entities.CartItem;
import tn.booky.corp.DAO.repositories.BookRepository;
import tn.booky.corp.DAO.repositories.CartItemRepository;
import tn.booky.corp.DAO.repositories.CartRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{
	@Autowired
	private CartRepository cartRepository;
	@Autowired 
	private CartItemRepository cartItemRepository;
	@Autowired 
	private BookRepository bookRepository;
	
	
	public Cart addCart(Cart c){
		return cartRepository.save(c);
	}
	
	public String deleteCart(int id){
		cartRepository.deleteById(id);
		return "cart" + id + "was deleted";
	}
	
	public String deleteCarts(){
		cartRepository.deleteAll();
		return "carts were deleted";
	}
	
	public Cart getCart(int id){
		return cartRepository.findById(id).orElse(null);
	}
	
	public List<Cart> getCarts(){
		return cartRepository.findAll();
	}
	
	public Cart updateCart(Cart c){
		Cart cart = cartRepository.findById(c.getId()).orElse(null);
		cart.setTotalPrice(c.getTotalPrice());
		return cartRepository.save(cart);
	}
	
	public Cart assignSumToCart(int cartId, int bookId){
		Cart cart = cartRepository.findById(cartId).orElse(null);
		Book book = bookRepository.findById(bookId).orElse(null);
		CartItem cartItem = cartItemRepository.findByBook(book);
		double total = cartItem.getQuantity() * book.getPrice();
		cart.setTotalPrice(total);
		return cartRepository.save(cart);
	}
}