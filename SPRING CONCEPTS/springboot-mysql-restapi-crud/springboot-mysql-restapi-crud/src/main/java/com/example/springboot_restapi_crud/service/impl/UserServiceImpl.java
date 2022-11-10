package com.example.springboot_restapi_crud.service.impl;

import com.example.springboot_restapi_crud.entity.User;
import com.example.springboot_restapi_crud.repository.UserRepository;
import com.example.springboot_restapi_crud.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Override
    public User createUser(User user){
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId){
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.get();
    }

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user){
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
        return updatedUser;
    }

    @Override
    public String deleteUser(Long userId){
        User existingUser = userRepository.findById(userId).get();
        userRepository.deleteById(userId);
        return "Deleted User Successfully which was : \n\n"+existingUser.toString();
    }

    @Override
    public User getUserByFirstName(String firstName){
        User existingUser = userRepository.findByFirstName(firstName);
        return existingUser;
    }
}
