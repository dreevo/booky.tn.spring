package tn.booky.corp.services;

import java.util.List;
import tn.booky.corp.DAO.entities.Book;

/**
 * @author gharbimedaziz
 */
public interface BookService {
	public Book saveBook(Book b);

	public List<Book> saveBooks(List<Book> books);

	public List<Book> getBooks(String keyword);

	public List<Book> getBooksSortedByLabelASC();

	public List<Book> getBooksSortedByLabelDESC();

	public List<Book> getBooksSortedByPriceASC();

	public List<Book> getBooksSortedByPriceDESC();

	public List<Book> getBooksFilteredByCategories(String categoriesList);

	public List<Book> getBooksFilteredByLanguages(String languagesList);

	public List<Book> getBooksFilteredByMinPrice(double minPrice);

	public List<Book> getBooksFilteredByMaxPrice(double maxPrice);
	
	public List<Book> getBooksFilteredByMinMaxPrice(double minPrice, double maxPrice);

	public Book getBookById(int id);

	public Book getBookByLabel(String label);

	public String deleteBook(int id);

	public String updateBook(Book b);
}
