package tn.booky.corp.services;

import java.util.List;

import tn.booky.corp.DAO.entities.Book;

/**
 * @author gharbimedaziz
 */
public interface BookService {
	public Book saveBook(Book b);

	public List<Book> saveBooks(List<Book> books);

	public List<Book> getBooks();

	public Book getBookById(int id);

	public Book getBookByLabel(String label);

	public String deleteBook(int id);

	public Book updateBook(Book b);
}
