package com.spring.rest.webservices.restfulapp.controller;


import com.spring.rest.webservices.restfulapp.model.PersonV1;
import com.spring.rest.webservices.restfulapp.model.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

  @GetMapping(path = "/person", params = "version=1")
  public PersonV1 getPerson() {
    return new PersonV1("John", "Doe");
  }

  @GetMapping(path = "/person", params = "version=2")
  public PersonV2 getPersonV2() {
    return new PersonV2("John", "Doe",11);
  }

  @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
  public PersonV1 getPersonHeader() {
    return new PersonV1("John", "Doe");
  }

  @GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
  public PersonV2 getPersonHeaderV2() {
    return new PersonV2("John", "Doe",11);
  }

  @GetMapping(path = "/person/produces", produces = "application/vnd.company.app-v1+json")
  public PersonV1 getPersonProduces() {
    return new PersonV1("John", "Doe");
  }

  @GetMapping(path = "/person/produces", produces = "application/vnd.company.app-v2+json")
  public PersonV2 getPersonProducesV2() {
    return new PersonV2("John", "Doe",11);
  }

}
