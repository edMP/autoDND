package com.dew.mastertrick.controllers;

import com.dew.mastertrick.model.Characters;
import com.dew.mastertrick.model.Users;
import com.dew.mastertrick.repositoires.CharacterRepository;
import com.dew.mastertrick.repositoires.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharactersControllers {
    @Autowired
    CharacterRepository characterRepository;

    @Autowired
    UserRespository userRespository;

    @GetMapping(value = "/characters")
        public ResponseEntity<Object>characterList(){
        return new ResponseEntity<>(characterRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/character/add")
        public ResponseEntity<Object> newCharacter(@RequestParam("level")int level,
                                 @RequestParam("name")String name,
                                 @RequestParam("profesion")String profesion,
                                 @RequestParam("race")String race,
                                 @RequestParam("strength")int strength,
                                 @RequestParam("dexterity")int dexterity,
                                 @RequestParam("constitution")int constitution,
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
                                 @RequestParam("nick")String nick){
        Users us=checkUser(nick);
        Characters ch= new Characters(level,name,profesion,race,strength,dexterity,constitution,intelligence,
                wisdom,charisma,alignement,hit_dice,personality_trails,ideals,profeci_bonus,mobility,lenguage,bound,
                userRespository.save(us));
        characterRepository.save(ch);
        return new ResponseEntity<>("new heroe"+ ch.getCharacter_name(),HttpStatus.OK);
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
