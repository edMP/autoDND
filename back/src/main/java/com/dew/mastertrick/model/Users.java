package com.dew.mastertrick.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    private String token;

    @JsonBackReference
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy =  "alter", cascade = CascadeType.ALL )
    Set<Characters> alter=new HashSet<>();

    public Users() {
    }

    public Users(String nick, String name, String last_name, String password, String email) {
        this.nick = nick;
        this.name = name;
        this.last_name = last_name;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.email = email;
    }

    @Override
    public String toString() {
        return nick;
    }
}
