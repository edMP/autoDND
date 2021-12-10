package com.dew.mastertrick.controllers;

import com.dew.mastertrick.model.Characters;
import com.dew.mastertrick.model.Users;
import com.dew.mastertrick.repositoires.BackgroundRepository;
import com.dew.mastertrick.repositoires.CharacterRepository;
import com.dew.mastertrick.repositoires.FlawRepository;
import com.dew.mastertrick.repositoires.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CharactersControllers {
    @Autowired
    CharacterRepository characterRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BackgroundRepository backgroundRepository;
    @Autowired
    FlawRepository flawRepository;


    @GetMapping(value = "/characters")
        public ResponseEntity<Object>characterList(){
        return new ResponseEntity<>(characterRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/character/add")
    public ResponseEntity<Object> newCharacter(@RequestBody Characters ch){

        //Users us=checkUser(ch.getAlter().getNick());
        //Backgrounds bc= new Backgrounds(backgrounds,description);
        ch.setBackgrounds(backgroundRepository.save(ch.getBackgrounds()));
        ch.setAlter((Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        characterRepository.save(ch);
        /*if(myFlaws.length>0){
            for(String a:myFlaws){
                Flaws fl= flawRepository.save(new Flaws(a));
                ch.sufFering(fl);
            }
        }*/
        return new ResponseEntity<>("new heroe"+ ch.getName(),HttpStatus.OK);
    }

    @GetMapping(value = "/currentcharacters/")
    private ResponseEntity<Object> currentUserChar(){
        return new ResponseEntity<>(
                characterRepository.userCharacters(SecurityContextHolder.getContext().getAuthentication().getName()),
                HttpStatus.OK);
    }

    @GetMapping(value = "/characters/{nick}")
    private ResponseEntity<Object> userChar(@PathVariable("nick")String nick){
        return new ResponseEntity<>(characterRepository.userCharacters(nick),HttpStatus.OK);
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



}
