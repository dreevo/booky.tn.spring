package tn.booky.corp.DAO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.booky.corp.DAO.entities.Donation;

/**
 * @author Malek
 *
 */
public interface DonationRepository extends JpaRepository<Donation, Integer>{

}