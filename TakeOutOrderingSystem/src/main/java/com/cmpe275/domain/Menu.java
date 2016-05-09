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
@Table(name="menu")
public class Menu {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name = "menuId", nullable=false)
	private int menuId;
	
	
	@Column(nullable=false)
    private String name;
	
	@Column(nullable=false)
    private String imagePath;
	
	@Column(nullable=false)
    private double unitPrice;
	
	@Column(nullable=false)
    private int calories;
	
	@Column(nullable=false)
    private String preparationTime;
	
	@Column(nullable=false)
    private String category;
	
	
	
	@OneToMany(mappedBy = "menu" )
	private List<Orders_Menu> ordersMenu;

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public String getPreparationTime() {
		return preparationTime;
	}

	public void setPreparationTime(String preparationTime) {
		this.preparationTime = preparationTime;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
}
