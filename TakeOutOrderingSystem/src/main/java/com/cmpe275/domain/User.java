package com.cmpe275.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	
	public User(){
		
	}
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name = "userId", nullable=false)
	private int userId;
	
	
	@Column(nullable=false)
    private String firstname;
	
	@Column(nullable=true)
    private String lastname;
	
	@Column(nullable=false, unique =true)
    private String email;
	
	@Column(nullable=true)
    private String password;
	
	@Column(nullable=true)
    private int phone;
	
	@Column(nullable=true)
    private String address;
	
	@Column(nullable=true, columnDefinition="INT(1) default 0")
    private int status;
	
	@Column(nullable=true)
    private int activationCode;
	
	@OneToMany(mappedBy="user")
	private List<Order> orders;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public int getActivationCode() {
		return activationCode;
	}

	public void setActivationCode(int activationCode) {
		this.activationCode = activationCode;
	}
}
