package com.devayush.PracticeDemo.service;


import com.devayush.PracticeDemo.entity.Product;
import com.devayush.PracticeDemo.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import utils.LoggingInterceptor;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Autowired
    private RestTemplate restTemplate;
    public Product saveProduct(Product product) {
        Product response = restTemplate.postForObject("http://localhost:8088/test",
                product,
                Product.class);

        try {
        }catch (Exception e){
            e.printStackTrace();
        }
        return product;
    }
}
