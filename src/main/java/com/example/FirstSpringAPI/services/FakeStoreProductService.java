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
	public Product getProductById(Long id) throws Exception {
		FakeStoeProductDTO fakeStoreProductDto =  
				restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoeProductDTO.class);
		 if (fakeStoreProductDto == null) {
	            throw new Exception("Invalid productId passed");
	        }

	        //Convert fakeStoreProductDto to product object.
	        return convertFakeStoreProductToProduct(fakeStoreProductDto);
	        //throw new RuntimeException("Something went wrong in FakeStoreProductService");
	}

	@Override
	public List<Product> getAllProducts() {
		FakeStoeProductDTO[] fakeStoreProductDtos =
	                restTemplate.getForObject("https://fakestoreapi.com/products/",
	                		FakeStoeProductDTO[].class);

	        List<Product> products = new ArrayList<>();
	        for (FakeStoeProductDTO fakeStoreProductDto : fakeStoreProductDtos) {
	            products.add(convertFakeStoreProductToProduct(fakeStoreProductDto));
	        }

	        return products;
	}

}
