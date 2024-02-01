package com.masaischool.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	
	@Column(nullable = false)
	private String productName;
	
	@Column(nullable = false)
	private Double price;
	
	@Column(nullable = false)
	private String color;
	
	private String dimension;
	
	@Column(nullable = false)
	private String specification;
	
	@Column(nullable = false)
	private String manufacturer;
	
	private Integer quantity;	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
//	@ManyToMany(mappedBy = "product")
//	private Set<Cart> carts = new HashSet<>();
	
	

	public Product(String productName, Double price, String color, String dimension, String specification,
			String manufacturer, Integer quantity, Category category) {
		super();
		this.productName = productName;
		this.price = price;
		this.color = color;
		this.dimension = dimension;
		this.specification = specification;
		this.manufacturer = manufacturer;
		this.quantity = quantity;
		this.category = category;
	}


	
	
}





