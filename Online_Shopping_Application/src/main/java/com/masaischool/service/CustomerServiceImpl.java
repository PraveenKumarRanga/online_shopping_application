package com.masaischool.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.masaischool.exception.NotFoundException;
import com.masaischool.model.Customer;
import com.masaischool.repository.CustomerRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService{

	private CustomerRepo customerRepo;

	public CustomerServiceImpl(CustomerRepo customerRepo) {
		super();
		this.customerRepo = customerRepo;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		
	
		
		return customerRepo.save(customer);
	}

	@Override
	public Customer updateCustomer(Integer customerId, Customer customer) {
		
		Optional<Customer> cust = customerRepo.findById(customerId);
		
		if(cust.isPresent()) {
			return customerRepo.save(customer);
		}
		
		throw new NotFoundException("customer not found for given customer_id");
	}

	@Override
	public Customer deleteCustomer(Integer customerId) {
		
		Optional<Customer> exist = customerRepo.findById(customerId);
		
		if(exist.isPresent()) {
			customerRepo.deleteById(customerId);
			log.info("customer deleted successfully");
			return exist.get();
		}
		
		throw new NotFoundException("customer not found");
		
	}

	@Override
	public Customer getCustomerById(Integer customerId) {

		Optional<Customer> exist = customerRepo.findById(customerId);
		
		if(exist.isPresent()) {
			
			log.info("customer retrived successfully");
			return exist.get();
		}
		
		throw new NotFoundException("customer not found");
	}

	@Override
	public List<Customer> getAllCustomer() {
		
		List<Customer> list = customerRepo.findAll();
		
		if(list.size() != 0) {
			return list;
		}
		throw new NotFoundException("customer list is empty");
		
	}

}
