package tn.booky.corp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.booky.corp.DAO.entities.Charity;
import tn.booky.corp.DAO.repositories.CharityRepository;

/**
 * @author Malek
 *
 */
@Service
public class CharityServiceImpl implements CharityService {
	@Autowired
	private CharityRepository charityRepository;

	@Override
	public Charity addCharity(Charity ch) {
		return charityRepository.save(ch);
	}

	@Override
	public String deleteCharityById(int id) {

		Optional<Charity> charity = charityRepository.findById(id);

		if (charity.isPresent()) {
			charityRepository.deleteById(id);
			return "Charity deleted successfully";
		} else {
			return "No charity exist for given id";
		}
	}

	@Override
	public List<Charity> getAllCharities() {
		List<Charity> charityList = charityRepository.findAll();

		if (charityList.size() > 0) {
			return charityList;
		} else {
			return new ArrayList<Charity>();
		}

	}

	@Override
	public Charity updateCharity(Charity ch) {
		Optional<Charity> charity = charityRepository.findById(ch.getId());

		if (charity.isPresent()) {
			Charity newCh = charity.get();
			newCh.setTitle(ch.getTitle());
			newCh.setDescription(ch.getDescription());
			newCh.setDonations(ch.getDonations());
			newCh.setImageUrl(ch.getImageUrl());
			newCh.setBooks(ch.getBooks());
			newCh = charityRepository.save(newCh);

			return newCh;
		} else {
			ch = charityRepository.save(ch);

			return ch;
		}
	}

	@Override
	public Charity getCharityById(int id) {

		Optional<Charity> charity = charityRepository.findById(id);

		if (charity.isPresent()) {
			return charity.get();
		} else {
			return null;
		}
	}

	@Override
	public String deleteCharities() {

		charityRepository.deleteAll();
		return "All charities were deleted";
	}
}
