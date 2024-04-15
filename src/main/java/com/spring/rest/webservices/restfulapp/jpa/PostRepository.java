package com.spring.rest.webservices.restfulapp.jpa;

import com.spring.rest.webservices.restfulapp.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

  
}
