package tn.booky.corp.services;

import java.util.List;

import tn.booky.corp.DAO.entities.Customer;
import tn.booky.corp.DAO.entities.Donation;

/**
 * @author Malek
 *
 */
public interface DonationService {

	public Donation addDonation(Donation d);

	public String deleteDonation(int id);

	public List<Donation> getDonationByCustomer(Customer customer);

	public List<Donation> getAllDonations();

	public Donation updateDonation(Donation d);

	public String deleteDonations();

	public String getAllDonationMessages(int donationId);

	public Double getHighestDonationRegistered();

	public Double getTotalDonationsAmount(int year);

	public String getCustomerWithHighestDonation();

}
