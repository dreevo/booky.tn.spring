package tn.booky.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.booky.spring.DAO.entities.CartItem;
import tn.booky.spring.services.CartItemService;

@RestController
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
	
	@GetMapping("/getCartItem/{id}")
	public CartItem getCartItem(@PathVariable int id){
		return cartitemservice.getCartItem(id);	
	}
	
	@GetMapping("/getCartItems")
	public List<CartItem> getCartItems(){
		return cartitemservice.getCartItems();	
	}
	
	@PutMapping("/updateCartItemt")
	public CartItem updateCartItem(@RequestBody CartItem ci){
		return cartitemservice.updateCartItem(ci);	
	}

}
