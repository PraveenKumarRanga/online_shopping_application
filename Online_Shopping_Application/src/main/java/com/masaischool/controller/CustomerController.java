package com.masaischool.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
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
import com.masaischool.model.Cart;
import com.masaischool.model.Customer;
import com.masaischool.model.User;
import com.masaischool.service.CustomerServiceImpl;

import jakarta.validation.Valid;

@RestController
public class CustomerController {

	private CustomerServiceImpl service;

	public CustomerController(CustomerServiceImpl service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer){
		
// setting address list
		List<Address> addressList = customer.getAddress();
		
		if(addressList != null) {
			
			for(Address a : addressList) {
				
				a.setCustomer(customer);
				
			}
		}
// setting cart
		Cart cart = customer.getCart();
		
		if(cart != null) {
			
			cart.setCustomer(customer);
			
		}
// setting user		
		User user = customer.getUser();
		
		if(user != null) {
			user.setCustomer(customer);
		}
		
		
		return new ResponseEntity<Customer>(service.addCustomer(customer),HttpStatus.CREATED);
		
	}
	
	
	@PutMapping("/update_customer/{customerId}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Integer customerId, 
			@Valid @RequestBody Customer customer){
		
		return new ResponseEntity<Customer>(service.updateCustomer(customerId,customer),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		
		
		return new ResponseEntity<List<Customer>>(service.getAllCustomer(),HttpStatus.OK);
	}
	
	
	@GetMapping("/customers/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Integer customerId){
		
		
		return new ResponseEntity<>(service.getCustomerById(customerId),HttpStatus.OK);
	}
	
	@DeleteMapping("/customer/{customerId}")
	public ResponseEntity<Customer> deleteCustomerById(@PathVariable Integer customerId){
		
		Customer deleted = service.deleteCustomer(customerId);
		
		return new ResponseEntity<>(deleted,HttpStatus.OK);
	}
	
}
