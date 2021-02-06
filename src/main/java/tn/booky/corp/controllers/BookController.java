package tn.booky.corp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.booky.corp.DAO.entities.Book;
import tn.booky.corp.DAO.entities.Donation;
import tn.booky.corp.DAO.repositories.BookRepository;
import tn.booky.corp.services.BookService;;

/**
 * @author gharbimedaziz
 */
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;
	@Autowired
	private BookRepository bookRepository;
	
	@PostMapping("/addBook")
	public Book addBook(@RequestBody Book b) {
		System.out.println(b);
		return bookService.saveBook(b);
	}

	@PostMapping("/addBooks")
	public List<Book> addBooks(@RequestBody List<Book> books) {
		return bookService.saveBooks(books);
	}

	@GetMapping("/books")
	public List<Book> findAllBooks(@Param("keyword") String keyword) {
		return bookService.getBooks(keyword);
	}

	@GetMapping("/books/sortLabel/{ord}")
	public List<Book> findAllBooksSortedByLabel(@PathVariable int ord) {
		if (ord == 1)
			return bookService.getBooksSortedByLabelASC();
		else
			return bookService.getBooksSortedByLabelDESC();
	}

	@GetMapping("/books/sortPrice/{ord}")
	public List<Book> findAllBooksSortedByPrice(@PathVariable int ord) {
		if (ord == 1)
			return bookService.getBooksSortedByPriceASC();
		else
			return bookService.getBooksSortedByPriceDESC();
	}

	@GetMapping("/books/categories/{names}")
	public List<Book> findAllBooksFilteredByCategories(@Param("names") String names) {
		return bookService.getBooksFilteredByCategories(names);
	}

	@GetMapping("/books/languages")
	public List<Book> findAllBooksFilteredByLanguages(@Param("names") String names) {
		return bookService.getBooksFilteredByLanguages(names);
	}
	
	@GetMapping("/books/minPrice/{min}")
	public List<Book> findAllBooksFilteredByMinPrice(@PathVariable double min) {
			return bookService.getBooksFilteredByMinPrice(min);
	}
	
	@GetMapping("/books/maxPrice/{max}")
	public List<Book> findAllBooksFilteredByMaxPrice(@PathVariable double max) {
			return bookService.getBooksFilteredByMaxPrice(max);
	}

	@GetMapping("/books/price")
	public List<Book> findAllBooksFilteredByPrice(@Param("min") double min,
			@Param("max") double max) {
			return bookService.getBooksFilteredByMinMaxPrice(min, max);
	}

	@GetMapping("/book/{id}")
	public Book getBookById(@PathVariable int id) {

		return bookService.getBookById(id);
	}

	@GetMapping("/bookLabel/{label}")
	public Book getBookByLabel(@PathVariable String label) {
		return bookService.getBookByLabel(label);
	}

	@PutMapping("/updateBook")
	public String updateBook(@RequestBody Book b) {
		return bookService.updateBook(b);
	}

	@DeleteMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable int id) {
		return bookService.deleteBook(id);
	}
	
	@PutMapping("/books/assignCharity")
	public Book assignCharityToBook(@RequestBody Book b){
		return bookService.assignCharityToBook(b);
	}
	
	@PutMapping("/books/unassignCharity")
	public Book unassignCharityFromBook(@RequestBody Book b){
		return bookService.unassignCharityFromBook(b);
	}
	
	@GetMapping("/books/charity/{id}")
	public List<String> getBooksByCharity(@PathVariable int id){
		return bookService.getBooksLabelsByCharity(id);
	}
	
	@GetMapping("/books/charity/donations/{id}")
	public List<Donation> getDonationsByBookCharity(@PathVariable int id){
		return bookService.getDonationsByBookCharity(id);
	}
	
	@GetMapping("/books/cartTotal/{id}")
	public double getAverageTotalPriceByBook(@PathVariable int id){
		return bookService.getTotalPriceByBook(id);
	}
	
	@GetMapping("/books/mostSelected")
	public List<Book> getMostSelectedBook(){
		return bookRepository.getMostSelectedBook();
	}
}
