package tn.booky.corp.DAO.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.booky.corp.DAO.entities.Book;
import tn.booky.corp.DAO.entities.CartItem;
@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
	
	@Query("select c from CartItem c join Book b on c.book.id = b.id where c.book.id = :bookid")
	public CartItem findByBook(@Param ("bookid")int Bookid);
	
	//@Query (value= "select * from cart_item WHERE cart_id= :cart_id", nativeQuery= true )
	//List<CartItem> getitemsbycat_id (@Param("cart_id") int cartid);
	@Query("select c from CartItem c WHERE c.id = ?1")
	List<CartItem> getitemsbycat_id (int cartid);
	
	
	//@Query (value= "select * from cart_item join t_book on cart_item.book_b_id=t_book.b_id group by book_b_id order by count(*) DESC LIMIT 5",nativeQuery= true )
	@Query ("select b from CartItem c join Book b on c.book.id = b.id group by b.id order by sum(c.quantity) DESC" )
    List<Book> gettopfiveofbooks();
	
	//@Query (value= "select * from cart_item join t_book on cart_item.book_b_id=t_book.b_id group by book_b_id order by count(*) ASC LIMIT 5",nativeQuery= true )
		@Query ("select b from CartItem c join Book b on c.book.id = b.id group by b.id order by sum(c.quantity) ASC" )
		List<Book> getworstfiveofbooks();
}