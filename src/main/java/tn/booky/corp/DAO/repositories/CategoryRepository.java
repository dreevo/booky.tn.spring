package tn.booky.corp.DAO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.booky.corp.DAO.entities.Category;

/**
 * @author gharbimedaziz
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	Category findByName(String name);
}
