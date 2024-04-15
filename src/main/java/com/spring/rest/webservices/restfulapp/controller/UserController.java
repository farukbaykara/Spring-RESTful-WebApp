package com.spring.rest.webservices.restfulapp.controller;


import com.spring.rest.webservices.restfulapp.model.User;
import com.spring.rest.webservices.restfulapp.service.UserDaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

  private UserDaoService userDaoService;

  public UserController(UserDaoService userDaoService) {
    this.userDaoService = userDaoService;
  }


  @GetMapping(path = "/users")
  public List<User> getUsers() {
    return userDaoService.findAll();
  }

  @GetMapping(path = "/users/{id}")
  public ResponseEntity<User> getUser(@PathVariable int id) {

    User user = userDaoService.findOne(id);

    if(user == null){
      return ResponseEntity.status(404).build();
    }
    else {
      return ResponseEntity.status(200).body(user);
    }
  }


  @PostMapping(path = "/users")
  public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
    userDaoService.save(user);
    return ResponseEntity.status(201).body(user);
  }

  @DeleteMapping(path = "/users/{id}")
  public void deleteUser(@PathVariable int id) {
    userDaoService.deleteById(id);
  }




}
