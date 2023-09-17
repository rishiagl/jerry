package com.github.rishiagl.jerry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection conn = null;
    public static Connection Connector() {
        if(conn == null) {
            try {
                Class.forName("org.sqlite.JDBC");
                return conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\rishi\\github.com\\rishiagl\\jerry\\src\\main\\resources\\jerry.db");
            } catch (Exception e) {
                System.out.println(e);
                return null;
            }
        }
        else return conn;
    }

    public static void Close() {
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
