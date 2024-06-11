package com.example.FirstSpringAPI.Controllers;

import java.util.List;

import com.example.FirstSpringAPI.commons.AuthCommons;
import com.example.FirstSpringAPI.dtos.UserDto;
import com.example.FirstSpringAPI.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.FirstSpringAPI.Models.Product;
import com.example.FirstSpringAPI.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	public ProductService productService;
	private AuthCommons authCommons;
	public ProductController(@Qualifier("selfProductService") ProductService productService, AuthCommons authCommons) {
		this.productService = productService;
		this.authCommons = authCommons;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") Long id,@RequestHeader("authToken") String token) throws ProductNotFoundException {
		ResponseEntity<Product> responseEntity;
		//try {
		UserDto userDto =  authCommons.validateToken(token);

		if(userDto == null){
			responseEntity = new ResponseEntity<>(null,HttpStatus.FORBIDDEN);
			return responseEntity;
		}

        try {
            Product product = productService.getProductById(id);
			responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception e) {
            throw new ProductNotFoundException(e.getMessage());
        }
        //	}
//		catch(ArithmeticException ae){
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
		return responseEntity;
	}
	
	@GetMapping
	public List<Product> getProducts(){
		return productService.getAllProducts();
	}

	@PutMapping("/{id}")
	public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
		return productService.replaceProduct(id, product);
	}

	@PostMapping
	public Product createProduct(@RequestBody Product product){
		return productService.createProduct(product);
	}
}
