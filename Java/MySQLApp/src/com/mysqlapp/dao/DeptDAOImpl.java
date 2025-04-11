package com.mysqlapp.dao;

import com.mysqlapp.model.Dept;
import com.mysqlapp.model.EmpSalGradeDTO;

import java.sql.*;
import java.util.*;

import static com.mysqlapp.dao.EmpDAO.Eqjoin;
import static common.JDBCTemplate.*;

public class DeptDAOImpl implements DeptDAO {

    @Override
    public int insert(Dept d) {
        Connection conn = getConnection();
        int result = 0;
        try (PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL)) {
            pstmt.setString(1, d.dname());
            pstmt.setString(2, d.loc());
            result = pstmt.executeUpdate();
            if (result > 0) commit(conn); else rollback(conn);
        } catch (Exception e) {
            rollback(conn);
            e.printStackTrace();
        } finally {
            close(conn);
        }
        return result;
    }

    @Override
    public int update(Dept d) {
        Connection conn = getConnection();
        int result = 0;
        try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_SQL)) {
            pstmt.setString(1, d.dname());
            pstmt.setString(2, d.loc());
            pstmt.setInt(3, d.deptno());
            result = pstmt.executeUpdate();
            if (result > 0) commit(conn); else rollback(conn);
        } catch (Exception e) {
            rollback(conn);
            e.printStackTrace();
        } finally {
            close(conn); 
        }
        return result;
    }

    @Override
    public int delete(int deptno) {
        Connection conn = getConnection();
        int result = 0;
        try (PreparedStatement pstmt = conn.prepareStatement(DELETE_SQL)) {
            pstmt.setInt(1, deptno);
            result = pstmt.executeUpdate();
            if (result > 0) commit(conn); else rollback(conn);
        } catch (Exception e) {
            rollback(conn);
            e.printStackTrace();
        } finally {
            close(conn);
        }
        return result;
    }

    @Override
    public Dept findByDeptno(int deptno) {
        Connection conn = getConnection();
        Dept dept = null;
        ResultSet rs = null;
        try (PreparedStatement pstmt = conn.prepareStatement(SELECT_BY_DEPTNO)) {
            pstmt.setInt(1, deptno);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                dept = new Dept(
                    rs.getInt("deptno"),
                    rs.getString("dname"),
                    rs.getString("loc")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(conn);
        }
        return dept;
    }

    @Override
    public List<Dept> findAll() {
        List<Dept> list = new ArrayList<>();
        Connection conn = getConnection();
        try (PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_SQL);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Dept dept = new Dept(
                    rs.getInt("deptno"),
                    rs.getString("dname"),
                    rs.getString("loc")
                );
                list.add(dept);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn);
        }
        return list;
    }


    @Override
    public List<EmpSalGradeDTO> getEmpSalGrade() {
        Connection conn = getConnection();
        List<EmpSalGradeDTO> all_res = new ArrayList<>();
        EmpSalGradeDTO dto = null;
        try(Statement stmp = conn.createStatement();
        ResultSet rs = stmp.executeQuery(Eqjoin)){
            while(rs.next())
            {
                dto = new EmpSalGradeDTO(
                        rs.getString(1),
                        rs.getDouble(2),
                        rs.getInt(3));
                        all_res.add(dto);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(conn);
        }
        return all_res;
    }
}
