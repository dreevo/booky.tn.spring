package tn.booky.spring.services;

import java.util.List;
import tn.booky.spring.DAO.entities.Order;

public interface OrderService {
	public Order addOrder(Order o);
	public String deleteOrder(int id);
	public String deleteOrders();
	public Order getOrder(int id);
	public List<Order> getOrders();
	public Order updateOrder(Order o);

}
