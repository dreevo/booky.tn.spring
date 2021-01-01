package booky.tn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import booky.tn.DAOentities.Customer;
import booky.tn.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository CustomerRepo;
	
   public Customer addCustomer (Customer C) {
	 return  CustomerRepo.save(C);
}
}
