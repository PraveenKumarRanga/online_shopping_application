package com.masaischool.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masaischool.model.Category;
import com.masaischool.model.Product;
import com.masaischool.service.ProductServiceImpl;

@RestController
public class ProductController {

	private ProductServiceImpl service;
	
	

	public ProductController(ProductServiceImpl service) {
		super();
		this.service = service;
	}
	
	
	@PostMapping("/add_products_with_new_category")
	public ResponseEntity<Category> addProductToNewCategory(@RequestBody Category category){
		
		List<Product> prod = category.getProduct();
		
		if(prod != null) {
			
			for(Product p : prod) {
				p.setCategory(category);
			}
		}
		
		return new ResponseEntity<Category>(service.addProductToNewCategory(category),HttpStatus.CREATED);
	}
	
	@PostMapping("/add_products_to_category/{categoryId}")
	public ResponseEntity<Product> addProductToCategory(@PathVariable Integer categoryId,
			@RequestBody Product product){
	
		
		
		Product prod = service.addProductToOldCategory(categoryId, product);
		
		return new ResponseEntity<>( prod,HttpStatus.CREATED);
	}
	
	@PutMapping("/update_product/{product_id}")
	public ResponseEntity<Product> updateProductById(@PathVariable Integer product_id,
			@RequestBody Product product){
	
		
		
		Product prod = service.addProductToOldCategory(product_id, product);
		
		return new ResponseEntity<>( prod,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts(){
		
		return new ResponseEntity<List<Product>>(service.getAllProducts(),HttpStatus.OK);
	}
	
//	@GetMapping("/get_product_by_category_name/{category_name}")
//	public ResponseEntity<Product> getProductByCategoryName(@PathVariable String category_name){
//		
//		
//		
//		return new ResponseEntity<Product>(service.getProductByCategoryName(category_name),HttpStatus.OK);
//	}
	
	
	@GetMapping("/products/{product_id}")
	public ResponseEntity<Product> getProductById(@PathVariable Integer product_id){
	
		
		
		return new ResponseEntity<>(service.getProductById(product_id),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/products/{product_id}")
	public ResponseEntity<Product> deleteProductById(@PathVariable Integer product_id){
	
		
		
		return new ResponseEntity<>(service.deleteProductById(product_id),HttpStatus.CREATED);
	}
	
	
}









