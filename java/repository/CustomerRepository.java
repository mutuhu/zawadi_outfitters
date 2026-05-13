package com.zawadi.distributors.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zawadi.distributors.model.Customer;

public interface CustomerRepository
extends JpaRepository<Customer,Long>{

Customer findByEmail(String email);

}