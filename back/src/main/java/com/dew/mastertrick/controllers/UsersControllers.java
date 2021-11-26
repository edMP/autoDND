package com.dew.mastertrick.controllers;

import com.dew.mastertrick.model.Users;
import com.dew.mastertrick.repositoires.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersControllers {
    @Autowired
    UserRespository userRespository;
    /*
    alta usuario
    delete usuario
     */
    @GetMapping(value="/users")
        public ResponseEntity<Object> usersList(){
            return new ResponseEntity<>(userRespository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/user/{nick}")
        public ResponseEntity<Object>serarchUser(@PathVariable("nick") String nick){
        return new ResponseEntity<>(userRespository.serarchUser(nick),HttpStatus.OK);

    }

    @DeleteMapping(value="/delteuser/{id}")
        public ResponseEntity<Object>delete(@PathVariable("id")Long id){
            userRespository.deleteById(id);
            return new ResponseEntity<>("el usuario  eliminado ",HttpStatus.OK);
    }

    @PostMapping(value ="/user/add")
        public ResponseEntity<Object>newUser(@RequestParam("nick")String nick,
                                             @RequestParam("name")String name,
                                             @RequestParam("last_name")String last_name,
                                             @RequestParam("password")String password,
                                             @RequestParam("email")String email){
        Users adduser=new Users(nick,name,last_name,password,email);
        userRespository.save(adduser);
        return new ResponseEntity<>("Bienvenido "+ nick,HttpStatus.OK);
    }



}
