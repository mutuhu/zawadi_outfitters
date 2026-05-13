package com.zawadi.distributors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zawadi.distributors.model.Customer;
import com.zawadi.distributors.repository.CustomerRepository;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins="*")
public class CustomerController {

@Autowired
private CustomerRepository customerRepository;


@PostMapping("/signup")
public Customer signup(
@RequestBody Customer customer){

return customerRepository.save(customer);

}



@PostMapping("/login")
public Customer login(
@RequestBody Customer request){

Customer customer =
customerRepository.findByEmail(
request.getEmail()
);

if(
customer != null &&
customer.getPassword().equals(
request.getPassword()
)
){
return customer;
}

return null;

}

}