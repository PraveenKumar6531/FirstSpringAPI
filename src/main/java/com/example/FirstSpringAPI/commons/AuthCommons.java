package com.example.FirstSpringAPI.commons;

import com.example.FirstSpringAPI.Models.Product;
import com.example.FirstSpringAPI.dtos.FakeStoeProductDTO;
import com.example.FirstSpringAPI.dtos.UserDto;
import com.example.FirstSpringAPI.exceptions.ProductNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthCommons {
    private RestTemplate restTemplate;
    public AuthCommons(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public UserDto validateToken(String tokenValue) throws ProductNotFoundException {
        ResponseEntity<UserDto> responseEntity = restTemplate.getForEntity("http://localhost:4141/users/validate/" + tokenValue, UserDto.class);
        if (responseEntity.getBody() == null) {
            return null;
        }
        return responseEntity.getBody();
    }
}
