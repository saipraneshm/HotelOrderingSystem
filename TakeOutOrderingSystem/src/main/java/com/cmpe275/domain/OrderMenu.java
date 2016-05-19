package com.cmpe275.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = OrderMenu.class)
@Entity
@Table(name="ORDER_MENU")
public class OrderMenu implements Serializable{
	 	private int id;
	    private Order order;
	    private Menu menu;
	     
	    // additional fields
	    private int quantity;

	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ORDER_MENU_ID")
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
          /* Changed from merge to ALL to PERSIST*/
		
		@ManyToOne
	    @JoinColumn(name = "ORDER_ID")
		public Order getOrder() {
			return order;
		}

		public void setOrder(Order order) {
			this.order = order;
		}
		
		
		@ManyToOne
	    @JoinColumn(name = "MENU_ID")
		public Menu getMenu() {
			return menu;
		}

		public void setMenu(Menu menu) {
			this.menu = menu;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
	    
}


