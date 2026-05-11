package com.zawadi.distributors.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zawadi.distributors.model.Product;
import com.zawadi.distributors.repository.ProductRepository;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*") // allows frontend later
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // GET all products OR filter by school
    @GetMapping
    public List<Product> getProducts(@RequestParam(required = false) String school) {
        if (school == null) {
            return productRepository.findAll();
        }
        return productRepository.findBySchool(school);
    }

    // POST: add product (admin use later)
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

}
