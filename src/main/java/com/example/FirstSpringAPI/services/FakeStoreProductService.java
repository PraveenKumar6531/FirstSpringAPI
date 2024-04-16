package com.example.FirstSpringAPI.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.FirstSpringAPI.Models.Category;
import com.example.FirstSpringAPI.Models.Product;
import com.example.FirstSpringAPI.dtos.FakeStoeProductDTO;

@Service
public class FakeStoreProductService implements ProductService{
	private RestTemplate restTemplate;
	
	FakeStoreProductService(RestTemplate restTemplate){
		this.restTemplate = restTemplate;
	}

	private Product convertFakeStoreProductToProduct(FakeStoeProductDTO dto) {
		Product product = new Product();
		product.setId(dto.getId());
		product.setTitle(dto.getTitle());
		product.setPrice(dto.getPrice());
		product.setDescription(dto.getDescription());
		product.setImage(dto.getImage());
		Category category = new Category();
		category.setDescription(dto.getCategory());
		product.setCategory(category);
		
		return product;
		
	}
	@Override
	public Product getProductById(Long id) {
		restTemplate.getForObject("https://fakestoreapi.com/products"+id, FakeStoeProductDTO.class);
		return convertFakeStoreProductToProduct(null);
	}

	@Override
	public List<Product> getAllProducts() {
		
		return new ArrayList<Product>();
	}

}
