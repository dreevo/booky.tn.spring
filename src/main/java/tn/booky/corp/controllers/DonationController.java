package tn.booky.corp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.booky.corp.DAO.entities.Customer;
import tn.booky.corp.DAO.entities.Donation;
import tn.booky.corp.services.CustomerService;
import tn.booky.corp.services.DonationService;

/**
 * @author Malek
 *
 */
@RestController
@RequestMapping("/rest/donation")
public class DonationController {
	
	@Autowired
	private DonationService donationService;
	@Autowired CustomerService customerService;
	
	//Crud
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
	
	@GetMapping("/getdonation/{id}")
	public List<Donation> getDonationByCustomer(@PathVariable Customer customer){
		return donationService.getDonationByCustomer(customer);	
	}
	
	@GetMapping("/getdonations")
	public List<Donation> getAllDonations(){
		return donationService.getAllDonations();	
	}
	
	@PutMapping("/updateDonation")
	public Donation updateDonation(@RequestBody Donation d){
		return donationService.updateDonation(d);	
	}
	
	//pushed requests
	
	@GetMapping("/getAllDonationMessages/{donationId}")
	public String getAllDonationMessages(@PathVariable int donationId) {
		return donationService.getAllDonationMessages(donationId);
	}
	@GetMapping("/getHighestDonationRegistered")
	public Double getHighestDonationRegistered() {
		return donationService.getHighestDonationRegistered();
	}
	@GetMapping("/getTotalDonationsAmount/{year}")
	public Double getTotalDonationsAmount(@PathVariable int year) {
		return donationService.getTotalDonationsAmount(year);
	}
	@GetMapping("/getCustomerWithHighestDonation")
	public String getCustomerWithHighestDonation() {
		return donationService.getCustomerWithHighestDonation();
	}
	
	//Methods consuming other services
	
}
