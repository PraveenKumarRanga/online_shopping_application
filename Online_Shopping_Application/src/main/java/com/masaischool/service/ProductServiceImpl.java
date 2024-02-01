package com.masaischool.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.masaischool.exception.NotFoundException;
import com.masaischool.model.Category;
import com.masaischool.model.Product;
import com.masaischool.repository.CategoryRepo;
import com.masaischool.repository.ProductRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{

	private ProductRepo productRepo;
	private CategoryRepo cateRepo;
	
	
	public ProductServiceImpl(ProductRepo productRepo,CategoryRepo cateRepo) {
		super();
		this.productRepo = productRepo;
		this.cateRepo = cateRepo;
	}

	@Override
	public Category addProductToNewCategory(Category category) {

		return cateRepo.save(category);
	}
	


	@Override
	public Product updateProduct(Integer productId, Product product) {
		
		Optional<Product> exist = productRepo.findById(productId);
		
		if(exist.isPresent()) {
			return productRepo.save(product);
		}
		
		throw new NotFoundException("Product not found to update");
	}

	@Override
	public List<Product> getAllProducts() {
		
		List<Product> list = productRepo.findAll();
		
		if(list.size() == 0) {
			throw new NotFoundException("Product list is empty...");
		}
		
		return list;
	}

	@Override
	public Optional<List<Product>> getProductByCategory(String cName) {
		
//		Category cate = cateRepo.findByName(name);
		
		return productRepo.findByCategoryCategoryName(cName);
	}

	@Override
	public Product getProductById(Integer productId) {
		
		Optional<Product> product = productRepo.findById(productId);
		
		if(product.isPresent()) {
			
			return product.get();
		}
		throw new NotFoundException("Product not found by id : "+ productId);
		
	}

	@Override
	public Product deleteProductById(Integer productId) {
		
		Optional<Product> product = productRepo.findById(productId);
		
		if(product.isPresent()) {
			productRepo.deleteById(productId);
			return product.get();
		}
		throw new NotFoundException("Product not found by id : "+ productId);
	}
	@Override
	public Product addProductToOldCategory(Integer categoryId, Product product) {
		
		
		Category cateId = cateRepo.findByCategoryId(categoryId);
		
		if(cateId != null) {
			
		product.setCategory(cateId);
			
		}
		
		return productRepo.save(product);
	}

//	public Product getProductByCategoryName(String category_name) {
//		
//		Optional<Category> cName = cateRepo.findCategoryByCategoryName(category_name);
//		
//		if(cName.isPresent()) {
//			return productRepo.findByCategoryCategoryName(category_name);
//		}
//		
//		return null;
//	}



}
