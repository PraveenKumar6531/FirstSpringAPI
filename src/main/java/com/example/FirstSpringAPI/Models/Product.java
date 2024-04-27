package com.example.FirstSpringAPI.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

	private Long id;
	private String title;
	private String description;
	private double price;
	private String image;
	private Category category;
	
	public Product(Long id, String title, String description, double price, String image, Category category) {
		
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.image = image;
		this.category = category;
	}

//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public void setPrice(double price) {
//		this.price = price;
//	}
//
//	public void setImage(String image) {
//		this.image = image;
//	}
//
//	public void setCategory(Category category) {
//		this.category = category;
//	}

	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	
}
