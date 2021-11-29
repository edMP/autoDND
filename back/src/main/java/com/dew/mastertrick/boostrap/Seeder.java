package com.dew.mastertrick.boostrap;

import com.dew.mastertrick.model.Characters;
import com.dew.mastertrick.model.Users;
import com.dew.mastertrick.repositoires.CharacterRepository;
import com.dew.mastertrick.repositoires.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Seeder implements CommandLineRunner {
    @Autowired
    private UserRespository userRespository;

    @Autowired
    private CharacterRepository characterRepository;

    @Override
    public void run(String[] arg){
        Users u1=userRespository.save(new Users("perico","eduardo","apellido","1234","correo@correo.com"));
        Users u2=userRespository.save(new Users("carrasco","sofia","malepo","3566","dsadad@correo.com"));
        Users u3=userRespository.save(new Users("malasco","fermin","asdadasd","89763","dededed@correo.com"));
        /*int level, String character_name, String profesion, String race, Integer strength, Integer dexterity,
                Integer constitution, Integer intelligence, Integer wisdom, Integer charisma, String alignement,
                String hit_dice, String personality_trails, String ideals, Integer profeci_bonus, Integer mobility,
                String leguage, String bound, Users alter*/

        Characters ch1=characterRepository.save(new Characters(1,"balgla","paladin","enano"
                ,6,9,2,12,3,4,"neutral","1d6","ciego"
                ,"comunista",4,3,"enano","torpe",u1));
        Characters ch2=characterRepository.save(new Characters(4,"rosas","chaman","humano"
                ,6,9,2,12,3,4,"malo","1d8","facha"
                ,"vegano",4,3,"humano","humanidad",u2));
        Characters ch3=characterRepository.save(new Characters(1,"rosalia","cleriga","elfa"
                ,6,9,2,12,3,4,"progre","1d22","sorda"
                ,"caarara",4,3,"elfico","familia",u1));

    }

}
