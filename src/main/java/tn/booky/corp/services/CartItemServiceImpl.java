package tn.booky.corp.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.booky.corp.DAO.entities.Book;
import tn.booky.corp.DAO.entities.CartItem;
import tn.booky.corp.DAO.repositories.CartItemRepository;


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

	public List<CartItem> getitemsbycat_id(int cart_id) {
		return cartitemrepository.getitemsbycat_id(cart_id);
	}

	
	public List<Book> gettopfiveofbooks(){
		return cartitemrepository.gettopfiveofbooks().stream().limit(5).collect(Collectors.toList());
    }
	
	public List<Book> getwortfiveofbooks(){
		return cartitemrepository.getworstfiveofbooks().stream().limit(5).collect(Collectors.toList());
	}
	
	
}
