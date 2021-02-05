package tn.booky.corp.DAO.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.booky.corp.DAO.entities.Book;
import tn.booky.corp.DAO.entities.CartItem;
	
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
	public CartItem findByBook(Book b);
	
	@Query (value= "select * from cart_item WHERE cart_id= :cart_id", nativeQuery= true )
	List<CartItem> getitemsbycat_id (@Param("cart_id") int cartid);
	
	
	@Query (value= "select * from cart_item join t_book on cart_item.book_b_id=t_book.b_id group by book_b_id order by count(*) ASC LIMIT 5",nativeQuery= true )
	List<Book> getworstfiveofbooks();
	
	@Query ("select c from CartItem c join Book b group by c.id order by count(c.id)" )
	List<Book> gettopfiveofbooks();
}