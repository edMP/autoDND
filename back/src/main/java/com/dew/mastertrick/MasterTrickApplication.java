package com.dew.mastertrick;

import com.dew.mastertrick.repositoires.CharacterRepository;
import com.dew.mastertrick.repositoires.FlawRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class MasterTrickApplication {
    //autentication web tocken
    public static void main(String[] args) {SpringApplication.run(MasterTrickApplication.class, args);}
    @EnableWebSecurity
    @Configuration
    class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws  Exception {
            http.cors().disable().csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/").permitAll();
        }
    }

}
