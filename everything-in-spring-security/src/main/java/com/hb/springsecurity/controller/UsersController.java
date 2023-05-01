package com.hb.springsecurity.controller;

import com.hb.springsecurity.entity.Users;
import com.hb.springsecurity.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UsersController {

    private UserService userService;

    @GetMapping("")
    public List<Users> getAllUsers(){
        return userService.findAll();
    }

    @PostMapping()
    public ResponseEntity<Users> createUser(@RequestBody Users user){
        userService.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
