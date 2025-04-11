//package com.sec15;
package common;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import static java.lang.System.load;


//db 연결 생성, 자원 해제(Connection, Statement, resultSet), 트랜잭션 처리(Commit, rollback)
public class JdbcTemplate {

//    public static Connection getConnection() throws SQLException {
//        Connection conn = null;
//
//        try {
//            String url = "jdbc:mysql://localhost:3306/my_emp";
//            String user = "root";
//            String password = "password";
//
//            conn = DriverManager.getConnection(url, user, password);
//
//
//
//
//            if (!conn.isClosed()) {
//                System.out.println("연결중이야");
//            }
//
//            conn.setAutoCommit(false);
//        } catch (SQLException e) {
//        }
//
//
//
//        return conn;
//    }

    // case 2: DB연결 하는 곳_ properties 파일로 로드 하는 방법
    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        Properties prop = new Properties();
        try(InputStream input = JdbcTemplate.class.getClassLoader().getResourceAsStream("db.properties")) {

            if(input == null) {
                throw new RuntimeException("db.properties 파일 없어!!");

            }
            prop.load(input);

            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");
            Class.forName(driver); // jdk 버전 상관 없이 리소스 로드할때는 반드시 명시!!!!!!

//            String url = "jdbc:mysql://localhost:3306/my_emp";
//            String user = "root";
//            String password = "password";

            conn = DriverManager.getConnection(url, user, password);




            if (!conn.isClosed()) {
                System.out.println("연결중이야");
            }

            conn.setAutoCommit(false);
        } catch (SQLException | IOException | ClassNotFoundException e) {
        }



        return conn;
    }

// 1. DB Close 하는 곳
        public static void Close(Connection con) {
            if(con!= null)
            {
                try
                {
                    con.close();
                }catch(SQLException e)
                {
                    System.out.println("데이터베이스 연결 닫기 오류"+ e.getMessage());
                }
            }
        }

        // 2. statemnets close 하는 곳
        public static void Close(Statement stmt) {
            if(stmt!= null)
            {
                try
                {
                    stmt.close();
                }catch(SQLException e)
                {
                    System.out.println("명령 오류"+ e.getMessage()+'\t'+e.getMessage());
                }
            }
        }

        //3.ResultSet close 하는 곳
    public static void Close(ResultSet rs) {
        if (rs != null) {
            try{
                rs.close();
            }catch (SQLException e)
            {
                System.out.println("쿼리 리턴 오류: "+e.getMessage()+'\t'+e.getMessage());
            }
        }
    }
// 4. 트랜잭션 처리(Commit, rollback)
    //4-1 commit
public static void commit(Connection con) {
    if(con!= null)
    {
        try
        {
            con.commit();
        }catch(SQLException e)
        {
            System.out.println("데이터베이스 연결 닫기 오류"+ e.getMessage());
        }
    }
}

    //4-2 rollback
    public static void rollback(Connection con) {
        if(con!= null)
        {
            try
            {
                con.rollback();
            }catch(SQLException e)
            {
                System.out.println("데이터베이스 연결 닫기 오류"+ e.getMessage());
            }
        }
    }

    }

