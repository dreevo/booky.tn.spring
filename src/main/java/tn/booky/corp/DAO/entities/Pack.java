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
@Table(name = "T_PACK")
public class Pack implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "P_ID")
	private int id;
	@Column(name = "P_LABEL")
	private String label;
	@Column(name = "P_IMAGEURL")
	private String imageUrl;
	@Column(name = "P_PRICE")
	private double price;
	@Column(name = "P_DESC")
	private String description;
	@OneToMany(mappedBy = "pack")
	@JsonIgnoreProperties("pack")
	private Set<Book> books = new HashSet<>();

	public Pack(int id, String label, String imageUrl, double price, String description, Set<Book> books) {
		super();
		this.id = id;
		this.label = label;
		this.imageUrl = imageUrl;
		this.price = price;
		this.description = description;
		this.books = books;
	}

	public Pack() {
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

	public void setLabel(String label) {
		this.label = label;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
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
		Pack other = (Pack) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pack [id=" + id + ", label=" + label + ", imageUrl=" + imageUrl + ", price=" + price + ", description="
				+ description + ", books=" + books + "]";
	}

}
