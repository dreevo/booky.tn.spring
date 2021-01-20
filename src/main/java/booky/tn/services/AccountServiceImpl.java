package booky.tn.services;

import booky.tn.DAOentities.Customer;
import booky.tn.DAOentities.Role;
import booky.tn.repositories.CustomerRepository;
import booky.tn.repositories.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
@Autowired
    private CustomerRepository userRepository ;
@Autowired
    private RoleRepository roleRepository ;
@Autowired
private BCryptPasswordEncoder bCryptPasswordEncoder ;

    @Override
    public Customer saveUser(Customer user) {
        Customer us = userRepository.findUsersByEmail(user.getEmail());
        System.out.println("lowwweeellll");
        if(us!=null) throw new RuntimeException("User already exist");
        System.out.println("theeeniiiii");
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        System.out.println("theeeleethhhh");
        userRepository.save(user);
        System.out.println("eeraaabaaaaaa");
        addRoleToUser(user.getEmail(),"USER");
        return user ;

    }

    @Override
    public Role saveRole(Role role) {

        return roleRepository.save(role);
    }

    @Override
    public Customer loadUserByEmail(String email) {

        return userRepository.findUsersByEmail(email);
    }

    @Override
    public void addRoleToUser(String email, String roleName) {
        Customer user = userRepository.findUsersByEmail(email);
        Role role = roleRepository.findByRoleName(roleName);
        user.getRoles().add(role);

    }

	
}
