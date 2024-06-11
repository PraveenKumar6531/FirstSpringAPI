package com.example.FirstSpringAPI.Controllers;

import com.example.FirstSpringAPI.Models.Product;
import com.example.FirstSpringAPI.exceptions.ProductNotFoundException;
import com.example.FirstSpringAPI.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {
    @Autowired
    ProductController productController;

    @MockBean
    ProductService productService;

    @Test
    void testGetProductById() throws ProductNotFoundException {
//        Product p = new Product();
//        p.setId(1L);
//        p.setTitle("Macbook");
//        p.setPrice(15000);
//
//        when(productService.getProductById(1L)).thenReturn(p);
//
//        ResponseEntity<Product> responseEntity= productController.getProductById(1L,"");
//        assertEquals(p,responseEntity.getBody());
    }

}