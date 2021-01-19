package booky.tn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import booky.tn.DAOentities.Customer;
import booky.tn.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService<Customer> {
	
	@Autowired
	private CustomerRepository CustomerRepo;
	
   public Customer addCustomer (Customer C) {
	 return  CustomerRepo.save(C);
}
   
   @Override
   public List<Customer> getList() {
       return CustomerRepo.findAll();
   }

   @Override
   public void delete(Long p) {
	   CustomerRepo.deleteById( p);
   }

   @Override
   public Customer modify(Customer p) {

       return CustomerRepo.save(p);
   }

   @Override
   public Customer findById(Long id) {
       return CustomerRepo.getOne( id);
   }

@Override
public Customer findByEmail(String E) {
	// TODO Auto-generated method stub
	return null;
}

   
}
