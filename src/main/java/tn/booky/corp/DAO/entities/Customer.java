package tn.booky.corp.DAO.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "T_CUSTOMER")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstname;
	private String lastname;
	private int age;
	private String email;
	private String address;
	private String imgURL;
	private String phone;
	private String password;
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<Role> roles = new ArrayList<>();
	@OneToMany(mappedBy = "customer")
	@JsonIgnoreProperties("customer")
	private Set<Donation> donations;
	@OneToMany(mappedBy = "giver")
	private Set<Exchange> giverExchange;
	@OneToMany(mappedBy = "reciever")
	private List<Exchange> recieverExchange;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "T_EVENT_PARTICIPANTS", joinColumns = @JoinColumn(name = "CU_ID"), inverseJoinColumns = @JoinColumn(name = "E_ID"))
	private Set<Event> events = new HashSet<>();
	@OneToMany(mappedBy = "customer")
	@JsonIgnoreProperties("customer")
	private Set<Comment> comments = new HashSet<>();
	@OneToOne
	private Cart cart;

	public Customer(Long id, String firstname, String lastname, int age, String email, String address, String imgURL,
			String phone, String password, Collection<Role> roles) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.email = email;
		this.address = address;
		this.imgURL = imgURL;
		this.phone = phone;
		this.password = password;
		this.roles = roles;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Long id) {
		super();
		this.id = id;
	}

	public Customer(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Customer other = (Customer) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", age=" + age
				+ ", email=" + email + ", address=" + address + ", imgURL=" + imgURL + ", phone=" + phone + ""
				+ ", password=" + password + "]";
	}

}
