package com.mydb.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

//import java.awt.*;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class EmpDao {

    private final JdbcTemplate jdbcTemplate;

   
   // 생성자 주입

@Autowired
public EmpDao(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
}

    // SELECT ALL
    public List<Emp> findAll() {
        String sql = "select * from emp";
        System.out.println("EmpDao's Constructor ");
        return jdbcTemplate.query(sql, new EmpRowMapper());
    }
    // 내부 RowMapper 클래스
    private static class EmpRowMapper implements RowMapper<Emp> {


        @Override
        public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Emp(rs.getInt("empno"), rs.getString("ename"),
                    rs.getString("job"), rs.getInt("deptno"));
        }


    }


    //2. 데이터 추가
    public void insert(Emp emp) {
    String sql  = "insert into emp(empno, ename, job, deptno) values(?, ?, ?, ?)";
    jdbcTemplate.update(sql, emp.getEmpno(), emp.getEname(), emp.getJob(), emp.getDeptno());
    }
}
