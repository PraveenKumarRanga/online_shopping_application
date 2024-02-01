package com.masaischool.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartId;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "cart_product",
	joinColumns = @JoinColumn(name = "cart_id"),
	inverseJoinColumns = @JoinColumn(name = "product_id"))
	private Set<Product> product = new HashSet<>();

//	private Integer quantity;
	
//	@OneToMany(mappedBy = "cart")
//    private Set<Product> cartProduct = new HashSet<>();

	public Cart(Customer customer, Set<Product> product) {
		super();
		this.customer = customer;
		this.product = product;
//		this.quantity = quantity;

	}
	
	


	
	

	
	
}
