package com.example.FirstSpringAPI.services;

import java.util.List;

import com.example.FirstSpringAPI.Models.Product;

public interface ProductService {

	public Product getProductById(Long id);
	
	public List<Product> getAllProducts();
}
