package booky.tn.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import java.util.List;
import booky.tn.DAOentities.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
		List<Customer> findByEmail(String email);
	    Optional<Customer> findByUsername(String username);
		
	    Boolean existsByUsername(String username);
	    Boolean existsByEmail(String email);
}