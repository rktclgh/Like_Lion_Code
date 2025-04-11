package com.sec15;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import static common.JdbcTemplate.Close;
import static common.JdbcTemplate.getConnection;

public class b_proc {

    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);
        System.out.print("empno 입력: ");
        int empno = sc.nextInt();


        Connection conn = getConnection();
        CallableStatement cstmt = null;
        try {
            String sql = "{call pro02_delete(?)}";
            cstmt = conn.prepareCall(sql);// 구문 준비
            cstmt.setInt(1, empno);// 바인딩

            cstmt.executeUpdate();// 프로시저 실행
            System.out.println(" 삭제 했어! ");
            ;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close(conn);
        }
    }
}
