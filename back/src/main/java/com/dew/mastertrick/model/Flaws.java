package com.dew.mastertrick.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@Getter
@Setter
public class Flaws {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String desciption;

    public Flaws() {
    }

    public Flaws(String name, String desciption) {
        this.name = name;
        this.desciption = desciption;
    }

    @Override
    public String toString() {
        return "Flaws{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desciption='" + desciption + '\'' +
                '}';
    }
}
