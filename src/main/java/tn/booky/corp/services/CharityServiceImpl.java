package tn.booky.corp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.booky.corp.DAO.entities.Charity;
import tn.booky.corp.DAO.repositories.BookRepository;
import tn.booky.corp.DAO.repositories.CharityRepository;
import tn.booky.corp.controllers.BookController;
import tn.booky.corp.controllers.CharityController;

/**
 * @author Malek
 *
 */
@Service
public class CharityServiceImpl implements CharityService {
	private static final Logger logger = LogManager.getLogger(CharityController.class);

	@Autowired
	private CharityRepository charityRepository;

	@Autowired
	private BookRepository bookRepository;
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

	@Override
	public String getBookRelatedToACharity(int charityId) {
		return charityRepository.getBookRelatedToACharity(charityId);
	}

	@Override
	public List<String> getCharityTitles() {
		return charityRepository.getCharityTitles();
	}

	@Override
	public String getCharityWithHighestDonor() {
		return charityRepository.getCharityWithHighestDonor().stream().limit(1).collect(Collectors.toList()).get(0);
	}

	//To be completed
	@Override
	public Charity getCharityWithHighestTotalDonations() {
		return charityRepository.getCharityWithHighestTotalDonations().stream().limit(1).collect(Collectors.toList()).get(0);
	}

	@Override
	public List<String> getBooksRelatedToCharities() {
		return charityRepository.getBooksRelatedToCharities();
	}
}
