package tn.booky.corp.DAO.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.booky.corp.DAO.entities.Customer;
import tn.booky.corp.DAO.entities.Donation;

/**
 * @author Malek
 *
 */
public interface DonationRepository extends JpaRepository<Donation, Integer> {

	public List<Donation> findByCustomerId(Long customerId);
	
	@Query("SELECT D.message from Donation D where D.id=?1")
	public String getAllDonationMessages(int donationId);
	
	@Query("SELECT max(D.amount) from Donation D")
	public Double getHighestDonationRegistered();
	
	@Query("SELECT SUM(D.amount) from Donation D where FUNCTION('YEAR',current_date)=?1")
	public Double getTotalDonationsAmount(int year);
	
	@Query("SELECT C.firstname, C.lastname from Customer C join C.donations D where D.amount = (SELECT max(DON.amount) from Donation DON)")
	public String getCustomerWithHighestDonation();

	
}