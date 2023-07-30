package com.vsk.stsweb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "employees")
public class Employee {
	
	@Id
	@Field("id")
	private String id;
	private String name;
	private String phone;
	private String email;
	private String reportsTo;
	private String image;
	
	
	public Employee(String id, String name, String phone, String email, String reportsTo, String image) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.reportsTo = reportsTo;
		this.image = image;
	}


	public Employee() {
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getReportsTo() {
		return reportsTo;
	}


	public void setReportsTo(String reportsTo) {
		this.reportsTo = reportsTo;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}
	
	

}
