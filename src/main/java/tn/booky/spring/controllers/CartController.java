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

import tn.booky.spring.DAO.entities.Cart;
import tn.booky.spring.services.CartService;

@RestController
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
	
	@GetMapping("/getCart/{id}")
	public Cart getCart(@PathVariable int id){
		return cartservice.getCart(id);	
	}
	
	@GetMapping("/getCarts")
	public List<Cart> getCarts(){
		return cartservice.getCarts();	
	}
	
	@PutMapping("/updateCart")
	public Cart updateCart(@RequestBody Cart c){
		return cartservice.updateCart(c);	
	}

}
