package com.sec15;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import static common.JdbcTemplate.*;
// 사원번호와 이름을 입력받아 수정해보자. 3번의 이름을 홍길동으로 변경

public class c_proc {

    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);
        System.out.print("수정될 사원번호: ");
        int empno = sc.nextInt();
        sc.nextLine();

        System.out.print("수정될 사원 이름: ");
        String name = sc.nextLine();


        //연결확인
        Connection conn = getConnection();
        CallableStatement cstmt = null;

        try {

            String sql = "{call pro03_update(?,?)}";
            cstmt = conn.prepareCall(sql);
            cstmt.setInt(1, empno);
            cstmt.setString(2, name);

            cstmt.executeUpdate();
            System.out.println("수정했어!");
            commit(conn);

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
