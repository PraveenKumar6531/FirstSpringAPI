package com.example.FirstSpringAPI.services;

import java.util.List;

import com.example.FirstSpringAPI.Models.Product;
import com.example.FirstSpringAPI.exceptions.ProductNotFoundException;
import org.springframework.http.ResponseEntity;

public interface ProductService {

	//public ResponseEntity<Product> getProductById(Long id) throws Exception;

	public Product getProductById(Long id) throws ProductNotFoundException;
	
	public List<Product> getAllProducts();

	public Product replaceProduct(Long id, Product product);

	public Product createProduct(Product product);

	public void deleteProduct();


}
