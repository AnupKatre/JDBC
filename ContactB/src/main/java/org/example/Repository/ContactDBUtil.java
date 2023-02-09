package org.example.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ContactDBUtil {
    private static Connection con = null;

    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/ContactDb";
            String username = "root";
            String password = "root";
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected Succesfully");
        } catch (SQLException sql) {
            System.out.println(sql.getMessage());
        }

        System.out.println("returning  connection object");
        return con;
    }
}
/**
 * contact Id : 12
 * contact Name : sdfgsgh
 * contact Email : sdfgfhs
 * contact Address : sdfhfgh
 * contact Mobile Number : 23454677
 */