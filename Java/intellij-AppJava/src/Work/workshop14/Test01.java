package Work.workshop14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class Test01 {



    public static void main(String[] args) {
        String sql = """
            SELECT 
                p.PDNAME,
                p.PDSUBNAME,
                f.FACNAME,
                s.STONAME,
                IFNULL(s.STAMOUNT, 0) AS STAMOUNT
            FROM PRODUCT p
            JOIN FACTORY f ON p.FACTNO = f.FACTNO
            JOIN STORE s ON p.PDNO = s.PDNO
            WHERE f.FACLOC = 'SEOUL'
              AND (s.STAMOUNT IS NULL OR s.STAMOUNT = 0)
        """;

        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()
        ) {
            System.out.printf("%-10s %-12s %-15s %-12s %-10s%n",
                    "제품카테고리", "제품명", "공장명", "판매점명", "재고수량");
            System.out.println("----------------------------------------------------------");

            while (rs.next()) {
                String pdname = rs.getString("PDNAME");
                String subname = rs.getString("PDSUBNAME");
                String facname = rs.getString("FACNAME");
                String stoname = rs.getString("STONAME");
                int stock = rs.getInt("STAMOUNT");

                System.out.printf("%-10s %-12s %-15s %-12s %d%n",
                        pdname, subname, facname, stoname, stock);
            }

        } catch (Exception e) {
            System.out.println("❌ 오류 발생!");
            e.printStackTrace();
        }
    }
}