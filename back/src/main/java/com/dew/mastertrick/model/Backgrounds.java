package com.dew.mastertrick.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Getter
@Setter
public class Backgrounds {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;

    public Backgrounds() {
    }

    public Backgrounds(String name/*, String description*/) {
        this.name = name;
    //    this.description = description;
    }

    @Override
    public String toString() {
        return "Backgrounds{" +
                "id=" + id +
                ", name='" + name + '\'' +
                /*", description='" + description + '\'' +*/
                '}';
    }
}
