package com.spring.rest.webservices.restfulapp.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name="POST")
public class Post {


  @Id
  @GeneratedValue
  private Integer id;

  @ManyToOne
  @JsonIgnore
  private User user;

  private String description;


  private String type;


  public Post() {
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Post(Integer id, User user,String description, String type) {
    this.id = id;
    this.description = description;
    this.type = type;
    this.user = user;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "Post{" +
            "id=" + id +
            ", description='" + description + '\'' +
            ", type='" + type + '\'' +
            '}';
  }
}
