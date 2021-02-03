package tn.booky.corp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.booky.corp.DAO.entities.Exchange;
import tn.booky.corp.services.ExchangeService;

@RestController
public class ExchangeController {
	@Autowired
	private ExchangeService exchangeService;

	@PostMapping("/createExchange")
	public Exchange createExchange(@RequestBody Exchange ex) {
		return exchangeService.createExchange(ex);
	}

	@DeleteMapping("/deleteExchange/{id}")
	public String deleteExchange(@PathVariable int id) {
		return exchangeService.deleteExchange(id);
	}

	@DeleteMapping("/deleteExchanges")
	public String deleteExchanges() {
		return exchangeService.deleteExchanges();
	}

	// A verifier
	@GetMapping("/getExchangeByIdReciever/{id}")
	public Exchange getExchangeByIdReciever(@PathVariable int idReciever) {

		return exchangeService.getExchangeByIdReciever(idReciever);

	}

	// A verifier
	@GetMapping("/getExchangeByIdGiver/{id}")
	public Exchange getExchangeByIdGiver(@PathVariable int idGiver) {

		return exchangeService.getExchangeByIdGiver(idGiver);

	}

	@GetMapping("/getAllExchanges")
	public List<Exchange> getAllExchanges() {
		return exchangeService.getAllExchanges();
	}

	@PutMapping("/updateExchange")
	public Exchange createOrUpdateExchange(@RequestBody Exchange ex) {
		return exchangeService.updateExchange(ex);
	}

}
