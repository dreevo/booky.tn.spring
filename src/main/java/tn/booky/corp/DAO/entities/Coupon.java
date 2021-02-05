package tn.booky.corp.DAO.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_Coupon")
public class Coupon implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nomcoupon;
	private int codereduction;
	private Date datevalidite;
	private float pourcentage;
	@OneToOne
	private Cart cart;
	
	
	
	public Coupon() {
		super();
	}
	
	
	public Coupon(int id, String nomcoupon, int codereduction, Date datevalidite, float pourcentage, Cart cart) {
		super();
		this.id = id;
		this.nomcoupon = nomcoupon;
		this.codereduction = codereduction;
		this.datevalidite = datevalidite;
		this.pourcentage = pourcentage;
		this.cart = cart;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomcoupon() {
		return nomcoupon;
	}
	public void setNomcoupon(String nomcoupon) {
		this.nomcoupon = nomcoupon;
	}
	public int getCodereduction() {
		return codereduction;
	}
	public void setCodereduction(int codereduction) {
		this.codereduction = codereduction;
	}
	public Date getDatevalidite() {
		return datevalidite;
	}
	public void setDatevalidite(Date datevalidite) {
		this.datevalidite = datevalidite;
	}
	public float getPourcentage() {
		return pourcentage;
	}
	public void setPourcentage(float pourcentage) {
		this.pourcentage = pourcentage;
	}

	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}


	@Override
	public String toString() {
		return "Coupon [id=" + id + ", nomcoupon=" + nomcoupon + ", codereduction=" + codereduction + ", datevalidite="
				+ datevalidite + ", pourcentage=" + pourcentage + ", cart=" + cart + "]";
	}
	
	
	
	
	

}
