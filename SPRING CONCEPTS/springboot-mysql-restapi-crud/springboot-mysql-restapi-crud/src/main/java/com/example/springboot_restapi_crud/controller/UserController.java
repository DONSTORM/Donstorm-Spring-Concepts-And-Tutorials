package com.example.springboot_restapi_crud.controller;

import com.example.springboot_restapi_crud.entity.User;
import com.example.springboot_restapi_crud.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
        User user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId, @RequestBody User user){
        user.setId(userId);
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        String deletedUser = userService.deleteUser(userId);
        return new ResponseEntity<>(deletedUser, HttpStatus.OK);
    }

    @RequestMapping("/usersFirstName")
    public ResponseEntity<User> getUserByFirstName(@RequestParam(name = "firstName") String firstName, User user){
        System.out.println("getUserByFirstName");
        user = userService.getUserByFirstName(firstName);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
