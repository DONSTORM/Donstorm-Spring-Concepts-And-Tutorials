package com.example.springboot_restapi_crud.repository;

import com.example.springboot_restapi_crud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByFirstName(String firstName);
}
