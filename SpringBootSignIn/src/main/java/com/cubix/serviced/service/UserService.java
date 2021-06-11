package com.cubix.serviced.service;



import com.cubix.serviced.model.User;

public interface UserService {
  
 public User findUserByEmail(String email);
 
 public void saveUser(User user);
}