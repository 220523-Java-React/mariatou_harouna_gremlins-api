package com.revature.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {

    /*
    ConnectionUtility class utilizes Singleton Design Pattern, meaning the class will have
    only one connection object, and restrict the creation of another connection object
    outside of this ConnectionUtility class
     */

    /*
     First, we have to declare our connection variables :
            1- the URL
            2- the USER
            3- the PASSWORD
            4- myConnecion, which will be an instance of the connection
     The URL, USER and PASSWORD must be declared static and final because they cannot change

     */

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres?currentSchema=public";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Solo2010";
    private static  Connection myConnection;


    public static Connection getMyConnection() throws SQLException{

        if(myConnection==null){
            myConnection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return myConnection;
    }


    private ConnectionUtility(){

    }

}
