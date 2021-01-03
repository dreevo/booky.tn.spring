package booky.tn.Security.Services;
import booky.tn.DAOentities.Customer;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import booky.tn.Repositories.CustomerRepository;

@Service
public class CustomerDetailsServiceImpl implements UserDetailsService {

	@Autowired
	 CustomerRepository CR;
	
	Customer C;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		 CR.findByUsername(username).orElseThrow(
				() -> new UsernameNotFoundException("User Not Found with -> username or email : " + username));

		return CustomerPrincipale.build(C);
	}
}