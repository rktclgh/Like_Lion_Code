//package com.sec14;
//
//import java.sql.*;
//
//public class d_deletePrepared {
//
//    public static void main(String[] args) throws SQLException {
//
//        //1.연결
//        Connection conn = null;
//        ResultSet rs = null;
//        PreparedStatement pstmt = null;
//
//        try {
//            String url = "jdbc:mysql://localhost:3306/my_emp";
//            String user = "root";
//            String password = "password";
////            conn = DriverManager.getConnection ("jdbc:mysql://localhost: 3306/my_emp"
////                + "user=root&password=password");
//
//            conn = DriverManager.getConnection(url, user, password);
//            if (!conn.isClosed()) {
//                System.out.println("연결중이야");
//            }
//            conn.setAutoCommit(false);
//
//            //2. 명령 수행
//            String sql_delete = "delete from emp where ename = ?";
//            pstmt = conn.prepareStatement(sql_delete);
//            pstmt.setString(1,"홍길동");
//
//            int res = pstmt.executeUpdate();
//
//            if(res>0)
//            {
//                conn.commit();
//            }else{
//                System.out.println("쿼리 이상해!! 롤백이야");
//                conn.rollback();
//            }
//            ///////////////2-2 select
//            String sql = "select * from emp";
//            rs = pstmt.executeQuery(sql);
//
//            //3. 결과 출력
//
//            while (rs.next()) {
//                System.out.println(rs.getString(1) + "\t" + rs.getString(2));
//            }
//
//        } catch (SQLException ex) {
//            System.out.println("SQLException: " + ex.getMessage());
//            System.out.println("SQLState: " +
//                    ex.getSQLState());
//            System.out.println("VendorError: " + ex.getErrorCode());
////        } finally {
////            rs.close();
////            stmt.close();
////            conn.close();
////        }
//        }
//    }}


package com.sec14;

import java.sql.*;

public class d_deletePrepared {

    public static void main(String[] args) throws SQLException {

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmtDelete = null;
        PreparedStatement pstmtSelect = null;

        try {
            String url = "jdbc:mysql://localhost:3306/my_emp";
            String user = "root";
            String password = "password";

            conn = DriverManager.getConnection(url, user, password);
            if (!conn.isClosed()) {
                System.out.println("연결중이야");
            }
            conn.setAutoCommit(false);

            // 1. DELETE
            String sql_delete = "delete from emp where ename = ?";
            pstmtDelete = conn.prepareStatement(sql_delete);
            pstmtDelete.setString(1, "홍길동");

            int res = pstmtDelete.executeUpdate();

            if(res > 0) {
                System.out.println(res + "명 삭제됨");
                conn.commit();
            } else {
                System.out.println("쿼리 이상해!! 롤백이야");
                conn.rollback();
            }

            // 2. SELECT (다른 pstmt 사용)
            String sql = "select * from emp";
            pstmtSelect = conn.prepareStatement(sql);
            rs = pstmtSelect.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString(1) + "\t" + rs.getString(2));
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
