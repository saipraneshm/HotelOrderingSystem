package com.cmpe275.domain;

import java.util.Date;

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
@Table(name = "order_menu")
public class Orders_Menu {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name = "ordermenuid", nullable=false)
	private int orderId;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MENU_ID")
	private Menu menu;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ORDER_ID")
	private Order order;
	
	
	private int quantity;


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public Menu getMenu() {
		return menu;
	}


	public void setMenu(Menu menu) {
		this.menu = menu;
	}


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
