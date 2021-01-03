package tn.booky.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import tn.booky.spring.DAO.entities.ShippingAddress;

public interface ShippingAddressRepository extends JpaRepository<ShippingAddress, Integer> {

}
