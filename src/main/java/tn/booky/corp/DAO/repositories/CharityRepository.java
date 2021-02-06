package tn.booky.corp.DAO.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.booky.corp.DAO.entities.Book;
import tn.booky.corp.DAO.entities.Charity;

/**
 * @author Malek
 *
 */
public interface CharityRepository extends JpaRepository<Charity, Integer> {
	
	@Query("SELECT B.label from Book B join B.charity C where C.id=?1")
	public String getBookRelatedToACharity(int charityId);
	
	@Query("SELECT B.label from Book B join B.charity C where C.id IS NOT NUL")
	public List<String> getBooksRelatedToCharities();
	
	@Query("SELECT C.title from Charity C order by C.title")
	public List<String> getCharityTitles();
	
	@Query("SELECT C.title from Charity C join C.donations D where D.amount in (SELECT max(DON.amount) from Donation DON)")
	public List<String> getCharityWithHighestDonor();
	
	@Query("SELECT C from Charity C join C.donations D where SUM(D.amount) in (SELECT max(DON.amount) from Donation DON) group by C.id")
	public List<Charity> getCharityWithHighestTotalDonations();

}