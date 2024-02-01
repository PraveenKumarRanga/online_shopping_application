package com.masaischool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masaischool.model.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer>{

}
