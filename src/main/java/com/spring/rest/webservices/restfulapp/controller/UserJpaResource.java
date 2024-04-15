package com.spring.rest.webservices.restfulapp.controller;


import com.spring.rest.webservices.restfulapp.jpa.PostRepository;
import com.spring.rest.webservices.restfulapp.model.Post;
import com.spring.rest.webservices.restfulapp.model.User;
import com.spring.rest.webservices.restfulapp.jpa.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserJpaResource {

  private UserRepository userRepository;

  private PostRepository post;
  private final PostRepository postRepository;

  public UserJpaResource(UserRepository userRepository,
                         PostRepository postRepository) {
    this.userRepository = userRepository;
    this.postRepository = postRepository;
  }

  @GetMapping("/jpa/users")
  public List<User> getUserList() {
    return userRepository.findAll();
  }

  @GetMapping("/jpa/users/{id}")
  public ResponseEntity<User> getUserById(@PathVariable int id) {

    Optional<User> user = userRepository.findById(id);

    if(user.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    else{
      return ResponseEntity.ok(user.get());
    }

  }

  @GetMapping("/jpa/users/name")
  public ResponseEntity<List<User>> getUserByName(@RequestParam String name) {

    return ResponseEntity.ok().body(userRepository.findByName(name));
  }

  @GetMapping("/jpa/users/{id}/posts")
  public ResponseEntity<List<Post>> getUserPosts(@PathVariable int id) {

    Optional<User> user = userRepository.findById(id);

    if(user.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    else{
      return ResponseEntity.ok(user.get().getPosts());
    }

  }

  @PostMapping("/jpa/users/{id}/posts")
  public ResponseEntity<Post> createUserPost(@RequestParam("_csrf") CsrfToken csrfToken,@PathVariable int id, @Valid @RequestBody Post post) {

    Optional<User> user = userRepository.findById(id);

    if(user.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    else{
      post.setUser(user.get());
      Post savedPost = postRepository.save(post);
      return ResponseEntity.status(201).body(savedPost);
    }

  }

  @PostMapping("/jpa/users")
  public User createUser(@RequestBody User user) {
    User savedUser = userRepository.save(user);
    return savedUser;
  }


  @GetMapping("/token")
  public ResponseEntity<CsrfToken> getToken(HttpServletRequest request){

    CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());

    return ResponseEntity.status(200).body(csrfToken);
  }


}
