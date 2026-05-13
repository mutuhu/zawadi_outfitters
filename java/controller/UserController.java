package com.zawadi.distributors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zawadi.distributors.model.User;
import com.zawadi.distributors.repository.UserRepository;
@RestController
@RequestMapping("/user")
@CrossOrigin(origins="*")
public class UserController {

@Autowired
private UserRepository userRepository;

@PostMapping("/signup")
public User signup(
@RequestBody User user){
return userRepository.save(user);
}

@PostMapping("/login")
public User login(
@RequestBody User request){

User user =
userRepository.findByEmail(
request.getEmail()
);

if(user!=null &&
user.getPassword()
.equals(request.getPassword())){

return user;
}

return null;
}
}