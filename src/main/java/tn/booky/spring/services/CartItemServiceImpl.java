package tn.booky.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.booky.spring.DAO.entities.CartItem;
import tn.booky.spring.repositories.CartItemRepository;


@Service
public class CartItemServiceImpl implements CartItemService{
	@Autowired
	private CartItemRepository cartitemrepository;
	
	
	public CartItem addCartItem(CartItem ci){
		return cartitemrepository.save(ci);
	}
	
	public String deleteCartItem(int id){
		cartitemrepository.deleteById(id);
		return "cartItem" + id + "was deleted";
	}
	
	public String deleteCartitems(){
		cartitemrepository.deleteAll();
		return "cartitems were deleted";
	}
	
	public CartItem getCartItem(int id){
		return cartitemrepository.findById(id).orElse(null);
	}
	
	public List<CartItem> getCartItems(){
		return cartitemrepository.findAll();
	}
	
	public CartItem updateCartItem(CartItem ci){
		CartItem cartitem = cartitemrepository.findById(ci.getId()).orElse(null);
		cartitem.setQuantity(ci.getQuantity());
		return cartitemrepository.save(cartitem);
	}

}
