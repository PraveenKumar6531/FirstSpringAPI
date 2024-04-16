package com.example.FirstSpringAPI.services;

import java.io.InvalidClassException;
import java.util.List;

import com.example.FirstSpringAPI.Models.Product;

public interface ProductService {

	public Product getProductById(Long id) throws Exception;
	
	public List<Product> getAllProducts();
}
