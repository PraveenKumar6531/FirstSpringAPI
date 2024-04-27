package com.example.FirstSpringAPI.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
	public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws Exception {
		return productService.getProductById(id);		
	}
	
	@GetMapping
	public List<Product> getProducts(){
		return productService.getAllProducts();
	}

	@PutMapping("/{id}")
	public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
		return productService.replaceProduct(id, product);
	}
}
