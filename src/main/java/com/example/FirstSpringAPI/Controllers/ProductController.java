package com.example.FirstSpringAPI.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FirstSpringAPI.Models.Product;
import com.example.FirstSpringAPI.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	public ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable("id") Long id) {
		return new Product();		
	}
	
	@GetMapping()
	public List<Product> getProducts(){
		return productService.getAllProducts();
		
	}
}
