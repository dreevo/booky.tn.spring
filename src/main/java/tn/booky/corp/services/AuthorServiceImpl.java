package tn.booky.corp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.booky.corp.DAO.entities.Author;
import tn.booky.corp.DAO.repositories.AuthorRepository;

/**
 * @author gharbimedaziz
 */
@Service
public class AuthorServiceImpl implements AuthorService {
	@Autowired
	private AuthorRepository authorRepository;

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
}
