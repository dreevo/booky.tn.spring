package tn.booky.corp.DAO.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "T_COMMENTS")

public class Comment implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_ID")
	private int id;
	@Column(name = "C_DESCRIPTION")
	private String description;
	@ManyToOne
	@JoinColumn(name = "CU_ID")
	private Customer customer;
	@ManyToOne
	@JoinColumn(name = "BL_ID")
	@JsonIgnoreProperties("comments")
	private Blog blog;

	public Comment(int id, String description, Customer customer) {
		this.id = id;
		this.description = description;
		this.customer = customer;
	}

	public Comment(String description, Customer customer) {
		this.description = description;
		this.customer = customer;
	}

	public Comment() {
	}

	public Comment(int id, String description, Customer customer, Blog blog) {
		this.id = id;
		this.description = description;
		this.customer = customer;
		this.blog = blog;
	}

	public Comment(String description, Customer customer, Blog blog) {
		this.description = description;
		this.customer = customer;
		this.blog = blog;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 59 * hash + this.id;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Comment other = (Comment) obj;
		if (this.id != other.id) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Comment{" + "id=" + id + ", description=" + description + ", customer=" + customer + '}';
	}
}
