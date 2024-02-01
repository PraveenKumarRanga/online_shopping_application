package com.masaischool.service;

import java.util.List;
import java.util.Optional;

import com.masaischool.model.Category;
import com.masaischool.model.Product;

public interface ProductService {

	public Category addProductToNewCategory(Category category); // to add product to category, category needs to be added
	
	public Product addProductToOldCategory(Integer categoryId, Product product);
	
	public Product updateProduct(Integer productId, Product product);
	
	public List<Product> getAllProducts();
	
	public Optional<List<Product>> getProductByCategory(String cName);
	
	public Product getProductById(Integer productId);
	
	public Product deleteProductById(Integer productId);
	
}
