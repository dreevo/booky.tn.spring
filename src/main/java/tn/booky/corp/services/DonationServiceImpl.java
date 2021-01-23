package tn.booky.corp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.booky.corp.DAO.entities.Charity;
import tn.booky.corp.DAO.entities.Customer;
import tn.booky.corp.DAO.entities.Donation;
import tn.booky.corp.DAO.repositories.CharityRepository;
import tn.booky.corp.DAO.repositories.DonationRepository;

/**
 * @author Malek
 *
 */
@Service
public class DonationServiceImpl implements DonationService {
	@Autowired
	private DonationRepository donationRepository;
	@Autowired
	private CharityRepository charityRepository;

	@Override
	public Donation addDonation(Donation d) {
		Customer customer = new Customer(d.getCustomer().getId());
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
	public Donation getDonationByCustomer(Customer customer) {
		Optional<Donation> donation = donationRepository.findById(customer.getId());

		if (donation.isPresent()) {
			return donation.get();
		} else {
			return null;
		}
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

}
