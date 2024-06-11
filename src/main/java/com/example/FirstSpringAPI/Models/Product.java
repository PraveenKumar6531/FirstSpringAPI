package com.example.FirstSpringAPI.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
	private String title;
	private String description;
	private double price;
	private String image;
	@ManyToOne //(cascade = CascadeType.ALL)
	private Category category;
	private int qty;

}
