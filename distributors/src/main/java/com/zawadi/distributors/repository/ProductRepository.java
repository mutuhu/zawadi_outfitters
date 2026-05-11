package com.zawadi.distributors.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zawadi.distributors.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // custom query: filter products by school
    List<Product> findBySchool(String school);
     Product findByName(String name);

}