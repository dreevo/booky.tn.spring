package booky.tn.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import booky.tn.DAOentities.Customer;
import booky.tn.Repositories.CustomerRepository;


//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CustomerController {
 
  @Autowired
  CustomerRepository CR;
 
  @GetMapping("/customers")
  public List<Customer> getAllUser() {
    System.out.println("Obtenez tous les utilisateurs...");
 
    List<Customer> C = new ArrayList<>();
    CR.findAll().forEach(C::add);
 
    return C;
  }
	
	@DeleteMapping("/customers/{id}")
	  public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long id) {
	    System.out.println("Delete customer with ID = " + id + "...");
	 
	    CR.deleteById(id);
	 
	    return new ResponseEntity<>("Customer deleted with success!", HttpStatus.OK);
	  }
	
	@DeleteMapping("/customers/delete")
	  public ResponseEntity<String> deleteAllUser() {
	    System.out.println("Delete all customers...");
	 
	    CR.deleteAll();
	 
	    return new ResponseEntity<>("All customers was deleted!", HttpStatus.OK);
	  }	
	
	@GetMapping(value = "costomers/email/{email}")
	  public List<Customer> findByEmail(@PathVariable String email) {
	 
	    List<Customer> C = CR.findByEmail(email);
	    return C;
	  }
	
	
	 @PutMapping("/customers/update/{id}")
	  public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long id, @RequestBody Customer C) {
	    System.out.println("Update customer with ID = " + id + "...");
	    Optional<Customer> userData = CR.findById(id);
	    
	    if (userData.isPresent()) {
	      Customer _Cust = userData.get();
	      _Cust.setFirstname(C.getFirstname());
	      _Cust.setLastname(C.getLastname());
        _Cust.setUsername(C.getUsername());
	      _Cust.setAge(C.getAge());
	      _Cust.setEmail(C.getEmail());
	      _Cust.setAddress(C.getAddress());
	      _Cust.setImgURL(C.getImgURL());
	      _Cust.setPhone(C.getPhone());
	      _Cust.setPassword(C.getPassword());
	      return new ResponseEntity<>(CR.save(_Cust), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
}
