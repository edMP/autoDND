package com.dew.mastertrick.controllers;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
public class AuthToken {
    private String token;
    public AuthToken() {}

    public AuthToken(String token) {
        this.token = token;
    }
}
