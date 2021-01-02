package tn.booky.corp.DAO.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.booky.corp.DAO.entities.Book;

/**
 * @author gharbimedaziz
 */

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	Book findByLabel(String label);

	@Query("SELECT B from Book B WHERE B.label LIKE %?1%")
	public List<Book> searchBooksByLabel(String keyword);
	
}
