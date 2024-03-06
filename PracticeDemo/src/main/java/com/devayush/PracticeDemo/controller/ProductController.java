package com.devayush.PracticeDemo.controller;

import com.devayush.PracticeDemo.entity.Product;
import com.devayush.PracticeDemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public String saveProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return "Product saved successfully";
    }
}
