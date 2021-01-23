package tn.booky.corp.DAO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.booky.corp.DAO.entities.Charity;

/**
 * @author Malek
 *
 */
public interface CharityRepository extends JpaRepository<Charity, Integer> {

}