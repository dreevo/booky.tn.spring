package tn.booky.corp.DAO.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="T_order")
public class Order implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.DATE)
	@Column(name="order_date")
	private Date date;
	private int discount;
	private String orderType;
	private boolean isDone;
	@OneToOne(mappedBy="order")
	@JsonIgnoreProperties("cart")
	private Cart cart;
	@OneToMany(mappedBy="order")
	@JsonIgnoreProperties("shippingAddress")
	private Set <ShippingAddress> shippingaddress;
	
	
	
	
	
	public Order() {
		super();
	}
	public Order(int id, Date date, int discount, String orderType, boolean isDone) {
		super();
		this.id = id;
		this.date = date;
		this.discount = discount;
		this.orderType = orderType;
		this.isDone = isDone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", date=" + date + ", discount=" + discount + ", orderType=" + orderType
				+ ", isDone=" + isDone + "]";
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
		Order other = (Order) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}