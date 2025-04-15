package Work.workshop14;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test02 {



    public static void main(String[] args) {
        String sql = """
           select *
           from product p 
           where (
       pdname = 'tv'
            and pdcost>(
             select min(pdcost)
          from product
       where pdname = 'tv'
         )
            or
    pdname = 'cellphone'
            and pdcost<(
             select max(pdcost)
          from product
       where pdname = 'cellphone'
         )
   )
       
        """;

        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()
        ) {
            System.out.printf("%-10s %-12s %-15s%n",
                    "제품명", "제품원가", "제품가격");
            System.out.println("----------------------------------------------------------");

            while (rs.next()) {
                String name = rs.getString("PDSUBNAME");
                int cost = rs.getInt("PDCOST");
                int price = rs.getInt("PDPRICE");

                System.out.printf("%-12s %-10d %-10d%n", name, cost, price);
            }

        } catch (Exception e) {
            System.out.println("❌ 오류 발생!");
            e.printStackTrace();
        }
    }
}