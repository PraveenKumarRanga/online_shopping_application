package com.masaischool.service;

import java.util.List;

import com.masaischool.model.Customer;

public interface CustomerService {

	public Customer addCustomer(Customer customer);
	
	public Customer updateCustomer(Integer customerId, Customer customer);
	
	public Customer deleteCustomer(Integer customerId);
	
	public Customer getCustomerById(Integer customerId);
	
	public List<Customer> getAllCustomer();
	
}
