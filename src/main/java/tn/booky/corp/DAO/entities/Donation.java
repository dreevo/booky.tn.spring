package tn.booky.corp.DAO.entities;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Malek
 *
 */
@Entity
@Table(name = "T_DONATION")
public class Donation implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "D_ID")
	private int id;
	@Column(name = "D_MESSAGE")
	private String message;
	@Column(name = "D_AMOUNT")
	private Double amount;
	@ManyToOne
	@JoinColumn(name = "CU_ID")
	@JsonIgnoreProperties("donations")
	private Customer customer;
	@ManyToOne
	@JoinColumn(name = "C_ID")
	@JsonIgnoreProperties("donations")
	private Charity charity;

	public Donation(int id, String message, Double amount, Customer customer, Charity charity) {
		super();
		this.id = id;
		this.message = message;
		this.amount = amount;
		this.customer = customer;
		this.charity = charity;
	}

	public Donation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Charity getCharity() {
		return charity;
	}

	public void setCharity(Charity charity) {
		this.charity = charity;
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
		Donation other = (Donation) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Donation [id=" + id + ", message=" + message + ", amount=" + amount + ", customer=" + customer
				+ ", charity=" + charity + "]";
	}

}