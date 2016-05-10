package com.cmpe275.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "order_menu")
public class Orders_Menu {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name = "ordermenuid", nullable=false)
	private int orderMenuId;
	

	public int getOrderMenuId() {
		return orderMenuId;
	}


	public void setOrderMenuId(int orderMenuId) {
		this.orderMenuId = orderMenuId;
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


	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="MENU_ID")
	private Menu menu;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "ORDER_ID")
	private Order order;
	
	
	private int quantity;
	
	
}
