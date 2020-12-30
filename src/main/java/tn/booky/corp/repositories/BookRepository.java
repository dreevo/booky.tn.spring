package tn.booky.corp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.booky.corp.DAO.entities.Book;

/**
 * @author gharbimedaziz
 */

public interface BookRepository extends JpaRepository<Book, Integer> {

	Book findByLabel(String label);

}
