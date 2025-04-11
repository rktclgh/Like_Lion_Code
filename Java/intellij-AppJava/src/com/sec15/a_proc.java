package com.sec15;

import java.sql.*;


import static common.JdbcTemplate.*;

public class a_proc {

    public static void main(String[] args) throws SQLException {


        Connection conn = getConnection();
        CallableStatement cstmt = null;

        try {
            String sql = "{call my_emp.test()}";
            cstmt = conn.prepareCall(sql);

            cstmt.execute();// 프로시저 실행

            System.out.println(conn.isClosed());
            System.out.println("연결중....");
            ;
        } catch (SQLException e) {
            rollback(conn);// 예외발생시 롤백
            e.printStackTrace();
        } finally {
            Close(cstmt);
            Close(conn);

        }
    }
}
