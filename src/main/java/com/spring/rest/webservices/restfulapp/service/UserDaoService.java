package com.spring.rest.webservices.restfulapp.service;


import com.spring.rest.webservices.restfulapp.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

  private static List<User> users = new ArrayList<>();

  static {
  }

  public List<User> findAll(){
    return users;
  }

  public User findOne(int id) {
    Predicate<? super User> predicate = user -> user.getId().equals(id);
    return users.stream().filter(predicate).findAny().orElse(null);
  }

  public void save(User user) {
    users.add(user);
  }

  public void deleteById(int id) {
    Predicate<? super User> predicate = user -> user.getId().equals(id);
    users.removeIf(predicate);
  }


}
