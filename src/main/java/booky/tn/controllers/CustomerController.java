package booky.tn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import booky.tn.DAOentities.Customer;
import booky.tn.services.CustomerService;

@RestController
public class CustomerController {
  
	@Autowired
	private CustomerService CS;
	
	@PostMapping("/addCustomer")
	public Customer addCustomer(@RequestBody Customer C){
		return CS.addCustomer(C);
	}
}
