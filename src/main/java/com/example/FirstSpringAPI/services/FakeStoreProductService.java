package com.example.FirstSpringAPI.services;

import java.util.ArrayList;
import java.util.List;

import com.example.FirstSpringAPI.exceptions.ProductNotFoundException;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import com.example.FirstSpringAPI.Models.Category;
import com.example.FirstSpringAPI.Models.Product;
import com.example.FirstSpringAPI.dtos.FakeStoeProductDTO;

@Service("fakeStoreProductService")
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
	public Product getProductById(Long id) throws ProductNotFoundException {
		//int a = 1/0;
		ResponseEntity<Product> responseEntity;
		FakeStoeProductDTO fakeStoreProductDto =
				restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoeProductDTO.class);
		 if (fakeStoreProductDto == null) {
			 throw new ProductNotFoundException("Product with id "+id+" not found");
		 }

		Product product = convertFakeStoreProductToProduct(fakeStoreProductDto);
		 responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
	        //Convert fakeStoreProductDto to product object.
	        return product;
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

	@Override
	public Product replaceProduct(Long id, Product product) {
		FakeStoeProductDTO fakeStoeProductDTO = new FakeStoeProductDTO();
		fakeStoeProductDTO.setImage(product.getImage());
		fakeStoeProductDTO.setTitle(product.getTitle());
		fakeStoeProductDTO.setDescription(product.getDescription());
		RequestCallback requestCallback = restTemplate.httpEntityCallback(fakeStoeProductDTO, FakeStoeProductDTO.class);
		HttpMessageConverterExtractor<FakeStoeProductDTO> responseExtractor = new HttpMessageConverterExtractor(FakeStoeProductDTO.class, restTemplate.getMessageConverters());
		FakeStoeProductDTO response =  restTemplate.execute("https://fakestoreapi.com/products/" + id, HttpMethod.PUT, requestCallback, responseExtractor);

		return convertFakeStoreProductToProduct(response);
	}

	@Override
	public Product createProduct(Product product) {
		return null;
	}

	@Override
	public void deleteProduct() {

	}

}
