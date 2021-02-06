package tn.booky.corp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.config.CustomRepositoryImplementationDetector;
import org.springframework.stereotype.Service;

import tn.booky.corp.DAO.entities.Customer;
import tn.booky.corp.DAO.entities.Exchange;
import tn.booky.corp.DAO.repositories.CustomerRepository;
import tn.booky.corp.DAO.repositories.ExchangeRepository;
import tn.booky.corp.controllers.BookController;
import tn.booky.corp.controllers.ExchangeController;

/**
 * @author Malek
 *
 */
@Service
public class ExchangeServiceImpl implements ExchangeService {

	private static final Logger logger = LogManager.getLogger(ExchangeController.class);

	@Autowired
	private ExchangeRepository exchangeRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Exchange createExchange(Exchange ex) {
		return exchangeRepository.save(ex);
	}

	@Override
	public String deleteExchange(int id) {
		Optional<Exchange> exchange = exchangeRepository.findById(id);

		if (exchange.isPresent()) {
			exchangeRepository.deleteById(id);
			return "Exchange deleted successfully";
		} else {
			return "No exchange exist for given id";
		}
	}

	@Override
	public Exchange getExchangeByIdReciever(int idReciever) {
		Optional<Exchange> exchange = exchangeRepository.findById(idReciever);
		if(customerRepository.findById((long) idReciever) != null){

		if (exchange.isPresent()) {
			return exchange.get();
		} else {
			return null;
		}
		}
		return null;

	}

	@Override
	public Exchange getExchangeByIdGiver(int idGiver) {
		Optional<Exchange> exchange = exchangeRepository.findById(idGiver);
		if(customerRepository.findById((long) idGiver) != null){
		if (exchange.isPresent()) {
			return exchange.get();
		} else {
			return null;
		}
		}
		return null;
	}

	@Override
	public List<Exchange> getAllExchanges() {
		List<Exchange> exchangeList = exchangeRepository.findAll();

		if (exchangeList.size() > 0) {
			return exchangeList;
		} else {
			return new ArrayList<Exchange>();
		}

	}

	@Override
	public Exchange updateExchange(Exchange ex) {
		Optional<Exchange> exchange = exchangeRepository.findById(ex.getId());

		if (exchange.isPresent()) {
			Exchange newEx = exchange.get();
			newEx.setExchangeDescription(ex.getExchangeDescription());

			newEx = exchangeRepository.save(newEx);

			return newEx;
		} else {
			ex = exchangeRepository.save(ex);

			return ex;
		}
	}

	@Override
	public String deleteExchanges() {
		exchangeRepository.deleteAll();
		return "All exchanges were deleted";
	}

	@Override
	public List<Customer> getAllRecievers() {
		return exchangeRepository.getAllRecievers();
	}

	@Override
	public List<Customer> getAllGivers() {
		return exchangeRepository.getAllGivers();
	}

	@Override
	public int countOffersOfExchange() {
		return exchangeRepository.countOffersOfExchange();
	}

	@Override
	public int countFinishedOffersOfExchange() {
		return exchangeRepository.countFinishedOffersOfExchange();
	}

	@Override
	public String getPourcentageOfFinishedOffers() {
		int totalOffers = exchangeRepository.countOffersOfExchange();
		int finishedOffers = exchangeRepository.countFinishedOffersOfExchange();
		double pourcentage = ((double)finishedOffers/(double)totalOffers)*100;
		
		return pourcentage +" %";
	}
}
