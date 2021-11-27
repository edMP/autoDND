package com.dew.mastertrick.controllers;

import com.dew.mastertrick.repositoires.CharacterRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharactersControllers {
    @Autowired
    CharacterRepository characterRepository;

    @GetMapping(value = "/characters")
        public ResponseEntity<Object>characterList(){
        return new ResponseEntity<>(characterRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/character/add")
        public void newCharacter(@RequestParam("level")int level,
                                 @RequestParam("name")String name,
                                 @RequestParam("race")String race,
                                 @RequestParam("strength")int strength,
                                 @RequestParam("dexterity")int constitution,
                                 @RequestParam("intelligence")int intelligence,
                                 @RequestParam("wisdom")int wisdom,
                                 @RequestParam("charisma")int charisma,
                                 @RequestParam("alignement")String alignement,
                                 @RequestParam("hit_dice")String hit_dice,
                                 @RequestParam("psersonality_trails")String personality_trails,
                                 @RequestParam("ideals")String ideals,
                                 @RequestParam("profeci_bonus")int profeci_bonus,
                                 @RequestParam("mobility")int mobility,
                                 @RequestParam("lenguage")String lenguage,
                                 @RequestParam("bound")String bound,
                                 @RequestParam("alter")User user){

    }

}
