package tn.booky.corp.services;

import java.util.List;

import tn.booky.corp.DAO.entities.Author;

/**
 * @author gharbimedaziz
 */
public interface AuthorService {
	public Author saveAuthor(Author a);

	public List<Author> saveAuthors(List<Author> authors);

	public List<Author> getAuthors();

	public Author getAuthorById(int id);

	public Author getAuthorByEmail(String email);

	public String deleteAuthor(int id);

	public Author updateAuthor(Author a);
	
	public boolean customerIsFanOfTheAuthor(int authorId);
	
	public Author getRecommendedAuthor();
	
	public Author addCustomerToAuthorFansList();
}
