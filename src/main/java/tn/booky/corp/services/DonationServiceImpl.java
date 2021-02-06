package tn.booky.corp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.booky.corp.DAO.entities.Charity;
import tn.booky.corp.DAO.entities.Customer;
import tn.booky.corp.DAO.entities.Donation;
import tn.booky.corp.DAO.repositories.BookRepository;
import tn.booky.corp.DAO.repositories.CharityRepository;
import tn.booky.corp.DAO.repositories.CustomerRepository;
import tn.booky.corp.DAO.repositories.DonationRepository;
import tn.booky.corp.controllers.BookController;
import tn.booky.corp.controllers.DonationController;

/**
 * @author Malek
 *
 */
@Service
public class DonationServiceImpl implements DonationService {
	private static final Logger logger = LogManager.getLogger(DonationController.class);

	@Autowired
	private DonationRepository donationRepository;
	@Autowired
	private CharityRepository charityRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired 
	private CustomerRepository customerRepository;

	@Override
	public Donation addDonation(Donation d) {
		Customer customer = customerRepository.findById(d.getCustomer().getId()).orElse(null);
		Charity charity = charityRepository.findById(d.getCharity().getId()).orElse(null);
		d.setCharity(charity);
		d.setCustomer(customer);
		return donationRepository.save(d);
	}

	@Override
	public String deleteDonation(int id) {
		Optional<Donation> donation = donationRepository.findById(id);

		if (donation.isPresent()) {
			donationRepository.deleteById(id);
			return "Donation deleted successfully";
		} else {
			return "No donation exist for given id";
		}
	}

	@Override
	public List<Donation> getDonationByCustomer(Customer customer) {
		List<Donation> donations = donationRepository.findByCustomerId(customer.getId());
		return donations;
	}

	@Override
	public List<Donation> getAllDonations() {
		List<Donation> donationList = donationRepository.findAll();

		if (donationList.size() > 0) {
			return donationList;
		} else {
			return new ArrayList<Donation>();
		}

	}

	@Override
	public Donation updateDonation(Donation d) {
		Optional<Donation> donation = donationRepository.findById(d.getId());

		if (donation.isPresent()) {
			Donation newD = donation.get();
			newD.setMessage(d.getMessage());
			newD.setCharity(d.getCharity());

			newD = donationRepository.save(newD);

			return newD;
		} else {
			d = donationRepository.save(d);

			return d;
		}
	}

	@Override
	public String deleteDonations() {
		donationRepository.deleteAll();
		return "All donations were deleted";
	}

	@Override
	public String getAllDonationMessages(int donationId) {
		return donationRepository.getAllDonationMessages(donationId);
	}

	@Override
	public Double getHighestDonationRegistered() {
		return donationRepository.getHighestDonationRegistered();
	}

	@Override
	public Double getTotalDonationsAmount(int year) {
		return donationRepository.getTotalDonationsAmount(year);
	}

	@Override
	public String getCustomerWithHighestDonation() {
		return donationRepository.getCustomerWithHighestDonation();
	}

}
