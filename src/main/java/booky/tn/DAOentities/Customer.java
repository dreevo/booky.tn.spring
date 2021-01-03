package booky.tn.DAOentities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import com.sun.istack.NotNull;


@Entity
@Table(name = "cutomers", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "username"
        }),
        @UniqueConstraint(columnNames = {
            "email"
        })
})
public class Customer implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="customer_ID")
	private Long id;
	@NotBlank(message = "Firstname is mandatory")
    @Size(min=3, max = 50)
	@NotNull
	@Column(name="Firstname")
	private String firstname;
	@NotNull
	@NotBlank(message = "Lastname is mandatory")
    @Size(min=3, max = 50)
	@Column(name="Lastname")
	private String lastname;
	@NotNull
	@NotBlank(message = "Username is mandatory")
    @Size(min=3, max = 50)
	@Column(name="Username")
	private String username;
	@Min(18)
	@Max(99)
	@NotNull
	@Column(name="Age")
	private int age;
	@NaturalId
    @NotBlank(message = "Email is mandatory")
    @Size(max = 50)
    @Email
	@NotNull
	@Column(name="Email")
	private String email;
	@NotBlank(message = "Address is mandatory")
    @Size(min=3, max = 50)
	@NotNull
	@Column(name="Address")
	private String address;
	//@NotNull
	@Column(name="ImgURL")
	private String imgURL;
	@NotBlank(message = "Phone Number is mandatory")
	@Size(min=8, max=8)
	@NotNull
	@Column(name="Telephone")
	private String phone;
	@NotBlank(message = "Invalid pwd")
	@NotBlank
    @Size(min=6, max = 100)
	@NotNull
	@Column(name="Password")
	private String password;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "customer_roles", 
    	joinColumns = @JoinColumn(name = "cutomer_ID"), 
    	inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
	
	
	
	public Customer(String firstname, String lastname, String username, int age, String email, String address, String imgURL,
		String phone, String password) {
	super();
	this.firstname = firstname;
	this.lastname = lastname;
	this.username = username;
	this.age = age;
	this.email = email;
	this.address = address;
	this.imgURL = imgURL;
	this.phone = phone;
	this.password = password;
}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    
	
	
	

}
