package com.sec14;

import java.sql.*;

public class c_insert {

    public static void main(String[] args) throws SQLException {

        //1.연결
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            String url = "jdbc:mysql://localhost:3306/my_emp";
            String user = "root";
            String password = "password";
//            conn = DriverManager.getConnection ("jdbc:mysql://localhost: 3306/my_emp"
//                + "user=root&password=password");

            conn = DriverManager.getConnection(url, user, password);
            if (!conn.isClosed()) {
                System.out.println("연결중이야");
            }

            //2. 명령 수행
            stmt = conn.createStatement();
            ////////////// 2-1 insert
            conn.setAutoCommit(false);
            String sql_insert = "insert into emp(ename) values('정길동') ";

            int res = stmt.executeUpdate(sql_insert);
            if(res>0)
            {
                conn.commit();
            }else{
                System.out.println("쿼리 이상해!! 롤백이야");
                conn.rollback();
            }
            ///////////////2-2 select
            String sql = "select * from emp";
            rs = stmt.executeQuery(sql);

            //결과 출력

            while (rs.next()) {
                System.out.println(rs.getString(1) + "\t" + rs.getString(2));
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " +
                    ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
//        } finally {
//            rs.close();
//            stmt.close();
//            conn.close();
//        }
        }
    }}
