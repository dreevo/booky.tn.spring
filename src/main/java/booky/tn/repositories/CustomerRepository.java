package booky.tn.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import booky.tn.DAOentities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findUsersByEmail(String email);

    @Query(value = "SELECT u.* FROM `customer` u,`customer_roles` ur,`role` r WHERE r.id=ur.roles_id and ur.customer_id=u.id and r.role_name = ?", nativeQuery = true)
    List<Customer> findUsers(String type);
}
