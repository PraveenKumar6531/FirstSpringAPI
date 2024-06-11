package com.example.FirstSpringAPI;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.FirstSpringAPI.Models.Category;
import com.example.FirstSpringAPI.projections.ProductWithTitleAndDescription;
import com.example.FirstSpringAPI.repositories.CategoryRepository;
import com.example.FirstSpringAPI.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class FirstSpringApiApplicationTests {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void sampleTest(){
//		Optional<Category> optionalCategory = categoryRepository.findById(2L);
//		Category category = optionalCategory.get();
//
//		ProductWithTitleAndDescription product = productRepository.someRandomQuery(2L);
//		System.out.println("Title :"+ product.getTitle());
//		System.out.println("Description :"+ product.getDescription());


	}

}
