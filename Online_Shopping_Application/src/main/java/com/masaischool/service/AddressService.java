package com.masaischool.service;

import java.util.List;
import java.util.Optional;

import com.masaischool.model.Address;

public interface AddressService {

	public Address addAddress(Integer customerId, Address address);
	
	public List<Address> getAllAddress();
	
	public Address getAddressById(Integer addressId);
	
	public Address updateAddress(Address address);
	
	public Address deleteAddressById(Integer addressId);
	
//	public Optional<List<Address>> getAllAddressByCustomerId(Integer customerId);
	
	
}