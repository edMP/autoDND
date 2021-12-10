package com.dew.mastertrick.controllers;

import com.dew.mastertrick.model.Users;
import com.dew.mastertrick.repositoires.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin("*")
public class UsersControllers {
    @Autowired
    UserRepository userRepository;
    @GetMapping(value="/users")
        public ResponseEntity<Object> usersList(){
            return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/user/{nick}")
        public ResponseEntity<Object>serarchUser(@PathVariable("nick") String nick){
        return new ResponseEntity<>(userRepository.serarchUser(nick),HttpStatus.OK);

    }

    @DeleteMapping(value="/delteuser/{id}")
        public ResponseEntity<Object>delete(@PathVariable("id")Long id){
            userRepository.deleteById(id);
            return new ResponseEntity<>("el usuario  eliminado ",HttpStatus.OK);
    }



    @PostMapping(value = "/createuser")
    public ResponseEntity<Object>addUser(@RequestBody Users users){

        Users control=checkUser(users.getNick());
        if(control==null){
            Users adduser=new Users(users.getNick(),users.getName(),users.getLast_name(),users.getPassword(),users.getEmail());
            userRepository.save(adduser);
            return new ResponseEntity<>(true,HttpStatus.OK);
        }

        return new ResponseEntity<>(false,HttpStatus.OK);
    }

    private Users checkUser(String nick){
        Users cus= null;
        List<Users> seeUser= userRepository.serarchUser(nick);
        if(seeUser !=null && !seeUser.isEmpty()){
            for(Users user:seeUser){
                if(nick.equals(user.getNick())){
                    cus=user;
                }
            }
        }
        return cus;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginData loginData) {

        String token = null;
        // Test user/password
        Users user = userRepository.findUserByNick(loginData.getNick())
            .orElseThrow(() -> new EntityNotFoundException("not found"));
        if(!(new BCryptPasswordEncoder().matches(loginData.getPassword(), user.getPassword())))
            throw new EntityNotFoundException("not found");
        // Compruebo que el usuario tenga token generado y no esté caducado...
        if(user.getToken() != null) {
            try {
                Jwts.parser().parse(user.getToken()).getBody();
                return new ResponseEntity<>("", HttpStatus.CONFLICT);
            } catch (Exception e) {
                user.setToken(null);
            }
        }
        // Generate token
//        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
//                .commaSeparatedStringToAuthorityList("ROLE_USER");
        String secretKey = "chatarra";
        // TODO: Investigar todos los parámetros
        token = Jwts
                .builder()
                .setId("IESRA")
                .setSubject(loginData.getNick())

                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 6000000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();
        user.setToken(token);
        userRepository.save(user);
        return new ResponseEntity<>(new AuthToken(token), HttpStatus.OK);
    }
    @GetMapping("/logout")
    public ResponseEntity<Object> logout() {
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        user.setToken(null);
        userRepository.save(user);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/currentusername")
    public ResponseEntity<Object> currentUsername() {
        HashMap<String, String> usernameData = new HashMap<>();
        usernameData.put("username", SecurityContextHolder.getContext().getAuthentication().getName());
        return new ResponseEntity<>(usernameData, HttpStatus.OK);
    }

}
