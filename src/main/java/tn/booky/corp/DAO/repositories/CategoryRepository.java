package tn.booky.corp.DAO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.booky.corp.DAO.entities.Category;

/**
 * @author gharbimedaziz
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	Category findByName(String name);
	
	@Query("SELECT C from Category C join C.books B join B.cartItem CI where CI.quantity is (SELECT MAX(CI.quantity) as maximum from CI group by CI.book)")
	public Category getMostSelectedCategory();
}
