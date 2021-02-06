package tn.booky.corp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.booky.corp.DAO.entities.Customer;
import tn.booky.corp.services.AccountServiceImpl;
import tn.booky.corp.services.CustomerService;

@RestController
@CrossOrigin
@RequestMapping("/rest/")
public class CustomerController {

	@Autowired
	private CustomerService CS;
	@Autowired
	private AccountServiceImpl AS;

	@PostMapping("/addCustomer")
	public Customer addCustomer(@RequestBody Customer C) {
		return AS.saveUser(C);
	}

	@GetMapping
	public List<Customer> getList() {
		return CS.getList();
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		CS.delete(id);
	}

	@PutMapping("/updateCustomer")
	public Customer modify(@RequestBody Customer p) {
		return CS.modify(p);
	}

	@GetMapping("{id}")
	public Customer findById(@PathVariable Long id) {
		return (Customer) CS.findById(id);
	}

	public Customer findByEmail(String E) {
		// TODO Auto-generated method stub
		return null;
	}
}
