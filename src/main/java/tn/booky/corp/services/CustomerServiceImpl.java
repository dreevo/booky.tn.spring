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
import tn.booky.corp.DAO.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository CustomerRepo;

	@Autowired
	private BookService bookService;

	@Autowired
	private AuthorService authorService;

	public Customer addCustomer(Customer C) {
		return CustomerRepo.save(C);
	}

	@Override
	public List<Customer> getList() {
		return CustomerRepo.findAll();
	}

	@Override
	public void delete(Long p) {
		CustomerRepo.deleteById(p);
	}

	@Override
	public Customer modify(Customer p) {
		Customer customer = CustomerRepo.findById(p.getId()).orElse(null);
		if (p.getAge() != 0)
			customer.setAge(p.getAge());
		else if (p.getAddress() != null)
			customer.setAddress(p.getAddress());
		else if (p.getFirstname() != null)
			customer.setFirstname(p.getFirstname());
		else if (p.getLastname() != null)
			customer.setLastname(p.getLastname());
		else if (p.getImgURL() != null)
			customer.setImgURL(p.getImgURL());
		else if (p.getPhone() != null)
			customer.setPhone(p.getPhone());
		return CustomerRepo.save(customer);
	}

	@Override
	public Customer findById(Long id) {
		return CustomerRepo.getOne(id);
	}

	@Override
	public Customer findByEmail(String E) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getAuthenticatedCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateAuthorFansList() {
		List<Book> books = bookService.getMostSelectedBooksByCustomer();
		Map<String, Integer> occAuth = new HashMap<>();
		for (Book book : books) {
			occAuth.put(book.getAuthor().getEmail(), occAuth.get(book.getAuthor().getEmail()) + 1);
		}
		occAuth.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.forEachOrdered(x -> occAuth.put(x.getKey(), x.getValue()));
		List<String> authorsList = occAuth.entrySet().stream().limit(1).map(a -> a.getKey())
				.collect(Collectors.toList());
		String favouriteAuthor = authorsList.get(1);
		Author a = authorService.getAuthorByEmail(favouriteAuthor);
		a.setFansList(a.getFansList() + getAuthenticatedCustomer().getEmail());
		authorService.updateAuthor(a);
		return "Fans List update for author" + a.getLastName() + " " + a.getFirstName();
	}

}
