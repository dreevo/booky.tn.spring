package tn.booky.spring.services;

import tn.booky.spring.DAO.entities.Cart;
import tn.booky.spring.repositories.CartRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{
	@Autowired
	private CartRepository cartrepository;
	
	
	public Cart addCart(Cart c){
		return cartrepository.save(c);
	}
	
	public String deleteCart(int id){
		cartrepository.deleteById(id);
		return "cart" + id + "was deleted";
	}
	
	public String deleteCarts(){
		cartrepository.deleteAll();
		return "carts were deleted";
	}
	
	public Cart getCart(int id){
		return cartrepository.findById(id).orElse(null);
	}
	
	public List<Cart> getCarts(){
		return cartrepository.findAll();
	}
	
	
	
	public Cart updateCart(Cart c){
		Cart cart = cartrepository.findById(c.getId()).orElse(null);
		cart.setTotalPrice(c.getTotalPrice());
		return cartrepository.save(cart);
	}
	
}
