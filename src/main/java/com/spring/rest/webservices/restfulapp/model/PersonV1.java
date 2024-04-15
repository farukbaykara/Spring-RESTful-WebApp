package com.spring.rest.webservices.restfulapp.model;



public class PersonV1 {

  private String name;
  private String surname;

  public PersonV1(String name, String surname) {
    this.name = name;
    this.surname = surname;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  @Override
  public String toString() {
    return "Person{" +
            "name='" + name + '\'' +
            ", surname='" + surname + '\'' +
            '}';
  }
}
