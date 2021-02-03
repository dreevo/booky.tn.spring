package tn.booky.corp.DAO.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import tn.booky.corp.DAO.entities.Comment;

@Entity
@Table(name = "T_BLOG")

public class Blog implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "B_ID")
	private int id;
	@Column(name = "B_TITLE")
	private String title;
	@Column(name = "B_CONTENT")
	private String content;
	@ManyToOne
	@JoinColumn(name = "A_ID")
	private Author author;
	@OneToMany(mappedBy = "blog")
	@JsonIgnoreProperties("blog")
	private Set<Comment> comments;

	public Blog(int id, String title, String content, Author author) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.author = author;
	}

	public Blog(String title, String content, Author author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}

	public Blog(int id) {
		this.id = id;
	}

	public Blog(String title) {
		this.title = title;
	}

	public Blog(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public Blog() {
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + this.id;
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
		final Blog other = (Blog) obj;
		if (this.id != other.id) {
			return false;
		}
		if (!Objects.equals(this.title, other.title)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Blog{" + "id=" + id + ", title=" + title + ", content=" + content + ", author=" + author + ", comments="
				+ comments + '}';
	}

}
