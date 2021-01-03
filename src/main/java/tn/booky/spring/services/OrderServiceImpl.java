package tn.booky.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.booky.spring.DAO.entities.Order;
import tn.booky.spring.repositories.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderrepository;
	
	public Order addOrder(Order o){
		return orderrepository.save(o);
	}
	
	public String deleteOrder(int id){
		orderrepository.deleteById(id);
		return "order" + id + "was deleted";
	}
	
	public String deleteOrders(){
		orderrepository.deleteAll();
		return "orders were deleted";
	}
	
	public Order getOrder(int id){
		return orderrepository.findById(id).orElse(null);
	}
	
	public List<Order> getOrders(){
		return orderrepository.findAll();
	}
	
	public Order updateOrder(Order o){
		Order order = orderrepository.findById(o.getId()).orElse(null);
		order.setDate(o.getDate());
		order.setDiscount(o.getDiscount());
		order.setOrderType(o.getOrderType());
		order.setDone(o.isDone());
		return orderrepository.save(order);
	}

}
