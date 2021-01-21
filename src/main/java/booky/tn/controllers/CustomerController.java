package booky.tn.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import booky.tn.DAOentities.Customer;
import booky.tn.services.AccountServiceImpl;
import booky.tn.services.CustomerService;

@RestController
@CrossOrigin
@RequestMapping("/rest/")
public class CustomerController implements CustomerService<Customer> {
  
	@Autowired
	private CustomerService CS;
	@Autowired
	private AccountServiceImpl AS;
	
	
	@PostMapping("/addCustomer")
	public Customer addCustomer( @RequestBody Customer C){
		return AS.saveUser(C);
	}
	
	@GetMapping
    @Override
    public List<Customer> getList() {
        return CS.getList();
    }



@DeleteMapping("{id}")
    @Override
    public void delete(@PathVariable Long id) {
CS.delete(id);
    }


@PutMapping
    @Override
    public Customer modify(@RequestBody Customer p) {
        return (Customer) CS.modify(p);
    }



@GetMapping("{id}")
    @Override
    public Customer findById(@PathVariable Long id) {
    return (Customer) CS.findById(id);
}



@Override
public Customer findByEmail(String E) {
	// TODO Auto-generated method stub
	return null;
}
}
