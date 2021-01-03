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
import tn.booky.spring.DAO.entities.Order;
import tn.booky.spring.services.OrderService;

@RestController
public class OrderController {
	@Autowired
	private OrderService orderservice;
	
	@PostMapping("/addOrder")
	public Order addOrder(@RequestBody Order o){
		return orderservice.addOrder(o);	
	}
	
	@DeleteMapping("/deleteOrder/{id}")
	public String deleteOrder(@PathVariable int id){
		return orderservice.deleteOrder(id);	
	}
	
	@DeleteMapping("/deleteOrders")
	public String deleteOrders(){
		return orderservice.deleteOrders();	
	}
	
	@GetMapping("/getOrder/{id}")
	public Order getOrder(@PathVariable int id){
		return orderservice.getOrder(id);	
	}
	
	@GetMapping("/getOrders")
	public List<Order> getOrders(){
		return orderservice.getOrders();	
	}
	
	@PutMapping("/updateOrder")
	public Order updateOrder(@RequestBody Order o){
		return orderservice.updateOrder(o);	
	}

}
