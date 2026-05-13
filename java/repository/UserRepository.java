package com.zawadi.distributors.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zawadi.distributors.model.User;

public interface UserRepository
extends JpaRepository<User,Long>{

User findByEmail(String email);

}