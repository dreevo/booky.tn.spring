package tn.booky.corp.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.booky.corp.DAO.entities.Author;
import tn.booky.corp.DAO.entities.Book;
import tn.booky.corp.DAO.entities.Customer;
import tn.booky.corp.DAO.repositories.AuthorRepository;
import tn.booky.corp.DAO.repositories.BookRepository;

/**
 * @author gharbimedaziz
 */
@Service
public class AuthorServiceImpl implements AuthorService {
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private BookRepository bookRepository;

	public Author saveAuthor(Author a) {
		return authorRepository.save(a);
	}

	public List<Author> saveAuthors(List<Author> authors) {
		return authorRepository.saveAll(authors);
	}

	public List<Author> getAuthors() {
		return authorRepository.findAll();
	}

	public Author getAuthorById(int id) {
		return authorRepository.findById(id).orElse(null);
	}

	public Author getAuthorByEmail(String email) {
		return authorRepository.findByEmail(email);
	}

	public String deleteAuthor(int id) {
		authorRepository.deleteById(id);
		return "Author with id " + id + " removed";
	}

	public Author updateAuthor(Author a) {
		Author existingAuthor = authorRepository.findByEmail(a.getEmail());
		existingAuthor.setFirstName(a.getFirstName());
		existingAuthor.setImageUrl(a.getImageUrl());
		existingAuthor.setLastName(a.getLastName());
		existingAuthor.setAge(a.getAge());
		existingAuthor.setDescription(a.getDescription());
		return authorRepository.save(existingAuthor);
	}
	
	public boolean customerIsFanOfTheAuthor(int authorId){
		Customer customer = customerService.getAuthenticatedCustomer();
		Author author = authorRepository.findById(authorId).orElse(null);
		String fansList = author.getFansList();
		if(fansList.contains(customer.getEmail()))
			return true;
		else return false;
	}
		
	public Author addCustomerToAuthorFansList(){
		List<Book> books = bookRepository.getSelectedBooksByCustomerOrdered(1L);
		Map<String, Integer> occAuth = new HashMap<>();
		for (Book book : books) {
			occAuth.put(book.getAuthor().getEmail(), occAuth.get(book.getAuthor().getEmail()) + 1);
		}
		occAuth.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.forEachOrdered(x -> occAuth.put(x.getKey(), x.getValue()));
		List<String> authorsList = occAuth.entrySet().stream().limit(1).map(a -> a.getKey())
				.collect(Collectors.toList());
		String favouriteAuthor = authorsList.get(1);
		Author a = getAuthorByEmail(favouriteAuthor);
		a.setFansList(a.getFansList() + customerService.getAuthenticatedCustomer().getEmail());
		return updateAuthor(a);
	}
}
