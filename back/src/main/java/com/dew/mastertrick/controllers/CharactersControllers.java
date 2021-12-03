package com.dew.mastertrick.controllers;

import com.dew.mastertrick.model.Backgrounds;
import com.dew.mastertrick.model.Characters;
import com.dew.mastertrick.model.Flaws;
import com.dew.mastertrick.model.Users;
import com.dew.mastertrick.repositoires.BackgroundRepository;
import com.dew.mastertrick.repositoires.CharacterRepository;
import com.dew.mastertrick.repositoires.FlawRepository;
import com.dew.mastertrick.repositoires.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CharactersControllers {
    @Autowired
    CharacterRepository characterRepository;

    @Autowired
    UserRespository userRespository;

    @Autowired
    BackgroundRepository backgroundRepository;
    @Autowired
    FlawRepository flawRepository;


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
                                 @RequestParam("backgrounds")String backgrounds,
                                                   @RequestParam("desciption")String description,
                                 @RequestParam("nick")String nick,
                                 @RequestParam(value = "myFlaws")String[]myFlaws){

        Users us=checkUser(nick);
        Backgrounds bc= new Backgrounds(backgrounds,description);

        Characters ch= new Characters(level,name,profesion,race,strength,dexterity,constitution,intelligence,
                wisdom,charisma,alignement,hit_dice,personality_trails,ideals,profeci_bonus,mobility,lenguage,bound,backgroundRepository.save(bc),
                userRespository.save(us));
        characterRepository.save(ch);
        if(myFlaws.length>0){
            for(String a:myFlaws){
                Flaws fl= flawRepository.save(new Flaws(a));
                ch.sufFering(fl);
            }
        }
        return new ResponseEntity<>("new heroe"+ ch.getCharacter_name(),HttpStatus.OK);
    }
    @GetMapping(value = "/characters/{nick}")
    private ResponseEntity<Object> userChar(@PathVariable("nick")String nick){
        return new ResponseEntity<>(characterRepository.userCharacters(nick),HttpStatus.OK);
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
