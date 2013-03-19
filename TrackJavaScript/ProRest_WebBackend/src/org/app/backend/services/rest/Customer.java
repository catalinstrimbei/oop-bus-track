package org.app.backend.services.rest;

import java.util.Date;

class Customer{
	// id
	private Long id;
	// details
	private String name;
	private String email;
	private String accountState;
	private Double sold;
	private Date registrationDate = new Date();
	// address
	private String city;
	private String zipcode;
	private String address;
	
	// encapsulation
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Customer(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Customer() {
		super();
	}
	
	
}