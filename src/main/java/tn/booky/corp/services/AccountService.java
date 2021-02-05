package tn.booky.corp.services;

import tn.booky.corp.DAO.entities.Customer;
import tn.booky.corp.DAO.entities.Role;

public interface AccountService {
	public Customer saveUser(Customer user);

	public Role saveRole(Role role);

	public Customer loadUserByEmail(String email);

	public void addRoleToUser(String Email, String roleName);
}
