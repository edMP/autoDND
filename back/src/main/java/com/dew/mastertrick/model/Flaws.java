package com.dew.mastertrick.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Getter
@Setter
public class Flaws {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name= "has",
            joinColumns = @JoinColumn(name = "flaws_id"),
            inverseJoinColumns = @JoinColumn(name = "character_id")
    )
    private List<Characters> has =new ArrayList<>();

    public Flaws() {
    }
    public void has(Characters characters){
        has.add(characters);
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
