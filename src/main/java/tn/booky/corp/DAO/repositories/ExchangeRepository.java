package tn.booky.corp.DAO.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.booky.corp.DAO.entities.Exchange;
import tn.booky.corp.DAO.entities.Customer;


/**
 * @author Malek
 *
 */
public interface ExchangeRepository extends JpaRepository<Exchange, Integer> {

	@Query("SELECT C from Customer C join C.recieverExchange EX order by C.firstname")
	public List<Customer> getAllRecievers();
	
	@Query("SELECT C from Customer C join C.giverExchange EX order by C.firstname")
	public List<Customer> getAllGivers();
	
	@Query("SELECT count(*) from Exchange EX")
	public int countOffersOfExchange();
	
	@Query("SELECT count(*) from Exchange EX where EX.exchangeStatus like '%Finished%'")
	public int countFinishedOffersOfExchange();
	
}
