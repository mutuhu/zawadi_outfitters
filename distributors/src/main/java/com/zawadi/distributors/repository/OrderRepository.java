package com.zawadi.distributors.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zawadi.distributors.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}