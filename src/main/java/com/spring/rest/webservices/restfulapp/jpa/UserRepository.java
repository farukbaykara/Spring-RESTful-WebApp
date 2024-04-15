package com.spring.rest.webservices.restfulapp.jpa;

import com.spring.rest.webservices.restfulapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
  List<User> findByName(String name);
}