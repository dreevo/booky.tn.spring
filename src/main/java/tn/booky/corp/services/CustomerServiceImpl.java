package tn.booky.corp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.booky.corp.DAO.entities.Customer;
import tn.booky.corp.DAO.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository CustomerRepo;


	public Customer addCustomer(Customer C) {
		return CustomerRepo.save(C);
	}

	@Override
	public List<Customer> getList() {
		return CustomerRepo.findAll();
	}

	@Override
	public void delete(Long p) {
		CustomerRepo.deleteById(p);
	}

	@Override
	public Customer modify(Customer p) {
		Customer customer = CustomerRepo.findById(p.getId()).orElse(null);
		if (p.getAge() != 0)
			customer.setAge(p.getAge());
		else if (p.getAddress() != null)
			customer.setAddress(p.getAddress());
		else if (p.getFirstname() != null)
			customer.setFirstname(p.getFirstname());
		else if (p.getLastname() != null)
			customer.setLastname(p.getLastname());
		else if (p.getImgURL() != null)
			customer.setImgURL(p.getImgURL());
		else if (p.getPhone() != null)
			customer.setPhone(p.getPhone());
		return CustomerRepo.save(customer);
	}

	@Override
	public Customer findById(Long id) {
		return CustomerRepo.getOne(id);
	}

	@Override
	public Customer findByEmail(String E) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getAuthenticatedCustomer() {
		// TODO Auto-generated method stub
		Long id = 1L;
		return CustomerRepo.findById(id).orElse(null);
	}
}
