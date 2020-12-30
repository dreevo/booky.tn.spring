package tn.booky.corp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.booky.corp.DAO.entities.Pack;

/**
 * @author gharbimedaziz
 */
public interface PackRepository extends JpaRepository<Pack, Integer> {

	Pack findByLabel(String label);
}
