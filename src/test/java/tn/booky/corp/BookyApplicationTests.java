package tn.booky.corp;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.booky.corp.DAO.entities.Book;
import tn.booky.corp.DAO.entities.Pack;
import tn.booky.corp.services.BookService;
import tn.booky.corp.services.PackService;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookyApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private BookService bookService;
	@Autowired
	private PackService packService;
	
	@Test
	public List<Book> testGetBooks(){
		System.out.println(bookService.getBooks(""));
		return bookService.getBooks("");
	}
	
	@Test
	public List<Pack> testGetPacks(){
		System.out.println(packService.getPacks(""));
		return packService.getPacks("");
	}
}
