package com.masaischool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masaischool.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}
