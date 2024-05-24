package org.example.Utils;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnector {

    public static Connection dbConnection(){

        //driver class : com.mysql.jdbc.Driver
        //find the file
        Connection con = null;
        final String Driver = "com.mysql.cj.jdbc.Driver";
        final String DB_NAME = "casino";
        final String DB_URL = "jdbc:mysql://localhost:3306/casino";
        final String DB_USERNAME = "root";
        final String DB_PASSWORD = "1234";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, DB_USERNAME,DB_PASSWORD);
        }catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


        return con;
    }
}
