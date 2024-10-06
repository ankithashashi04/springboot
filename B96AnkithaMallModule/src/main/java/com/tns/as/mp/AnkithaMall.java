package com.tns.as.mp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity //@Entity annotation is used in the context of Java Persistence API (JPA) to specify that a class is an entity and is mapped to a database table
public class AnkithaMall {  // mall Id as primary key
	private int id;
	private String mallAdmin;
	private String mallName;
	private String location;
	private String categories;
	private String password;
	
	
	
	
	public AnkithaMall() {
		super();
	}




	public AnkithaMall(int id, String mallAdmin, String mallName, String location, String categories, String password) {
		super();
		this.id = id;
		this.mallAdmin = mallAdmin;
		this.mallName = mallName;
		this.location = location;
		this.categories = categories;
		this.password = password;
	}



@Id // @Id annotation is used to specify the primary key of an entity class.A primary key uniquely identifies each record in a database table, and it is essential for database operations such as CRUD records.
	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getMallAdmin() {
		return mallAdmin;
	}




	public void setMallAdmin(String mallAdmin) {
		this.mallAdmin = mallAdmin;
	}




	public String getMallName() {
		return mallName;
	}




	public void setMallName(String mallName) {
		this.mallName = mallName;
	}




	public String getLocation() {
		return location;
	}




	public void setLocation(String location) {
		this.location = location;
	}




	public String getCategories() {
		return categories;
	}




	public void setCategories(String categories) {
		this.categories = categories;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	@Override //indicates that a method is overriding a method from a superclass or implementing a method from an interface
	public String toString() {
		return "AnkithaMall [id=" + id + ", mallAdmin=" + mallAdmin + ", mallName=" + mallName + ", location="
				+ location + ", categories=" + categories + ", password=" + password + ", getId()=" + getId()
				+ ", getMallAdmin()=" + getMallAdmin() + ", getMallName()=" + getMallName() + ", getLocation()="
				+ getLocation() + ", getCategories()=" + getCategories() + ", getPassword()=" + getPassword()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}



}
	
	
	
	
	