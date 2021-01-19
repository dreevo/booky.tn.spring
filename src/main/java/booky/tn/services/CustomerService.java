package booky.tn.services;

import java.util.List;

import booky.tn.DAOentities.Customer;

public interface CustomerService <T>{
   public Customer addCustomer(Customer C);
   public List<T> getList();
   public void delete(Long p);
   public T modify(T p);
   public T findById(Long id);
   public T findByEmail(String E);
}
