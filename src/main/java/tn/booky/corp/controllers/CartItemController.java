package tn.booky.corp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.booky.corp.DAO.entities.CartItem;
import tn.booky.corp.DAO.entities.Book;
import tn.booky.corp.services.CartItemService;

@RestController
@RequestMapping("/cart/")
public class CartItemController {
	
	@Autowired
	private CartItemService cartitemservice;
	
	@PostMapping("/addCartItem")
	public CartItem addCartItem(@RequestBody CartItem ci){
		return cartitemservice.addCartItem(ci);	
	}
	
	@DeleteMapping("/deleteCartItem/{id}")
	public String deleteCartItem(@PathVariable int id){
		return cartitemservice.deleteCartItem(id);	
	}
	
	@DeleteMapping("/deleteCartitems")
	public String deleteCartitems(){
		return cartitemservice.deleteCartitems();	
	}
	
	@GetMapping("/CartItem/{id}")
	public CartItem getCartItem(@PathVariable int id){
		return cartitemservice.getCartItem(id);	
	}
	
	@GetMapping("/CartItems")
	public List<CartItem> getCartItems(){
		return cartitemservice.getCartItems();	
	}
	
	@PutMapping("/updateCartItemt")
	public CartItem updateCartItem(@RequestBody CartItem ci){
		return cartitemservice.updateCartItem(ci);	
	}
	
	@GetMapping("/getitemsbycat_id/{cart_id}")
	public List<CartItem> getitemsbycat_id(@PathVariable int cart_id){
		return cartitemservice.getitemsbycat_id(cart_id);
	}	
	
	
	@GetMapping("/gettopfiveofbooks")
	public List<Book> gettopfiveofbooks(){
		return cartitemservice.gettopfiveofbooks();
	}	
	
	@GetMapping("/getworstfiveofbooks")
	public List<Book> getworstfiveofbooks(){
		return cartitemservice.getwortfiveofbooks();
	}	
}
