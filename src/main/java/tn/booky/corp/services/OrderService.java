package tn.booky.corp.services;

import java.util.List;
import tn.booky.corp.DAO.entities.Order;

public interface OrderService {
	public Order addOrder(Order o);

	public String deleteOrder(int id);

	public String deleteOrders();

	public Order getOrder(int id);

	public List<Order> getOrders();

	public Order updateOrder(Order o);
	
	public List<String> getordersnotdone();

}