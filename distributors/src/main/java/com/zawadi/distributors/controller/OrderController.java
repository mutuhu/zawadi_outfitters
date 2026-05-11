package com.zawadi.distributors.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zawadi.distributors.model.Order;
import com.zawadi.distributors.model.OrderItem;
import com.zawadi.distributors.model.Product;
import com.zawadi.distributors.repository.OrderRepository;
import com.zawadi.distributors.repository.ProductRepository;

@RestController
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
private ProductRepository productRepository;

    @PostMapping("/orders")
public Order placeOrder(@RequestBody Order order) {

    // save order first
    Order savedOrder = orderRepository.save(order);

    // reduce stock for each item
    for (OrderItem item : order.getItems()) {

        Product product = productRepository.findByName(item.getProductName());

        if (product != null) {
            int newStock = product.getStock() - item.getQuantity();
            product.setStock(newStock);
            productRepository.save(product);
        }
    }

    return savedOrder;
}

@GetMapping("/orders")
public List<Order> getOrders(){
    return orderRepository.findAll();
    }
}