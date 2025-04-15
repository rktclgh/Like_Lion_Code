package Work.workshop14;

import java.sql.*;

public class Test04 {



    public static void main(String[] args) {
        String selectSql = """
        select p.pdno, p.pdname, p.pdsubname, p.factno, p.pddate, p.pdcost, p.pdprice, p.pdamount
        from product p
        join factory f on p.factno = f.factno
        where f.facloc = 'changwon'
      
        """;

        String insertSql =

                """
                        INSERT INTO DISCARDED_PRODUCT
                                    (PDNO, PDNAME, PDSUBNAME, FACTNO, PDDATE, PDCOST, PDPRICE, PDAMOUNT, DISCARDED_DATE)
                                    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
                       
                       """;

        int insertCount = 0;
        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement selectStmt = conn.prepareStatement(selectSql);
                PreparedStatement insertStmt = conn.prepareStatement(insertSql);
        ) {
            conn.setAutoCommit(false); // 🚨 트랜잭션 시작

            ResultSet rs = selectStmt.executeQuery();

            Date today = new Date(System.currentTimeMillis());

            while(rs.next()) {
                insertStmt.setInt(1, rs.getInt("PDNO"));
                insertStmt.setString(2, rs.getString("PDNAME"));
                insertStmt.setString(3, rs.getString("PDSUBNAME"));
                insertStmt.setString(4, rs.getString("FACTNO"));
                insertStmt.setDate(5, rs.getDate("PDDATE"));
                insertStmt.setInt(6, rs.getInt("PDCOST"));
                insertStmt.setInt(7, rs.getInt("PDPRICE"));
                insertStmt.setInt(8, rs.getInt("PDAMOUNT"));
                insertStmt.setDate(9, today); // 현재 날짜

                insertCount += insertStmt.executeUpdate();
            }
            conn.commit(); // 🔐 커밋
            System.out.println(insertCount + "개의 데이터가 정상적으로 INSERT 되었습니다.");

            } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }
    }
