package com.wilsondevelopment.springwebcrudmysql.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.wilsondevelopment.springwebcrudmysql.entities.Address;

@Entity
public class Library {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	//Asociacion 1 a 1 con el objeto de Address
	@OneToOne
	@JoinColumn(name = "address_id")
	@JsonManagedReference
	private Address address;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Library() {
		
	}

	public Library(String name, Address address) {
		super();
		this.name = name;
		this.address = address;
	}
	
	
	
	
}
