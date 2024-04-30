package com.example.FirstSpringAPI.Controllers;

import java.util.List;

import com.example.FirstSpringAPI.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.FirstSpringAPI.Models.Product;
import com.example.FirstSpringAPI.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	public ProductService productService;
	public ProductController(@Qualifier("selfProductService") ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
		//ResponseEntity<Product> responseEntity;
		//try {
        try {
            return productService.getProductById(id);
        } catch (Exception e) {
            throw new ProductNotFoundException(e.getMessage());
        }
        //	}
//		catch(ArithmeticException ae){
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
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
