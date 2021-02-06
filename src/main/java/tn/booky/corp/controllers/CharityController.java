package tn.booky.corp.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.booky.corp.DAO.entities.Book;
import tn.booky.corp.DAO.entities.Charity;
import tn.booky.corp.DAO.repositories.BookRepository;
import tn.booky.corp.services.BookService;
import tn.booky.corp.services.CartItemService;
import tn.booky.corp.services.CharityService;

/**
 * @author Malek
 *
 */
@RestController
@RequestMapping("/rest/charity")
public class CharityController {

	@Autowired
	private CharityService charityService;
	@Autowired
	private BookService bookService;
	@Autowired
	private CartItemService cartItemService;
	@Autowired
	private BookRepository bookRepository;

	// Crud
	@PostMapping("/addCharity")
	public Charity addCharity(@RequestBody Charity ch) {
		return charityService.addCharity(ch);
	}

	@DeleteMapping("/deleteCharityById/{id}")
	public String deleteCharityById(@PathVariable int id) {
		return charityService.deleteCharityById(id);
	}

	@DeleteMapping("/deleteCharities")
	public String deleteCharities() {
		return charityService.deleteCharities();
	}

	@GetMapping("/getCharityById/{id}")
	public Charity getCharityById(@PathVariable int id) {
		return charityService.getCharityById(id);
	}

	@GetMapping("/charities")
	public List<Charity> getAllCharities() {
		return charityService.getAllCharities();
	}

	@PutMapping("/updateCharity")
	public Charity updateCharity(@RequestBody Charity ch) {
		return charityService.updateCharity(ch);
	}

	// Pushed requests
	@GetMapping("/getBookRelatedToACharity/{charityId}")
	public String getBookRelatedToACharity(@PathVariable int charityId) {
		return charityService.getBookRelatedToACharity(charityId);
	}

	@GetMapping("/getCharityTitles")
	public List<String> getCharityTitles() {
		return charityService.getCharityTitles();
	}

	@GetMapping("/getCharityWithHighestDonor")
	public String getCharityWithHighestDonor() {
		return charityService.getCharityWithHighestDonor();
	}

	@GetMapping("/getCharityWithHighestTotalDonations")
	public Charity getCharityWithHighestTotalDonations() {
		return charityService.getCharityWithHighestTotalDonations();
	}

	@GetMapping("/getBooksRelatedToCharities")
	public List<String> getBooksRelatedToCharities() {
		return charityService.getBooksRelatedToCharities();
	}

	// Methods consuming other services

	@PutMapping("/assignToCharityMostSelectedBook")
	public Book assignToCharityMostSelectedBook() {
		List<Book> book =bookRepository.getMostSelectedBook();
		Book exisitingBook= new Book();
		  List<Book> books2 = book.stream().limit(1).collect(Collectors.toList());
	        exisitingBook = books2.get(0);
		Charity charity = new Charity();
        charity.setDescription("This is the most selected book charity");
        charity.setTitle("Charity Of the Most Selected Book");
        charity = charityService.addCharity(charity);
        exisitingBook.setCharity(charity);
        return bookRepository.save(exisitingBook);
		
	}

	@PutMapping("/assignToCharityMostSelectedBookByCustomer")
	public Book assignToCharityMostSelectedBookByCustomer() {
		List<Book> books = bookRepository.getSelectedBooksByCustomerOrdered(1L);
		Book exisitingBook= new Book();
		  List<Book> books2 = books.stream().limit(1).collect(Collectors.toList());
	        exisitingBook = books2.get(0);
		Charity charity = new Charity();
      charity.setDescription("This is the most selected book charity");
      charity.setTitle("Charity Of the Most Selected Book");
      charity = charityService.addCharity(charity);
      exisitingBook.setCharity(charity);
      return bookRepository.save(exisitingBook);
		/*for (Book book : books) {
			return bookService.assignCharityToBook(book);
		}
		*/
		
	}

	@PutMapping("/assignToCharityTopFiveBooks")
	public void assignToCharityTopFiveBooks() {
		List<Book> books = cartItemService.gettopfiveofbooks();
		for (Book book : books) {
			if (book.isInStock() == true) {
				List<String> bookLabels = charityService.getBooksRelatedToCharities();
				if (!bookLabels.contains(book.getLabel())) {
					bookService.assignCharityToBook(book);
				}
			}
		}
	}
	@PutMapping("/unassignCharityFromBook")
	public void unassignCharityFromBook(){
		List<Book> books = cartItemService.getwortfiveofbooks();
		for(Book book : books){
			List<String> bookLabels = charityService.getBooksRelatedToCharities();
				if(bookLabels.contains(book.getLabel())){
					bookService.unassignCharityFromBook(book);
				}
			}
		}
	
	}
	

