package com.masaischool.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.masaischool.exception.NotFoundException;
import com.masaischool.model.Address;
import com.masaischool.model.Customer;
import com.masaischool.repository.AddressRepo;
import com.masaischool.repository.CustomerRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AddressServiceImpl implements AddressService{

	private AddressRepo addressRepo;
	
	private CustomerRepo customerRepo;
	
	
	
	public AddressServiceImpl(AddressRepo addressRepo, CustomerRepo customerRepo) {
		super();
		this.addressRepo = addressRepo;
		this.customerRepo = customerRepo;
	}

	@Override
	public Address addAddress(Integer customerId, Address address) {
		
		Optional<Customer> exist = customerRepo.findById(customerId);
		
		if(exist.isPresent()) {
			
			log.info("address saved successfully");
			
			return addressRepo.save( address);
			
		}
		
		throw new NotFoundException("customer not found to add the address");

	}

	@Override
	public List<Address> getAllAddress() {
		
		List<Address> list = addressRepo.findAll(); 
		
		if(list.size()==0) {
			log.error("address list is empty...");
			throw new NotFoundException("address list is empty...");
		}
		log.info("address list is available");
		return list;
	}

	@Override
	public Address getAddressById(Integer addressId) {
	
		Optional<Address> address = addressRepo.findById(addressId); 
		
		if(address.isPresent()) {
			log.info("address is available for the given customer id");
			return address.get();	
		}
		
		throw new NotFoundException("address not found for given customer id");
		
		 
	}

	@Override
	public Address updateAddress(Address address) {
		
		return addressRepo.save(address);
	}

	@Override
	public Address deleteAddressById(Integer addressId) {
		
		
		Optional<Address> address = addressRepo.findById(addressId); 

		if(address.isPresent()) {
			
			addressRepo.deleteById(addressId);
			log.info("address is deleted");
			return address.get();	
		}
		log.error("customer id not present");
		throw new NotFoundException("address not found");
	}



}






