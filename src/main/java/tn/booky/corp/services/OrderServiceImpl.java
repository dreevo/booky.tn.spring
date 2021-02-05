package tn.booky.corp.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.booky.corp.DAO.entities.Customer;
import tn.booky.corp.DAO.entities.Order;
import tn.booky.corp.DAO.repositories.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderrepository;
	
	@Autowired
	private CustomerService customerservice;
	
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
	
	
	//getordersnotdone
	public List<String> getordersnotdone(){
		List<String> warnings = new ArrayList<String>();
		List<Order> notDoneOrders = orderrepository.getordersnotdone();
		Date curr = new Date();
		TimeUnit timeUnit = TimeUnit.DAYS;
		for(Order order : notDoneOrders){
			long diff = curr.getTime() - order.getDate().getTime();
			diff = timeUnit.convert(diff, timeUnit);
			if(diff > 15){
				Customer customer = customerservice.findById(order.getCart().getCustomer().getId());
				warnings.add("Customer with id "+ customer.getId()+ " has a non validated order.");
			}
		}
		return warnings;
	}

}
