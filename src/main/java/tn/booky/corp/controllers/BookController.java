package tn.booky.corp.controllers;

import java.io.IOException;
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
import tn.booky.corp.services.AuthorService;
import tn.booky.corp.services.BookService;
import tn.booky.corp.services.UploadToCloudinary;;

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
	private AuthorService authorService;

	@PostMapping("/addBook")
	public Book addBook(@RequestBody Book b) {
		System.out.println(b);
		b.setAuthor(authorService.getAuthorByEmail(b.getAuthor().getEmail()));
		UploadToCloudinary uploadToCloudinary = new UploadToCloudinary();
		try {
			uploadToCloudinary.uploadImage(b.getImageUrl());
		} catch (IOException e) {
			// TODO: handle exception
		}

		return bookService.saveBook(b);
	}

	@PostMapping("/addBooks")
	public List<Book> addBooks(@RequestBody List<Book> books) {
		return bookService.saveBooks(books);
	}

	@GetMapping("/getBooks")
	public List<Book> findAllBooks(@Param("keyword") String keyword) {
		return bookService.getBooks(keyword);
	}

	@GetMapping("/sortLabel/{ord}")
	public List<Book> findAllBooksSortedByLabel(@PathVariable int ord) {
		if (ord == 1)
			return bookService.getBooksSortedByLabelASC();
		else
			return bookService.getBooksSortedByLabelDESC();
	}

	@GetMapping("sortPrice/{ord}")
	public List<Book> findAllBooksSortedByPrice(@PathVariable int ord) {
		if (ord == 1)
			return bookService.getBooksSortedByPriceASC();
		else
			return bookService.getBooksSortedByPriceDESC();
	}

	@GetMapping("/categories/{names}")
	public List<Book> findAllBooksFilteredByCategories(@Param("names") String names) {
		return bookService.getBooksFilteredByCategories(names);
	}

	@GetMapping("/languages")
	public List<Book> findAllBooksFilteredByLanguages(@Param("names") String names) {
		return bookService.getBooksFilteredByLanguages(names);
	}

	@GetMapping("/minPrice/{min}")
	public List<Book> findAllBooksFilteredByMinPrice(@PathVariable double min) {
		return bookService.getBooksFilteredByMinPrice(min);
	}

	@GetMapping("/maxPrice/{max}")
	public List<Book> findAllBooksFilteredByMaxPrice(@PathVariable double max) {
		return bookService.getBooksFilteredByMaxPrice(max);
	}

	@GetMapping("/price")
	public List<Book> findAllBooksFilteredByPrice(@Param("min") double min, @Param("max") double max) {
		return bookService.getBooksFilteredByMinMaxPrice(min, max);
	}

	@GetMapping("/{id}")
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

	@PutMapping("/assignCharity")
	public Book assignCharityToBook(@RequestBody Book b) {
		return bookService.assignCharityToBook(b);
	}

	@PutMapping("/unassignCharity")
	public Book unassignCharityFromBook(@RequestBody Book b) {
		return bookService.unassignCharityFromBook(b);
	}

	@GetMapping("/charity/{id}")
	public List<String> getBooksByCharity(@PathVariable int id) {
		return bookService.getBooksLabelsByCharity(id);
	}

	@GetMapping("/charity/donations/{id}")
	public List<Donation> getDonationsByBookCharity(@PathVariable int id) {
		return bookService.getDonationsByBookCharity(id);
	}

	@GetMapping("/cartTotal/{id}")
	public double getAverageTotalPriceByBook(@PathVariable int id) {
		return bookService.getTotalPriceByBook(id);
	}

	@GetMapping("/related")
	public List<Book> getRelatedBooks() {
		return bookService.showRelatedBooks();
	}

	@GetMapping("/bookEvent")
	public Book openEventOnMostSelectedBook() {
		return bookService.openEventOnBook();
	}
}
