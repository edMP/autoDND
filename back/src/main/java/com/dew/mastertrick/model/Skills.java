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
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String type;
    private String description;
    private String requirements;

    public Skills() {
    }

    public Skills(String name, String type, String description, String requirements) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.requirements = requirements;
    }

    @Override
    public String toString() {
        return "Skils{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", requirements='" + requirements + '\'' +
                '}';
    }
}
