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

import tn.booky.corp.DAO.entities.Charity;
import tn.booky.corp.services.CharityService;

@RestController
public class CharityController {

	@Autowired
	private CharityService charityService;
	

	@PostMapping("/addCharity")
	public Charity addCharity(@RequestBody Charity ch){
		return charityService.addCharity(ch);	
	}
	
	@DeleteMapping("/deleteCharityById/{id}")
	public String deleteCharityById(@PathVariable int id){
		return charityService.deleteCharityById(id);	
	}
	
	@DeleteMapping("/deleteCharities")
	public String deleteCharities(){
		return charityService.deleteCharities();	
	}
	
	@GetMapping("/getCharityById/{id}")
	public Charity getCharityById(@PathVariable int id){
		return charityService.getCharityById(id);	
	}
	
	@GetMapping("/charities")
	public List<Charity> getAllCharities(){
		return charityService.getAllCharities();	
	}
	
	@PutMapping("/updateCharity")
	public Charity updateCharity(@RequestBody Charity ch){
		return charityService.updateCharity(ch);	
	}

}
