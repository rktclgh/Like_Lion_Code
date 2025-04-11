package com.sec15;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import static common.JdbcTemplate.*;
// 사원번호와 이름을 입력받아 수정해보자. 3번의 이름을 홍길동으로 변경

public class e_proc {

    public static void main(String[] args) throws SQLException {

//        Scanner sc = new Scanner(System.in);
//        System.out.print("수정될 사원번호: ");
//        int empno = sc.nextInt();
//        sc.nextLine();
//
//        System.out.print("수정될 사원 이름: ");
//        String name = sc.nextLine();


        //연결확인
        Connection conn = getConnection();
        CallableStatement cstmt = null;

        try {

            String sql = "{ call PROB9_SALARY_BONUS (?) } ";
            cstmt = conn.prepareCall(sql);// 쿼리 준비
            int empno = 3;
            // 데이터 바인딩
            cstmt.setInt(1, empno); //IN부분
            cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
            //OUT 7#
// 실행
            cstmt.execute();
//OUT 부분 리턴 값 출력
            int res = cstmt. getInt(1);
            System.out.println("사원번호: "+ empno + "의 예상 보너스 ="+ res);
                    System.out.println(conn.isClosed());
            System.out.println("연결중......");
            ;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close(conn);
        }
    }
}
