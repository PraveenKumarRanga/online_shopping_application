package com.masaischool.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Pattern.Flag;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	
	@Column(nullable = false)
	@Pattern(regexp = "[a-z]+", message = "name accepts alphabets only")
	private String firstname;
	
	@Pattern(regexp = "[a-z]+", message = "name accepts alphabets only")
	private String lastname;
	
	@Column(unique = true ,nullable = false)
	@Pattern(regexp = "[a-z0-9.]+@[a-z0-9]+\\.[a-z]{2,3}", flags = Flag.CASE_INSENSITIVE, 
	message = "invalid pattern")
	private String email;
	
	@Column(unique = true, nullable = false)
	@Pattern(regexp = "[0-9]+", message = "mobile number accepts only digits")
	@Size(max = 10)
	private String mobileNum;
	
	@NotNull(message="address can't be null")
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Address> address;
	
	@NotNull(message="User password and role can't be null")
	@OneToOne(mappedBy = "customer",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private User user;
	
	@NotNull(message="Cart can't be null")
	@OneToOne(mappedBy = "customer",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Cart cart;
	
	@JsonIgnore
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Orders> order;

	public Customer(String firstname, String lastname, String email, String mobileNum,
			List<Address> address, User user, Cart cart, List<Orders> order) {
		super();
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.mobileNum = mobileNum;
		this.address = address;
		this.user = user;
		this.cart = cart;
		this.order = order;
		
	}
	
	
	
	
}
