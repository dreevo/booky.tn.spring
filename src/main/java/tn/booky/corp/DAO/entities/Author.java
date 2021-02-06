package tn.booky.corp.DAO.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author gharbimedaziz
 */
@Entity
@Table(name = "T_AUTHOR")
public class Author implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "A_ID")
	private int id;
	@Column(name = "A_FIRSTNAME")
	private String firstName;
	@Column(name = "A_LASTNAME")
	private String lastName;
	@Column(name = "A_EMAIL")
	private String email;
	@Column(name = "A_AGE")
	private int age;
	@Column(name = "A_DESC")
	private String description;
	@Column(name = "A_IMAGEURL")
	private String imageUrl;
	@OneToMany(mappedBy = "author")
	@JsonIgnoreProperties("author")
	private Set<Book> books = new HashSet<>();
	@OneToMany(mappedBy = "author")
	private Set<Blog> blogs = new HashSet<>();
	@Column(name = "A_FANS")
	private String fansList;

	public Author(int id, String firstName, String lastName, String email, int age, String description, String imageUrl,
			Set<Book> books) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
		this.description = description;
		this.imageUrl = imageUrl;
		this.books = books;
	}

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public Set<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(Set<Blog> blogs) {
		this.blogs = blogs;
	}

	public String getFansList() {
		return fansList;
	}

	public void setFansList(String fansList) {
		this.fansList = fansList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", age=" + age + ", description=" + description + ", imageUrl=" + imageUrl + ", books=" + books + "]";
	}

}
