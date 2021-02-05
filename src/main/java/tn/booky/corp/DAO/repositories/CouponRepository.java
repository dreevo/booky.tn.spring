package tn.booky.corp.DAO.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.booky.corp.DAO.entities.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {
	@Query("select c from Coupon c where c.cart.id = :cartid")
	Coupon getcouponbycartid (int cartid);

}
