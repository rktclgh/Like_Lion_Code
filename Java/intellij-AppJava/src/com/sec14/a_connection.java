package com.sec14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class a_connection {

    public static void main(String[] args) {
        Connection conn = null;

        try
        {
                String url = "jdbc:mysql://localhost:3306/my_emp";
                String user = "root";
                String password = "password";
//            conn = DriverManager.getConnection ("jdbc:mysql://localhost: 3306/my_emp"
//                + "user=root&password=password");
                if(!conn.isClosed())
                {
                    System.out.println("연결중이야");
                }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " +
                    ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {}
    }
}
