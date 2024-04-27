package com.example.FirstSpringAPI.services;

import java.util.List;

import com.example.FirstSpringAPI.Models.Product;
import org.springframework.http.ResponseEntity;

public interface ProductService {

	public ResponseEntity<Product> getProductById(Long id) throws Exception;
	
	public List<Product> getAllProducts();

	public Product replaceProduct(Long id, Product product);
}
