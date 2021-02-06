package tn.booky.corp.services;

import java.util.List;

import tn.booky.corp.DAO.entities.ShippingAddress;

public interface ShippingAddressService {
	public ShippingAddress addShippingAddress(ShippingAddress sa);

	public String deleteShippingAddress(int id);

	public String deleteShippingAddresses();

	public ShippingAddress getShippingAddress(int id);

	public List<ShippingAddress> getShippingAddresses();

	public ShippingAddress updateShippingAddress(ShippingAddress sa);

}