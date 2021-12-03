package com.dew.mastertrick;

import com.dew.mastertrick.repositoires.CharacterRepository;
import com.dew.mastertrick.repositoires.FlawRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MasterTrickApplication {
    //autentication web tocken
    public static void main(String[] args) {
                SpringApplication.run(MasterTrickApplication.class, args);
       }

}
