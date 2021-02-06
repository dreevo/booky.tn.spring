package tn.booky.corp.services;

import java.util.List;

import tn.booky.corp.DAO.entities.Customer;

public interface CustomerService {

	public Customer addCustomer(Customer C);

	public List<Customer> getList();

	public void delete(Long p);

	public Customer modify(Customer c);

	public Customer findById(Long id);

	public Customer findByEmail(String E);

	public Customer getAuthenticatedCustomer();
	
}
