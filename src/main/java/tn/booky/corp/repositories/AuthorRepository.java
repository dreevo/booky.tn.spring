package tn.booky.corp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.booky.corp.DAO.entities.Author;

/**
 * @author gharbimedaziz
 */
public interface AuthorRepository extends JpaRepository<Author, Integer> {
	Author findByEmail(String email);
}
