package com.dew.mastertrick.controllers;

import com.dew.mastertrick.repositoires.FlawRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class FlawsControllers {
    @Autowired
    FlawRepository flawRepository;

    @GetMapping(value = "/flaw")
        public ResponseEntity<Object>allflaws(){
        return new ResponseEntity<>(flawRepository.findAll(), HttpStatus.OK);
    }
}
