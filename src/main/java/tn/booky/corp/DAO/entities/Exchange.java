package tn.booky.corp.DAO.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Malek
 *
 */
@Entity
@Table(name = "T_EXCHANGE")
public class Exchange implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "EX_ID")
	private int id;
	@ManyToOne
	@JoinColumn(name = "giver")
	private Customer giver;
	@ManyToOne
	@JoinColumn(name = "reciever")
	private Customer reciever;

	@JoinColumn(name = "EX_EXCHANGEDESCRIPTION")
	private String exchangeDescription;
	@Enumerated(EnumType.STRING)
	private Status exchangeStatus;

	public Exchange(int id, Customer giver, Customer reciever, String exchangeDescription, Status exchangeStatus) {
		super();
		this.id = id;
		this.giver = giver;
		this.reciever = reciever;
		this.exchangeDescription = exchangeDescription;
		this.exchangeStatus = exchangeStatus;
	}

	public Exchange() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getGiver() {
		return giver;
	}

	public void setGiver(Customer giver) {
		this.giver = giver;
	}

	public Customer getReciever() {
		return reciever;
	}

	public void setReciever(Customer reciever) {
		this.reciever = reciever;
	}

	public String getExchangeDescription() {
		return exchangeDescription;
	}

	public void setExchangeDescription(String exchangeDescription) {
		this.exchangeDescription = exchangeDescription;
	}

	public Status getExchangeStatus() {
		return exchangeStatus;
	}

	public void setExchangeStatus(Status exchangeStatus) {
		this.exchangeStatus = exchangeStatus;
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
		Exchange other = (Exchange) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Exchange [id=" + id + ", giver=" + giver + ", reciever=" + reciever + ", exchangeDescription="
				+ exchangeDescription + ", exchangeStatus=" + exchangeStatus + "]";
	}

}
