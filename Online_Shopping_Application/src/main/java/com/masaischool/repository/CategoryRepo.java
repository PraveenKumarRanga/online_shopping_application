package com.masaischool.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masaischool.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

	Category findByCategoryId(Integer categoryId);

//	public Optional<Category> findCategoryByCategoryName(String categoryName);

}
