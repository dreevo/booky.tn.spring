package tn.booky.corp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.booky.corp.DAO.entities.Book;
import tn.booky.corp.repositories.BookRepository;

/**
 * @author gharbimedaziz
 */
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepository;

	public Book saveBook(Book b) {
		return bookRepository.save(b);
	}

	public List<Book> saveBooks(List<Book> books) {
		return bookRepository.saveAll(books);
	}

	public List<Book> getBooks() {
		return bookRepository.findAll();
	}

	public Book getBookById(int id) {
		return bookRepository.findById(id).orElse(null);
	}

	public Book getBookByLabel(String label) {
		return bookRepository.findByLabel(label);
	}

	public String deleteBook(int id) {
		bookRepository.deleteById(id);
		return "Book with id " + id + " removed";
	}

	public Book updateBook(Book b) {
		Book existingBook = bookRepository.findById(b.getId()).orElse(null);
		existingBook.setLabel(b.getLabel());
		existingBook.setImageUrl(b.getImageUrl());
		existingBook.setInStock(b.isInStock());
		existingBook.setPrice(b.getPrice());
		existingBook.setRating(b.getRating());
		existingBook.setLanguage(b.getLanguage());
		return bookRepository.save(existingBook);
	}

}
