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
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nick;
    private String name;
    private String last_name;
    private String password;
    private String email;

    public Users() {
    }

    public Users(String nick, String name, String last_name, String password, String email) {
        this.nick = nick;
        this.name = name;
        this.last_name = last_name;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", nick='" + nick + '\'' +
                ", name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}