package com.cmpe275.domain;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Order.class)
@Entity
@Table(name="orders")
public class Order implements Serializable{

	private int id;
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ORDER_ID")
	    public int getId() {
	        return id;
	    }
	 
	    public void setId(int id) {
	        this.id = id;
	    }
	
    private Date ordered_time;
    private Date pickupDate;
    private String pickupTime;
    private String status;
	
	
	private User user;
	
    private List<OrderMenu> menus;

    @Temporal(TemporalType.DATE)
	public Date getOrdered_time() {
		return ordered_time;
	}

	public void setOrdered_time(Date ordered_time) {
		this.ordered_time = ordered_time;
	}

	@ManyToOne
    @JoinColumn(name="USER_ID", nullable=false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@OneToMany(mappedBy = "order")
	public List<OrderMenu> getMenus() {
		return menus;
	}

	public void setMenus(List<OrderMenu> menus) {
		this.menus = menus;
	}

	@Temporal(TemporalType.DATE)
	public Date getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}

	public String getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(String pickupTime) {
		this.pickupTime = pickupTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
}