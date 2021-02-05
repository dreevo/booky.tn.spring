package tn.booky.corp.DAO.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Malek
 *
 */
@Entity
@Table(name = "T_CHARITY")
public class Charity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CH_ID")
	private int id;
	@Column(name = "CH_TITLE")
	private String title;
	@Column(name = "CH_DESCRIPTION")
	private String description;
	@Column(name = "CH_DONATIONS")
	@OneToMany(mappedBy = "charity")
	@JsonIgnoreProperties("charity")
	private Set<Donation> donations;
	@Column(name = "CH_IMAGEURL")
	private String imageUrl;
	@OneToMany(mappedBy = "charity", cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, fetch = FetchType.EAGER)
	@JsonIgnoreProperties("charity")
	private Set<Book> books;

	public Charity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Donation> getDonations() {
		return donations;
	}

	public void setDonations(Set<Donation> donations) {
		this.donations = donations;
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
		Charity other = (Charity) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Charity [id=" + id + ", title=" + title + ", description=" + description + ", donations=" + donations
				+ ", imageUrl=" + imageUrl + ", books=" + books + "]";
	}

}