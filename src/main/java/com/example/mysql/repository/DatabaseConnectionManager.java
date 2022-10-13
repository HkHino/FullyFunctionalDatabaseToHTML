package com.example.mysql.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager
{
    //variabler
    private static String hostename;
    private static String username;
    private static String password;
    private static Connection conn;

    //metoder
    public static Connection getConnection()
    {
        hostename = "jdbc:mysql://myfirstkeadatabase.mysql.database.azure.com";
        username = "Hino";
        password = "kage1001@azure";

        try
        {
            conn = DriverManager.getConnection(hostename, username, password);
        }
        catch (SQLException e){
            System.out.println("connection to database failed!");
            throw new RuntimeException(e);
        }
        System.out.println("connection to database successfull ");
        return conn;
    }
}
