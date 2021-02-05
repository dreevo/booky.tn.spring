package tn.booky.corp.services;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.booky.corp.DAO.entities.Coupon;
import tn.booky.corp.DAO.repositories.CouponRepository;


@Service
public class CouponServiceImpl implements CouponService{
	@Autowired
	private CouponRepository couponrepository;
	
	public Coupon addCoupon(Coupon c){
		return couponrepository.save(c);
	}
	
	public String deleteCoupon(int id){
		couponrepository.deleteById(id);
		return "cartItem" + id + "was deleted";
	}
	
	public String deleteCouponss(){
		couponrepository.deleteAll();
		return "cartitems were deleted";
	}
	
	public Coupon getCoupon(int id){
		return couponrepository.findById(id).orElse(null);
	}
	
	public List<Coupon> getCoupons(){
		return couponrepository.findAll();
	}
	
	public Coupon getcouponbycartid(int cart_id) {
		return couponrepository.getcouponbycartid(cart_id);
	}

	@Override
	public String deleteCoupons() {
		couponrepository.deleteAll();
		return "coupons were deleted";
	}

}
