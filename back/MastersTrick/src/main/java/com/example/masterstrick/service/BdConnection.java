package com.example.masterstrick.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BdConnection {
        Connection con;
        PreparedStatement pst;
        ResultSet rs;

        public  Connection bd(){
            try{
                Class.forName("org.mariadb.jdbc.Driver");
                String server="jdbc:mariadb//localhost:3306";
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

}
