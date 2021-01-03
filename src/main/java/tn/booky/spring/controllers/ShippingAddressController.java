package tn.booky.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.booky.spring.DAO.entities.ShippingAddress;
import tn.booky.spring.services.ShippingAddressService;

@RestController
public class ShippingAddressController {
	
	@Autowired
	private ShippingAddressService shippingaddressservice;
	
	@PostMapping("/addShippingAddress")
	public ShippingAddress addShippingAddress(@RequestBody ShippingAddress sa){
		return shippingaddressservice.addShippingAddress(sa);	
	}
	
	@DeleteMapping("/deleteShippingAddress/{id}")
	public String deleteShippingAddress(@PathVariable int id){
		return shippingaddressservice.deleteShippingAddress(id);	
	}
	
	@DeleteMapping("/deleteShippingAddresses")
	public String deleteShippingAddresses(){
		return shippingaddressservice.deleteShippingAddresses();	
	}
	
	@GetMapping("/getShippingAddress/{id}")
	public ShippingAddress getShippingAddress(@PathVariable int id){
		return shippingaddressservice.getShippingAddress(id);	
	}
	
	@GetMapping("/getShippingAddresses")
	public List<ShippingAddress> getShippingAddresses(){
		return shippingaddressservice.getShippingAddresses();	
	}
	
	@PutMapping("/updateShippingAddress")
	public ShippingAddress updateShippingAddress(@RequestBody ShippingAddress sa){
		return shippingaddressservice.updateShippingAddress(sa);	
	}

}
