package com.example.springboot_restapi_crud.service;

import com.example.springboot_restapi_crud.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(Long userId);
    List<User> getAllUsers();
    User updateUser(User user);
    String deleteUser(Long userId);
    User getUserByFirstName(String firstName);
}
