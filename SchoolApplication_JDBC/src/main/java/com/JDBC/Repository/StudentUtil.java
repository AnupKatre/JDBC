package com.JDBC.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentUtil {
    private static Connection con = null;
    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/StudentApplication";
            String username = "root";
            String password = "root";
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected Succesfully");
        } catch (SQLException sql) {
            System.out.println(sql.getMessage());
        }
        return con;
    }
}
