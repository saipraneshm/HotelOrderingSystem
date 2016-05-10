package com.cmpe275.domain;




import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {

	@Id
	@Column(name = "orderId", nullable=false)
	private String orderId;
	
	
	@Column(nullable=true)
    private Date ordered_time;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userId")
	private User user;
	
	@OneToMany(mappedBy = "order")
	private List<Orders_Menu> ordersMenu;
	
	public List<Orders_Menu> getOrdersMenu() {
		return ordersMenu;
	}
	public void setOrdersMenu(List<Orders_Menu> ordersMenu) {
		this.ordersMenu = ordersMenu;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	public Date getOrdered_time() {
		return ordered_time;
	}
	public void setOrdered_time(Date ordered_time) {
		this.ordered_time = ordered_time;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}


