package booky.tn.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import booky.tn.DAOentities.Customer;
import booky.tn.services.AccountService;
import booky.tn.services.CustomerService;

import java.util.ArrayList;
import java.util.Collection;
@Service
public class UserDetailsServiceImpl implements UserDetailsService  {
    @Autowired
    private AccountService accountService ;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("load loula");
        Customer user = accountService.loadUserByEmail(email);
        System.out.println("load thenia");
        if(user==null)throw new UsernameNotFoundException("email not exist");
        System.out.println("load theltha");
        Collection<GrantedAuthority> authorities = new ArrayList<>() ;
        System.out.println("load rabeaa");
        user.getRoles().forEach(role ->  authorities.add(new SimpleGrantedAuthority(role.getRoleName())));
        System.out.println("maoujoud");
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),authorities);
    }
}
