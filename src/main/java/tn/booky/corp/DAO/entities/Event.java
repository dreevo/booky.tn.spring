package tn.booky.corp.DAO.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "T_EVENT")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "E_ID")
	private int id;
	@Column(name = "E_TITLE")
	private String title;
	@Column(name = "E_DESCRIPTION")
	private String description;
	@Column(name = "E_BEGINDATE")
	@Temporal(TemporalType.DATE)
	private Date beginDate;
	@Column(name = "E_ENDDATE")
	@Temporal(TemporalType.DATE)
	private Date endDate;
	@Column(name = "E_IMAGEURL")
	private String imageUrl;
	@OneToOne(mappedBy = "event")
	private Book book;
	@ManyToMany(mappedBy = "events", cascade = CascadeType.ALL)
	private Set<Customer> customers = new HashSet<>();

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Event(int id, String title, String description, Date beginDate, Date endDate, String imageUrl) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.imageUrl = imageUrl;
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

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
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
		Event other = (Event) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", description=" + description + ", beginDate=" + beginDate
				+ ", endDate=" + endDate + ", imageUrl=" + imageUrl + "]";
	}
}
