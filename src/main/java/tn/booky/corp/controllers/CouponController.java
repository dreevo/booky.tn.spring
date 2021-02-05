package tn.booky.corp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.booky.corp.DAO.entities.Coupon;
import tn.booky.corp.services.CouponService;

public class CouponController {
	@Autowired
	private CouponService couponservice;
	
	@GetMapping("/getitemsbycat_id/{cart_id}")
	public Coupon getitemsbycat_id(@PathVariable int cart_id){
		return couponservice.getcouponbycartid(cart_id);
	}	
	
	

}
