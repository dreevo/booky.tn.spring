package tn.booky.corp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.booky.corp.DAO.entities.Customer;
import tn.booky.corp.DAO.entities.Donation;
import tn.booky.corp.services.DonationService;

@RestController
public class DonationController {
	
	@Autowired
	private DonationService donationService;
	
	@PostMapping("/addDonation")
	public Donation addDonation(@RequestBody Donation d){
		return donationService.addDonation(d);	
	}
	
	@DeleteMapping("/deleteDonation/{id}")
	public String deleteDonation(@PathVariable int id){
		return donationService.deleteDonation(id);	
	}
	
	@DeleteMapping("/deleteDonations")
	public String deleteDonations(){
		return donationService.deleteDonations();	
	}
	
	@GetMapping("/donation/{id}")
	public List<Donation> getDonationByCustomer(@PathVariable Customer customer){
		return donationService.getDonationByCustomer(customer);	
	}
	
	@GetMapping("/donations")
	public List<Donation> getAllDonations(){
		return donationService.getAllDonations();	
	}
	
	@PutMapping("/updateDonation")
	public Donation updateDonation(@RequestBody Donation d){
		return donationService.updateDonation(d);	
	}
}
