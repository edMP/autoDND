package com.dew.mastertrick.controllers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginData {
    private String nick;
    private String password;

    public LoginData(){}
}