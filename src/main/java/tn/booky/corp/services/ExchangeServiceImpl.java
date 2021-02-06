package tn.booky.corp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.booky.corp.DAO.entities.Exchange;
import tn.booky.corp.DAO.repositories.ExchangeRepository;

/**
 * @author Malek
 *
 */
@Service
public class ExchangeServiceImpl implements ExchangeService {

	@Autowired
	private ExchangeRepository exchangeRepository;

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

	// missing treatment to check if the idReciever matches any id of customer
	@Override
	public Exchange getExchangeByIdReciever(int idReciever) {
		Optional<Exchange> exchange = exchangeRepository.findById(idReciever);

		if (exchange.isPresent()) {
			return exchange.get();
		} else {
			return null;
		}

	}

	// missing treatment to check if the idGiver matches any id of customer
	@Override
	public Exchange getExchangeByIdGiver(int idGiver) {
		Optional<Exchange> exchange = exchangeRepository.findById(idGiver);

		if (exchange.isPresent()) {
			return exchange.get();
		} else {
			return null;
		}
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
}
