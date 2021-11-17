package com.example.masterstrick.model;

import lombok.Data;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;


@Data
@Entity
public class Characters {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int level;
    private String character_name;
    private String profesion;
    private String race;
    private Integer strength;
    private Integer dexterity;
    private Integer constitution;
    private Integer intelligence;
    private Integer wisdom;
    private Integer charisma;
    private String alignement;
    private String hit_dice;
    private String personality_trails;
    private String ideals;
    private Integer profeci_bonus;
    private Integer mobility;
    private String leguage;
    private String bound;


    //modelos aparte

    private String background;
    private String skils;
    private String flaws;
    private String equipment;


}
