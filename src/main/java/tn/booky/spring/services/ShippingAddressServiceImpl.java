package tn.booky.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.booky.spring.DAO.entities.ShippingAddress;
import tn.booky.spring.repositories.ShippingAddressRepository;

@Service
public class ShippingAddressServiceImpl implements ShippingAddressService {
	@Autowired
	private ShippingAddressRepository shippingaddressrepository;
	
	public ShippingAddress addShippingAddress(ShippingAddress sa){
		return shippingaddressrepository.save(sa);
	}
	
	public String deleteShippingAddress(int id){
		shippingaddressrepository.deleteById(id);
		return "ShippingAddress" + id + "was deleted";
	}
	
	public String deleteShippingAddresses(){
		shippingaddressrepository.deleteAll();
		return "ShippingAddresses were deleted";
	}
	
	public ShippingAddress getShippingAddress(int id){
		return shippingaddressrepository.findById(id).orElse(null);
	}
	
	public List<ShippingAddress> getShippingAddresses(){
		return shippingaddressrepository.findAll();
	}
	
	public ShippingAddress updateShippingAddress(ShippingAddress sa){
		ShippingAddress ship = shippingaddressrepository.findById(sa.getId()).orElse(null);
		ship.setAdress(sa.getAddress());
		ship.setCity(sa.getCity());
		ship.setZipcode(sa.getZipcode());
		return shippingaddressrepository.save( ship);
	}

}
