package com.example.FirstSpringAPI.services;

import com.example.FirstSpringAPI.Models.Category;
import com.example.FirstSpringAPI.Models.Product;
import com.example.FirstSpringAPI.exceptions.ProductNotFoundException;
import com.example.FirstSpringAPI.repositories.CategoryRepository;
import com.example.FirstSpringAPI.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
@Primary
public class SelfProductService implements ProductService{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    SelfProductService(ProductRepository productRepository,CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("No Product with id:" + id);
        }
         return optionalProduct.get();

    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        //first save category
        Category category= product.getCategory();
        if(category.getId() == null){
            Category savedCategory = categoryRepository.save(category);
            product.setCategory(savedCategory);
        }
        Product savedProduct = productRepository.save(product);
        Optional<Category> optionalCategory = categoryRepository.findById(product.getCategory().getId());
        Category category1 = optionalCategory.get();
        savedProduct.setCategory(category1);
        return savedProduct;
    }

    @Override
    public void deleteProduct() {

    }
}
