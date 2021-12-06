package com.dew.mastertrick.controllers;

import com.dew.mastertrick.model.Users;
import com.dew.mastertrick.repositoires.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersControllers {
    @Autowired
    UserRespository userRespository;
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



    @PostMapping(value = "/createuser")
    public ResponseEntity<Object>addUser(@RequestBody Users users){

        Users control=checkUser(users.getNick());
        if(control==null){
            Users adduser=new Users(users.getNick(),users.getName(),users.getLast_name(),users.getPassword(),users.getEmail());
            userRespository.save(adduser);
            return new ResponseEntity<>(true,HttpStatus.OK);
        }

        return new ResponseEntity<>(false,HttpStatus.OK);
    }

    private Users checkUser(String nick){
        Users cus= null;
        List<Users> seeUser=userRespository.serarchUser(nick);
        if(seeUser !=null && !seeUser.isEmpty()){
            for(Users user:seeUser){
                if(nick.equals(user.getNick())){
                    cus=user;
                }
            }
        }
        return cus;
    }

}
