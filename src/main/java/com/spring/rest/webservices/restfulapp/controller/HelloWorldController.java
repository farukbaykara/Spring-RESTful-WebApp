package com.spring.rest.webservices.restfulapp.controller;


import com.spring.rest.webservices.restfulapp.model.HelloWorld;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

  @GetMapping(path = "/hello-world")
  public String helloWorld() {
    return "Hello World";
  }

  @GetMapping(path = "/hello-world-bean")
  public HelloWorld helloWorldBean() {
    return new HelloWorld("Hello World");
  }

  @GetMapping(path = "/hello-world-bean/{name}")
  public HelloWorld helloWorldBeanPathVariable(@PathVariable String name) {
    return new HelloWorld(String.format("Hello World, %s", name));
  }

}
