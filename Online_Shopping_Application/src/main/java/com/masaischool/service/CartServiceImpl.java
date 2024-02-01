package com.masaischool.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.masaischool.exception.NotFoundException;
import com.masaischool.model.Cart;
import com.masaischool.model.Product;
import com.masaischool.repository.CartRepo;
import com.masaischool.repository.ProductRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CartServiceImpl implements CartService{

	private CartRepo cartRepo;
	
	private ProductRepo prodRepo;
	
	
	public CartServiceImpl(CartRepo cartRepo, ProductRepo prodRepo) {
		super();
		this.cartRepo = cartRepo;
		this.prodRepo = prodRepo;
	}



	@Override
	public Cart addProductToCart(Integer cartId, Integer productId, Integer quantity) {
		
		Product product = prodRepo.findById(productId).orElseThrow(EntityNotFoundException::new);
		Cart cart = cartRepo.findById(cartId).orElseThrow(EntityNotFoundException::new);
		
//		if(product != null && cart != null) {
//			CartProduct cartProduct = new CartProduct();
//			cartProduct.setCart(cart);
//			cartProduct.setProduct(product);
//			cartProduct.setQuantity(quantity);
//			
//			Set<CartProduct> cartPro = cart.getCartProduct();
//			cartPro.add(cartProduct);
//			
//			cart.setCartProduct(cartPro);
//			
//			return cartRepo.save(cart);
//		}
		
		if(product.getQuantity() >= quantity) {
			cart.getProduct().add(product);
			product.setQuantity(product.getQuantity()-quantity);
			
			prodRepo.save(product);
			return cartRepo.save(cart);
		}
		else new NotFoundException("product quantity is low.");
		
		
		 
		return null;
	}

	@Override
	public Cart removeProductFromCart(Cart cart, Integer productId) {
		
		cart.getProduct().removeIf(p -> p.getProductId().equals(productId));
		return cart;
	}

	@Override
	public Cart updateProductQuantity(Cart cart, Integer productId, Integer quantity) {
		
		Optional<Product> exiProd = cart.getProduct().stream()
				.filter(p -> p.getProductId().equals(productId))
				.findFirst();
		
		if(exiProd.isPresent()) {
			exiProd.get().setQuantity(quantity);
		}
		
		return cart;
	}

	@Override
	public Cart removeAllProducts(Cart cart) {
		cart.getProduct().clear();
		return cart;
	}

	@Override
	public List<Product> viewAllProductsInCart(Integer cartId) {
		
//		Optional<Cart> cartOpn = cartRepo.findById(cartId);
//		
//		if(cartOpn.isPresent()) {
//			Cart cart = cartOpn.get();
//			
//			return new ArrayList<>(cart.get);
//		}
//		else {
//			return Collections.emptyList();
//		}
		return Collections.emptyList();

	}

}