package tn.booky.corp;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.booky.corp.DAO.entities.Book;
import tn.booky.corp.services.BookService;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookyApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private BookService bookService;
	
	@Test
	public List<Book> testGetBooks(){
		return bookService.getBooks("");
	}
}
