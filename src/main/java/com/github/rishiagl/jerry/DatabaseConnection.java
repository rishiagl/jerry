package com.github.rishiagl.jerry;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static Connection conn = null;
    public static Connection Connector() {
        if(conn == null) {
            try {
                return conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\rishi\\github.com\\rishiagl\\jerry\\src\\main\\resources\\jerry.db");
            } catch (Exception e) {
                System.out.println(e);
                return null;
            }
        }
        else return conn;
    }
}
