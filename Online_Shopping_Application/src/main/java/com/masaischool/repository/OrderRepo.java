package com.masaischool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masaischool.model.Orders;

public interface OrderRepo extends JpaRepository<Orders, Integer>{

}
