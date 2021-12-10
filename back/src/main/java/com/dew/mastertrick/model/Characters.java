package com.dew.mastertrick.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private String level;
    private String name;
    private String profession;
    private String race;
    private String strength;
    private String dexterity;
    private String constitution;
    private String intelligence;
    private String wisdom;
    private String charisma;
    private String alignment;
    private String hit_dice;
    private String personality_trails;
    private String ideals;
    private String profeci_bonus;
    private String mobility;
    private String language;
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
    /*
    private String skils;
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

    public Characters(String level, String name, String profession, String race, String strength, String dexterity,
                      String constitution, String intelligence, String wisdom, String charisma, String alignment,
                      String hit_dice, String personality_trails, String ideals, String profeci_bonus, String mobility,
                      String language, String bound, Backgrounds backgrounds, Users alter) {
        this.level = level;
        this.name = name;
        this.profession = profession;
        this.race = race;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.alignment = alignment;
        this.hit_dice = hit_dice;
        this.personality_trails = personality_trails;
        this.ideals = ideals;
        this.profeci_bonus = profeci_bonus;
        this.mobility = mobility;
        this.language = language;
        this.bound = bound;
        this.backgrounds=backgrounds;
        this.alter = alter;
    }

    @Override
    public String toString() {
        return "Characters{" +
                "id=" + id +
                ", level=" + level +
                ", character_name='" + name + '\'' +
                ", profesion='" + profession + '\'' +
                ", race='" + race + '\'' +
                ", strength=" + strength +
                ", dexterity=" + dexterity +
                ", constitution=" + constitution +
                ", intelligence=" + intelligence +
                ", wisdom=" + wisdom +
                ", charisma=" + charisma +
                ", alignement='" + alignment + '\'' +
                ", hit_dice='" + hit_dice + '\'' +
                ", personality_trails='" + personality_trails + '\'' +
                ", ideals='" + ideals + '\'' +
                ", profeci_bonus=" + profeci_bonus +
                ", mobility=" + mobility +
                ", leguage='" + language + '\'' +
                ", bound='" + bound + '\'' +
                ", alter=" + alter +
                ", backgrounds=" + backgrounds +
                '}';
    }
}
