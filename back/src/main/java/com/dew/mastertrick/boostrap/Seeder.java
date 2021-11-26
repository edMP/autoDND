package com.dew.mastertrick.boostrap;

import com.dew.mastertrick.model.Users;
import com.dew.mastertrick.repositoires.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Seeder implements CommandLineRunner {
    @Autowired
    private UserRespository userRespository;

    @Override
    public void run(String[] arg){
        Users u1=userRespository.save(new Users("perico","eduardo","apellido","1234","correo@correo.com"));
        Users u2=userRespository.save(new Users("carrasco","sofia","malepo","3566","dsadad@correo.com"));
        Users u3=userRespository.save(new Users("malasco","fermin","asdadasd","89763","dededed@correo.com"));


    }

}
