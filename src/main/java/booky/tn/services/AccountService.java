package booky.tn.services;

import booky.tn.DAOentities.Customer;
import booky.tn.DAOentities.Role;

public interface AccountService {
	  public Customer saveUser (Customer user) ;
	  public Role saveRole (Role role) ;
	 public    Customer loadUserByEmail ( String email) ;
	  public   void addRoleToUser (String Email , String roleName) ;
	}
