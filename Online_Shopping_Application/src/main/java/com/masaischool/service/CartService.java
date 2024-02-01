package com.masaischool.service;

import java.util.List;

import com.masaischool.model.Cart;
import com.masaischool.model.Product;

public interface CartService {

	public Cart addProductToCart(Integer cartId, Integer product, Integer quantity);
	
	public Cart removeProductFromCart(Cart cart, Integer product);
	
	public Cart updateProductQuantity(Cart cart, Integer product, Integer quantity);
	
	public Cart removeAllProducts(Cart cart);
	
	public List<Product> viewAllProductsInCart(Integer cart);
	
}
