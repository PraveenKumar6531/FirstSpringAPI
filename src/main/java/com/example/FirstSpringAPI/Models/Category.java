package com.example.FirstSpringAPI.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {
	private Long id;
	private String description;
	public Category(Long id, String description) {
		super();
		this.id = id;
		this.description = description;
	}
	
	public Category() {
		
	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
}
