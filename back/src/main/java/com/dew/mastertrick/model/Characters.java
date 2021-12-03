package com.dew.mastertrick.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Getter
@Setter
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

    @ManyToOne
    @JoinColumn
    private Users alter;


    @OneToOne
    @JoinColumn(name = "backgrounds_id",referencedColumnName = "id")
    private Backgrounds backgrounds;



    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(
            name= "suffering",
            joinColumns = @JoinColumn(name = "flaws_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "character_id",referencedColumnName = "id")
    )
     Set <Flaws> suffering =new HashSet<>();
    //foreing key
    /*
    private String skils;
    private String flaws;
    private String equipment;
    */

    public Characters() {
    }

    public void sufFering(Flaws flaws){
        System.out.println(flaws.getName());
        suffering.add(flaws);
    }
    public void run(){
        for (int a =0;a<suffering.size();a++){
            System.out.println(suffering);
        }
    }

    public Characters(int level, String character_name, String profesion, String race, Integer strength, Integer dexterity,
                      Integer constitution, Integer intelligence, Integer wisdom, Integer charisma, String alignement,
                      String hit_dice, String personality_trails, String ideals, Integer profeci_bonus, Integer mobility,
                      String leguage, String bound, Backgrounds backgrounds, Users alter) {
        this.level = level;
        this.character_name = character_name;
        this.profesion = profesion;
        this.race = race;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.alignement = alignement;
        this.hit_dice = hit_dice;
        this.personality_trails = personality_trails;
        this.ideals = ideals;
        this.profeci_bonus = profeci_bonus;
        this.mobility = mobility;
        this.leguage = leguage;
        this.bound = bound;
        this.backgrounds=backgrounds;
        this.alter = alter;
    }

    @Override
    public String toString() {
        return "Characters{" +
                "id=" + id +
                ", level=" + level +
                ", character_name='" + character_name + '\'' +
                ", profesion='" + profesion + '\'' +
                ", race='" + race + '\'' +
                ", strength=" + strength +
                ", dexterity=" + dexterity +
                ", constitution=" + constitution +
                ", intelligence=" + intelligence +
                ", wisdom=" + wisdom +
                ", charisma=" + charisma +
                ", alignement='" + alignement + '\'' +
                ", hit_dice='" + hit_dice + '\'' +
                ", personality_trails='" + personality_trails + '\'' +
                ", ideals='" + ideals + '\'' +
                ", profeci_bonus=" + profeci_bonus +
                ", mobility=" + mobility +
                ", leguage='" + leguage + '\'' +
                ", bound='" + bound + '\'' +
                ", alter=" + alter +
                ", backgrounds=" + backgrounds +
                '}';
    }
}
