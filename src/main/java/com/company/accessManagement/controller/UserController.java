package com.company.accessManagement.controller;

import com.company.accessManagement.dto.CreateUser;
import com.company.accessManagement.entity.UserEntity;
import com.company.accessManagement.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public UserEntity addUser(@RequestBody CreateUser user){
        return userService.createUser(user);

    }

    @GetMapping("users")
    public List<UserEntity> getUsers(){
        return userService.getAll();
    }
}
