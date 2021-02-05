package tn.booky.corp.DAO.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.booky.corp.DAO.entities.Pack;

/**
 * @author gharbimedaziz
 */
public interface PackRepository extends JpaRepository<Pack, Integer> {

	Pack findByLabel(String label);
	
	@Query("SELECT P from Pack P WHERE P.label LIKE %?1%")
	public List<Pack> searchPacksByLabel(String keyword);
}
