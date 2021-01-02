package tn.booky.corp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.booky.corp.DAO.entities.Author;
import tn.booky.corp.services.AuthorService;

/**
 * @author gharbimedaziz
 */
@RestController
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@PostMapping("/addAuthor")
	public Author addAuthor(@RequestBody Author a) {
		return authorService.saveAuthor(a);
	}

	@PostMapping("/addAuthors")
	public List<Author> addAuthors(@RequestBody List<Author> authors) {
		return authorService.saveAuthors(authors);
	}

	@GetMapping("/authors")
	public List<Author> findAllAuthors() {
		return authorService.getAuthors();
	}

	@GetMapping("/author/{id}")
	public Author getAuthorById(@PathVariable int id) {
		return authorService.getAuthorById(id);
	}

	@GetMapping("/authorEmail/{email}")
	public Author getAuthorByEmail(@PathVariable String email) {
		return authorService.getAuthorByEmail(email);
	}

	@PutMapping("/updateAuthor")
	public Author updateAuthor(@RequestBody Author a) {
		return authorService.updateAuthor(a);
	}

	@DeleteMapping("/deleteAuthor/{id}")
	public String deleteAuthor(@PathVariable int id) {
		return authorService.deleteAuthor(id);
	}
}
