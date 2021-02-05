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
import tn.booky.corp.DAO.entities.Cart;
import tn.booky.corp.services.CartService;
@RestController
@RequestMapping("/cart/")
public class CartController {
	
	@Autowired
	private CartService cartservice;
	
	@PostMapping("/addCart")
	public Cart addCart(@RequestBody Cart c){
		return cartservice.addCart(c);	
	}
	
	@DeleteMapping("/deleteCart/{id}")
	public String deleteCart(@PathVariable int id){
		return cartservice.deleteCart(id);	
	}
	
	@DeleteMapping("/deleteCarts")
	public String deleteCarts(){
		return cartservice.deleteCarts();	
	}
	
	@GetMapping("/Cart/{id}")
	public Cart getCart(@PathVariable("id") int id){
		return cartservice.getCart(id);	
	}
	
	
	@GetMapping("/Carts")
	public List<Cart> getCarts(){
		return cartservice.getCarts();	
	}
	
	@PutMapping("/updateCart")
	public Cart updateCart(@RequestBody Cart c){
		return cartservice.updateCart(c);	
	}
	@GetMapping("/calculatTotalafterreduction/{cart_id}")
	public double calculatTotalafterreduction(@PathVariable int cart_id){
		return cartservice.calculatTotalafterreduction(cart_id);
	}	
	
	@GetMapping("/assignSumToCart/{cart_id}/{book_id}")
	public Cart assignSumToCart(@PathVariable ("cart_id")int cart_id,@PathVariable("book_id") int book_id){
		return cartservice.assignSumToCart(cart_id,book_id);
	}	
	

}
