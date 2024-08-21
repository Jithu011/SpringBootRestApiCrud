package com.nexential.crud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="emp")
public class User {
	@Id
	@GeneratedValue
private int id;
	@Column(name="NAME")
private String name;
	@Column(name="ADDRESS")
private String address;
public User() {
	
}
public User(int id, String name, String address) {
	super();
	this.id = id;
	this.name = name;
	this.address = address;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
}
