package tn.booky.corp.DAO.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.booky.corp.DAO.entities.Book;
import tn.booky.corp.DAO.entities.Donation;

/**
 * @author gharbimedaziz
 */

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	Book findByLabel(String label);

	@Query("SELECT B from Book B WHERE B.label LIKE %?1%")
	public List<Book> searchBooksByLabel(String keyword);
		
	@Query("SELECT DISTINCT D from Donation D join D.charity C join C.books B where B.id=?1")
	public List<Donation> getDonationsByBookCharity(int bookId);
	
	@Query("SELECT DISTINCT C.totalPrice from Cart C join C.cartItems CI join CI.book B where B.id=?1")
	public double getTotalPriceByBook(int bookId);
	
	@Query("SELECT B from Book B join B.cartItem CI where CI.quantity is (SELECT MAX(CI.quantity) as maximum from CI group by CI.book)")
	public Book getMostSelectedBook();
	
	@Query("SELECT B from Book B join B.cartItem CI join CI.cart C join C.customer CU where CU.id=?1 and CI.quantity in (SELECT quantity from CI ORDER BY quantity)")
	public List<Book> getMostSelectedBooksByCustomer(Long customerId);
}
