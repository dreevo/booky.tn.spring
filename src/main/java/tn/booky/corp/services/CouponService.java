package tn.booky.corp.services;


import java.util.List;
import tn.booky.corp.DAO.entities.Coupon;

public interface CouponService {
	public Coupon addCoupon(Coupon c);
	public String deleteCoupon(int id);
	public String deleteCoupons();
	public Coupon getCoupon(int id);
	public List<Coupon> getCoupons();
	public Coupon getcouponbycartid(int cart_id);

}
