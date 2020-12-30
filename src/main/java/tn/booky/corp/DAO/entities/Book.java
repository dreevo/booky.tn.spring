package tn.booky.corp.DAO.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * @author gharbimedaziz
 */
@Entity
@Table(name = "T_BOOK")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "B_ID")
	private int id;
	@Column(name = "B_LABEL")
	private String label;
	@Column(name = "B_STOCK")
	private boolean isInStock;
	@Column(name = "B_PRICE")
	private double price;
	@Column(name = "B_IMAGEURL")
	private String imageUrl;
	@Column(name = "B_RATING")
	private int rating;
	@Column(name = "B_LANGUAGE")
	@Enumerated(EnumType.STRING)
	private Language language;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "T_BOOK_CATEGORIES", joinColumns = @JoinColumn(name = "B_ID"), inverseJoinColumns = @JoinColumn(name = "C_ID"))
	private Set<Category> categories = new HashSet<>();
	@ManyToOne
	@JoinColumn(name = "A_ID", nullable = false)
	private Author author;
	@ManyToOne
	@JoinColumn(name = "P_ID", nullable = false)
	private Pack pack;

	public Book(int id, String label, boolean isInStock, double price, String imageUrl, int rating, Language language,
			Set<Category> categories, Author author, Pack pack) {
		super();
		this.id = id;
		this.label = label;
		this.isInStock = isInStock;
		this.price = price;
		this.imageUrl = imageUrl;
		this.rating = rating;
		this.language = language;
		this.categories = categories;
		this.author = author;
		this.pack = pack;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String libelle) {
		this.label = libelle;
	}

	public boolean isInStock() {
		return isInStock;
	}

	public void setInStock(boolean isInStock) {
		this.isInStock = isInStock;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public Pack getPack() {
		return pack;
	}

	public void setPack(Pack pack) {
		this.pack = pack;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", label=" + label + ", isInStock=" + isInStock + ", price=" + price + ", imageUrl="
				+ imageUrl + ", rating=" + rating + ", language=" + language + ", categories=" + categories
				+ ", author=" + author + ", pack=" + pack + "]";
	}

}
