package booky.tn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import booky.tn.DAOentities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
