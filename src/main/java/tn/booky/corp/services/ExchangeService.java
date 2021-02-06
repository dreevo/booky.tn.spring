package tn.booky.corp.services;

import java.util.List;

import tn.booky.corp.DAO.entities.Exchange;

/**
 * @author Malek
 *
 */
public interface ExchangeService {

	public Exchange createExchange(Exchange ex);

	public String deleteExchange(int id);

	public Exchange getExchangeByIdReciever(int idReciever);

	public Exchange getExchangeByIdGiver(int idGiver);

	public List<Exchange> getAllExchanges();

	public Exchange updateExchange(Exchange ex);

	public String deleteExchanges();
}
