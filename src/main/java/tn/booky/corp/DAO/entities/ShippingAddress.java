package tn.booky.corp.DAO.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_SHIPPINGADDRESS")
public class ShippingAddress implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String address;
	private String city;
	private String zipcode;
	@ManyToOne
	private Order order;
	
	
	public ShippingAddress() {
		super();
	}
	public ShippingAddress(int id, String address, String city, String zipcode) {
		super();
		this.id = id;
		this.address = address;
		this.city = city;
		this.zipcode = zipcode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAdress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	@Override
	public String toString() {
		return "ShippingAddress [id=" + id + ", address=" + address + ", city=" + city + ", zipcode=" + zipcode + "]";
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
		ShippingAddress other = (ShippingAddress) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}