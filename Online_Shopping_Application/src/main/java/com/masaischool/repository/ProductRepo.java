package com.masaischool.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masaischool.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

	public Optional<List<Product>> findByCategoryCategoryName(String categoryName);
	
}
