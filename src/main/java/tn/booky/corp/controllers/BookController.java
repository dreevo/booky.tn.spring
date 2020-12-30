package tn.booky.corp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.booky.corp.DAO.entities.Book;
import tn.booky.corp.services.BookService;;

/**
 * @author gharbimedaziz
 */
@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
	@PostMapping("/addBook")
	public Book addBook(@RequestBody Book b){
		return bookService.saveBook(b);
	}
	
	@PostMapping("/addBooks")
	public List<Book> addBooks(@RequestBody List<Book> books){
		return bookService.saveBooks(books);
	}
	
	@GetMapping("/books")
	public List<Book> findAllBooks(){
		return bookService.getBooks();
	}
	
	@GetMapping("/book/{id}")
	public Book getBookById(@PathVariable int id){
		return bookService.getBookById(id);
	}
	
	@GetMapping("/bookLabel/{label}")
	public Book getBookByLabel(@PathVariable String label){
		return bookService.getBookByLabel(label);
	}
	
	@PutMapping("/updateBook")
	public Book updateBook(@RequestBody Book b){
		return bookService.updateBook(b);
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable int id){
		return bookService.deleteBook(id);
	}
}
