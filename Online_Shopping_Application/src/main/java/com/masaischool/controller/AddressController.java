package com.masaischool.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masaischool.model.Address;
import com.masaischool.service.AddressServiceImpl;

import jakarta.validation.Valid;

@RestController
public class AddressController {

	private AddressServiceImpl service;
	
	
	
	public AddressController(AddressServiceImpl service) {
		super();
		this.service = service;
	}



	@PostMapping("/address/{customerId}")
	public ResponseEntity<Address> addAddress(@PathVariable Integer customerId, @Valid @RequestBody Address address){
		
		Address insertAddress = service.addAddress(customerId,address);
		
		return new ResponseEntity<Address>(insertAddress, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/update_address/{customerId}")
	public ResponseEntity<Address> updateAddress(@PathVariable Integer customerId, @Valid @RequestBody Address address){
		
		Address insertAddress = service.updateAddress(address);
		
		return new ResponseEntity<Address>(insertAddress, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/address")
	public ResponseEntity<List<Address>> getAllAddress(){
		return new ResponseEntity<>(service.getAllAddress(),HttpStatus.OK);
	}
	
	@GetMapping("/get_address/{addressId}")
	public ResponseEntity<Address> getAddressById(@PathVariable Integer addressId){
		return new ResponseEntity<Address>(service.getAddressById(addressId),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete_address/{addressId}")
	public ResponseEntity<Address> deleteAddressById(@PathVariable Integer addressId){
		
		Address deleted = service.deleteAddressById(addressId);
		
		return new ResponseEntity<Address>(deleted,HttpStatus.OK);
		
	}
	
	
}
