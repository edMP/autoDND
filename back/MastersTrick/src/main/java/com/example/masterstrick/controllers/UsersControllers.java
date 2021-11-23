package com.example.masterstrick.controllers;

import com.example.masterstrick.repositoires.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersControllers {
    @Autowired
    UserRespository userReposiroty;

    @GetMapping(value = "/users")
        public ResponseEntity<Object>userList(){
            return new ResponseEntity<>(userReposiroty.findAll(), HttpStatus.OK);
    }
}
