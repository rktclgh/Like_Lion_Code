package com.sec15;

import java.sql.Connection;
import java.sql.SQLException;

import static common.JdbcTemplate.Close;
import static common.JdbcTemplate.getConnection;

public class d_proc {

    public static void main(String[] args) throws SQLException {


        Connection conn = getConnection();
        try {
            System.out.println(conn.isClosed());
            System.out.println("연결중....");
            ;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close(conn);
        }
    }
}
