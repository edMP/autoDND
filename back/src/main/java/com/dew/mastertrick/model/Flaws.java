package com.dew.mastertrick.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
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
public class Flaws {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

     @JsonBackReference(value = "suffering")
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(
            name= "suffering",
            joinColumns = @JoinColumn(name = "character_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "flaws_id",referencedColumnName = "id")
    )
   Set<Characters> charactersSet =new HashSet<>();

    public Flaws() {
    }
    public void characterHas(Characters characters){

        System.out.println(characters.getCharacter_name());
        charactersSet.add(characters);
    }

    public Flaws(String name) {
        this.name = name;

    }

    @Override
    public String toString() {
        return "Flaws{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
