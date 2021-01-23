package tn.booky.corp.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import tn.booky.corp.DAO.entities.Book;
import tn.booky.corp.DAO.entities.Category;
import tn.booky.corp.DAO.entities.Charity;
import tn.booky.corp.DAO.entities.Donation;
import tn.booky.corp.DAO.entities.Pack;
import tn.booky.corp.DAO.repositories.BookRepository;
import tn.booky.corp.DAO.repositories.CategoryRepository;
import tn.booky.corp.DAO.repositories.CharityRepository;
import tn.booky.corp.DAO.repositories.PackRepository;

/**
 * @author gharbimedaziz
 */
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	PackRepository packRepository;
	@Autowired 
	CharityRepository charityRepository;

	public Book saveBook(Book b) {
		return bookRepository.save(b);
	}

	public List<Book> saveBooks(List<Book> books) {
		return bookRepository.saveAll(books);
	}

	public List<Book> getBooks(String keyword) {
		List<Book> books = new ArrayList<>();
		if (keyword != null)
			books = bookRepository.searchBooksByLabel(keyword);
		else
			books = bookRepository.findAll();
		return books;
	}

	public List<Book> getBooksSortedByLabelASC() {
		List<Book> books = bookRepository.findAll(Sort.by(Sort.Direction.ASC, "label"));
		return books;
	}

	public List<Book> getBooksSortedByLabelDESC() {
		List<Book> books = bookRepository.findAll(Sort.by(Sort.Direction.DESC, "label"));
		return books;
	}

	public List<Book> getBooksSortedByPriceASC() {
		List<Book> books = bookRepository.findAll(Sort.by(Sort.Direction.ASC, "price"));
		return books;
	}

	public List<Book> getBooksSortedByPriceDESC() {
		List<Book> books = bookRepository.findAll(Sort.by(Sort.Direction.DESC, "price"));
		return books;
	}

	public List<Book> getBooksFilteredByCategories(String categoriesList) {
		Set<Category> categories = new HashSet<>();
		String[] liStrings = categoriesList.split(" ");
		for (String xString : liStrings) {
			categories.add(new Category(1, xString));
		}
		List<Book> books = bookRepository.findAll();
		return books.stream().filter(b -> b.getCategories().containsAll(categories)).collect(Collectors.toList());
	}

	public List<Book> getBooksFilteredByLanguages(String languagesList) {
		List<Book> books = bookRepository.findAll();
		return books.stream().filter(b -> languagesList.contains(b.getLanguage().toString()))
				.collect(Collectors.toList());
	}

	public List<Book> getBooksFilteredByMinPrice(double minPrice) {
		List<Book> books = bookRepository.findAll();
		return books.stream().filter(b -> (int) b.getPrice() >= (int) minPrice).collect(Collectors.toList());
	}

	public List<Book> getBooksFilteredByMaxPrice(double maxPrice) {
		List<Book> books = bookRepository.findAll();
		return books.stream().filter(b -> (int) b.getPrice() <= (int) maxPrice).collect(Collectors.toList());
	}

	public List<Book> getBooksFilteredByMinMaxPrice(double minPrice, double maxPrice) {
		List<Book> books = bookRepository.findAll();
		return books.stream()
				.filter(b -> ((int) b.getPrice() <= (int) maxPrice) && ((int) b.getPrice() >= (int) minPrice))
				.collect(Collectors.toList());
	}

	public Book getBookById(int id) {
		Book book = bookRepository.findById(id).orElse(null);
		return book;
	}

	public Book getBookByLabel(String label) {
		Book book = bookRepository.findByLabel(label);
		return book;
	}

	public String deleteBook(int id) {
		bookRepository.deleteById(id);
		return "Book with id " + id + " removed";
	}

	public String updateBook(Book b) {
		Book existingBook = bookRepository.findById(b.getId()).orElse(null);
		if (b.getLabel() != null)
			existingBook.setLabel(b.getLabel());
		if (b.getImageUrl() != null)
			existingBook.setImageUrl(b.getImageUrl());
		if (existingBook.isInStock() != b.isInStock())
			existingBook.setInStock(b.isInStock());
		if (b.getPrice() != 0)
			existingBook.setPrice(b.getPrice());
		if (b.getRating() != 0)
			existingBook.setRating(b.getRating());
		if (b.getLanguage() != null)
			existingBook.setLanguage(b.getLanguage());
		if(b.getDescription() != null)
			existingBook.setDescription(b.getDescription());
		if (b.getCategories().size() != 0) {
			Set<Category> categories = b.getCategories();
			for (Category category : categories) {
				category.setId(categoryRepository.findByName(category.getName()).getId());
			}
			existingBook.setCategories(categories);
		}
		if (b.getPack() != null) {
			Pack searchPack = packRepository.findByLabel(b.getPack().getLabel());
			existingBook.setPack(searchPack);
		}

		bookRepository.save(existingBook);
		return "Book with id " + b.getId() + " update.";
	}
	
	// ------- PUSHED REQUESTS  ------- \\
	// CHARITY 
	public Book assignCharityToBook(Book b){
		Book exisitngBook = bookRepository.findById(b.getId()).orElse(null);
		Charity existingCharity = charityRepository.findById(b.getCharity().getId()).orElse(null);
		exisitngBook.setCharity(existingCharity);
		return bookRepository.save(exisitngBook);
	}
	
	public Book unassignCharityFromBook(Book b){
		Book existingBook = bookRepository.findById(b.getId()).orElse(null);
		existingBook.setCharity(null);
		return bookRepository.save(existingBook);
	}
	
	public List<String> getBooksLabelsByCharity(int charityId){
		Charity existingCharity = charityRepository.findById(charityId).orElse(null);
		List<String> booksNames = new ArrayList<>();
		for(Book book : existingCharity.getBooks()){
			booksNames.add(book.getLabel());
		}
		return booksNames;
	}
	
	public List<Donation> getDonationsByBookCharity(int bookId){
		return bookRepository.getDonationsByBookCharity(bookId);
	}
	
	public double getTotalPriceByBook(int bookId){
		return bookRepository.getTotalPriceByBook(bookId);
	}
	
	public Book getMostSelectedBook(){
		return bookRepository.getMostSelectedBook();
	}

}