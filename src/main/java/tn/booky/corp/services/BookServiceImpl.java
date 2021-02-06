package tn.booky.corp.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tn.booky.corp.DAO.entities.Book;
import tn.booky.corp.DAO.entities.Category;
import tn.booky.corp.DAO.entities.Charity;
import tn.booky.corp.DAO.entities.Customer;
import tn.booky.corp.DAO.entities.Donation;
import tn.booky.corp.DAO.entities.Event;
import tn.booky.corp.DAO.entities.Pack;
import tn.booky.corp.DAO.repositories.BookRepository;
import tn.booky.corp.DAO.repositories.CategoryRepository;
import tn.booky.corp.DAO.repositories.CharityRepository;
import tn.booky.corp.DAO.repositories.EventRepository;
import tn.booky.corp.DAO.repositories.PackRepository;
import tn.booky.corp.controllers.BookController;

/**
 * @author gharbimedaziz
 */
@Service
public class BookServiceImpl implements BookService {
	private static final Logger logger = LogManager.getLogger(BookController.class);
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	PackRepository packRepository;
	@Autowired
	CharityRepository charityRepository;
	@Autowired
	CustomerService customerService;
	@Autowired
	EventRepository eventRepository;
	@Autowired
	CategoryService categoryService;
	@Autowired
	EventService eventService;

	private int freeBookId;
	private double freeBookPrice;

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
		else {
			books = bookRepository.findAll();
		}
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

	public List<Book> getBooksHavingMostSelectedCategory() {
		return getBooksFilteredByCategories(categoryRepository.getMostSelectedCategory().getName());
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
		if (book == null) {
			logger.warn("No Book found");
		}
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
		if (b.getDescription() != null)
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

	
	public List<Book> getBooksFilteredByCategories(String categoriesList) {
		Set<Category> categories = new HashSet<>();
		String[] liStrings = categoriesList.split(" ");
		for (String xString : liStrings) {
			categories.add(categoryService.getCategoryByName(xString));
		}
		List<Book> books = bookRepository.findAll();
		List<Book> filteredBooks = new ArrayList<>();
		for (Book book : books) {
			for (Category category : book.getCategories()) {
				if (categories.contains(category)) {
					filteredBooks.add(book);
					break;
				}
			}
		}
		return filteredBooks;
	}

	public List<Book> showRelatedBooks() {
		Customer customer = customerService.getAuthenticatedCustomer();
		List<Book> selectedBooks = bookRepository.getSelectedBooksByCustomerOrdered(customer.getId());
		selectedBooks = selectedBooks.stream().limit(3).collect(Collectors.toList());
		for (Book book : selectedBooks) {
			logger.warn("selected book " + book.getLabel() + " with categories " + book.getCategories());
		}
		String categoriesList = "";
		for (Book book : selectedBooks) {
			Set<Category> categories = book.getCategories();
			for (Category category : categories) {
				if (!categoriesList.contains(category.getName()))
					categoriesList = categoriesList + " " + category.getName();
			}
		}
		categoriesList = categoriesList.substring(1);
		if (customer.getAge() <= 10 && !(categoriesList.contains("Kids")))
			categoriesList = categoriesList + " " + "Kids";
		else if (customer.getAge() > 10 && customer.getAge() <= 30 && !(categoriesList.contains("Action")))
			categoriesList = categoriesList + " " + "Action";
		else
			categoriesList = categoriesList + " " + "History";
		List<Book> relatedBooks = getBooksFilteredByCategories(categoriesList);
		if(customer.getAddress().contains("Tunis"))
			relatedBooks.addAll(getBooksFilteredByLanguages("ARABIC"));
		relatedBooks.removeAll(selectedBooks);
		return relatedBooks;
	}
	
	public Book openEventOnBook() {
		List<Book> books = bookRepository.getMostSelectedBook();
		Book exisitngBook= new Book();
		List<Book> books2 = books.stream().limit(1).collect(Collectors.toList());
		exisitngBook = books2.get(0);
		Event event = new Event();
		event.setDescription("Book " + exisitngBook.getLabel() + " Event");
		event.setBeginDate(new Date());
		eventService.addEvent(event);
		exisitngBook.setEvent(event);
		return bookRepository.save(exisitngBook);
	}

	public Book assignCharityToBook(Book b) {
		Book exisitngBook = bookRepository.findById(b.getId()).orElse(null);
		Charity existingCharity = charityRepository.findById(b.getCharity().getId()).orElse(null);
		exisitngBook.setCharity(existingCharity);
		return bookRepository.save(exisitngBook);
	}

	public Book unassignCharityFromBook(Book b) {
		Book existingBook = bookRepository.findById(b.getId()).orElse(null);
		existingBook.setCharity(null);
		return bookRepository.save(existingBook);
	}

	public List<String> getBooksLabelsByCharity(int charityId) {
		Charity existingCharity = charityRepository.findById(charityId).orElse(null);
		List<String> booksNames = new ArrayList<>();
		for (Book book : existingCharity.getBooks()) {
			booksNames.add(book.getLabel());
		}
		return booksNames;
	}

	public List<Donation> getDonationsByBookCharity(int bookId) {
		return bookRepository.getDonationsByBookCharity(bookId);
	}

	public double getTotalPriceByBook(int bookId) {
		return bookRepository.getTotalPriceByBook(bookId);
	}

	public List<Book> showRecommendedBooks() {
		Customer customer = customerService.getAuthenticatedCustomer();
		// CHECK INFO ABOUT THE CUSTOMER
		List<Book> books = new ArrayList<>();
		if (customer.getAge() <= 10)
			books = getBooksFilteredByCategories("Kids");
		else if (customer.getAge() > 10 && customer.getAge() <= 30)
			books = getBooksFilteredByCategories("Action Mystery Sci-Fi");
		else
			books = getBooksFilteredByCategories("History");
		return books;
	}

	// @Scheduled(fixedDelay = 86400000)
	public void giveawayFreeBook() {
		List<Book> books = getBooks("");
		int numberOfBooks = books.size();
		Random rand = new Random();
		int int_random = rand.nextInt(numberOfBooks);
		Book chosenBook = books.get(int_random);
		freeBookId = chosenBook.getId();
		freeBookPrice = chosenBook.getPrice();
		if (chosenBook.getPrice() != 0)
			chosenBook.setPrice(0);
		bookRepository.save(chosenBook);
		System.out.println("Updated the book with id " + chosenBook.getId() + " it is now free");
	}

	// @Scheduled(fixedRate = 86300000)
	public void endGiveAwayFreeBook() {
		Book chosenBook = getBookById(freeBookId);
		chosenBook.setPrice(freeBookPrice);
		bookRepository.save(chosenBook);
		System.out.println("Updated the book with id " + chosenBook.getId() + " it is not free anymore");
	}
	/*
	public void uploadFileToGoogleCloud(MultipartFile file) throws IOException {
		GoogleCloudFileUpload googleCloudFileUpload = new GoogleCloudFileUpload();
		String mediaURL = googleCloudFileUpload.upload(file);
		System.out.println("Image File upload to google cloud, the media URL " + mediaURL);
	}
	*/

}
