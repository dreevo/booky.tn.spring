package booky.tn.Security.Services;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;

import booky.tn.DAOentities.Customer;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CustomerPrincipale implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Long id;
    private String firstname;
    private String lastname;
    private String username;
    private int age;
    private String email;
    private String address;
    private String imgurl;
    private String phone;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public CustomerPrincipale(Long id, String firstname, String lastname, String username,
    		int age, String email, String address, String imgurl, String phone, String password, 
			    		Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.age = age;
        this.email = email;
        this.address = address;
        this.imgurl= imgurl;
        this.phone = phone;
        this.password = password;
        this.authorities = authorities;
       
    }

    public static CustomerPrincipale build(Customer C) {
        List<GrantedAuthority> authorities = C.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getName().name())
        ).collect(Collectors.toList());

        return new CustomerPrincipale(
                C.getId(),
                C.getFirstname(),
                C.getLastname(),
                C.getUsername(),
                C.getAge(),
                C.getEmail(),
                C.getAddress(),
                C.getImgURL(),
                C.getPhone(),
                C.getPassword(),
               
                authorities
        );
    }

 

    public Long getId() {
		return id;
	}


	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getUsername() {
		return username;
	}

	public int getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public String getImgurl() {
		return imgurl;
	}

	public String getPhone() {
		return phone;
	}

	public String getPassword() {
		return password;
	}

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        CustomerPrincipale C = (CustomerPrincipale) o;
        return Objects.equals(id, C.id);
    }
    
}
