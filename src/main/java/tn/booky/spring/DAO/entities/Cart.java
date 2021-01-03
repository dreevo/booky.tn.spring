/**
 * 
 */
package tn.booky.spring.DAO.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

/**
 * @author USER
 *
 */
@Entity
public class Cart implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Double totalPrice;
	@OneToMany(mappedBy="cart")
	private Set<CartItem> cartItems;
	@OneToOne
	private Order order;
	
	
	public Cart() {
		super();
	}

	public Cart(int id, double totalPrice) {
		super();
		this.id = id;
		this.totalPrice = totalPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", totalPrice=" + totalPrice + "]";
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
		Cart other = (Cart) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	

}
