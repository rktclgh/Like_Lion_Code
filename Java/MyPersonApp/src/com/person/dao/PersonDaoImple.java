package com.person.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.person.model.Person;
import static common.JDBCTemplate.*;

//DB CRUD 
// view -> controller -> dao  [JDBCTemplate] -> db
//view <-  controller <- dao  [JDBCTemplate] <- db
public class PersonDaoImple implements PersonDao {

	/// 1.insert
	public int insertPerson(Person p) {
		Connection conn = getConnection();
		PreparedStatement pstm = null;
		int res = 0;

		try {
			pstm = conn.prepareStatement(insert_sql);// 쿼리 준비
			// 데이터 바인딩
			pstm.setString(1, p.getName());
			pstm.setString(2, p.getAddress());
			pstm.setString(3, p.getPhone());

			res = pstm.executeUpdate();
			commit(conn);

		} catch (SQLException e) {
			rollback(conn);
			e.printStackTrace();
		} finally {
			Close(pstm);
			Close(conn);
		}
		return res;
	}

	@Override
	public Person searchByName(Person p) {
		Connection conn = getConnection(); // 연결
		PreparedStatement pstmt = null; // 명령 객체 선언
		ResultSet rs = null; // 명령실행 결과 select 를 참조할 객체 선언
		Person person = null;
		try {
			pstmt = conn.prepareStatement(find_sql); //쿼리 준비  
			pstmt.setString(1, p.getName()); // 데이터 바인딩
			
			rs = pstmt.executeQuery();  //실행  
			while (rs.next()) {
				person = new Person();
				person.setAddress(rs.getString(2));
				person.setName(rs.getString(1));
				person.setPhone(rs.getString("phone"));
			}

		} catch (Exception e) {
			System.out.println(e);

		} finally {
			Close(rs);
			Close(pstmt);
			Close(conn);
		}
		return person;
	}

	/// 2.delete
	public int deletePerson(Person p) {
		Connection conn = getConnection();
		PreparedStatement pstm = null;
		int res = 0;

		try {
			pstm = conn.prepareStatement(delete_sal);// 쿼리 준비
			// 데이터 바인딩
			pstm.setString(1, p.getName());
			res = pstm.executeUpdate();
			commit(conn);

		} catch (SQLException e) {
			rollback(conn);
			e.printStackTrace();
		} finally {
			Close(pstm);
			Close(conn);
		}
		return res;
	}

	/// 3.update
	public int updatePerson(Person p) {
		Connection conn = getConnection();
		PreparedStatement pstm = null;
		int res = 0;

		try {
			pstm = conn.prepareStatement(update_sql);// 쿼리 준비
			// 데이터 바인딩
			pstm.setString(1, p.getAddress());
			pstm.setString(2, p.getPhone());
			pstm.setString(3, p.getName());

			res = pstm.executeUpdate();
			commit(conn);

		} catch (SQLException e) {
			rollback(conn);
			e.printStackTrace();
		} finally {
			Close(pstm);
			Close(conn);
		}
		return res;
	}

	/// 4.select
	public List<Person> selectAllPerson() {
		/*
		 * 모든 select 결과를 rs 객체의 next()로 한줄씩 읽어서 각각의 속성을 person클래스로 담아서 List<>객체로 add() ;
		 */
		List<Person> all = new ArrayList<>(); // 전체 레코드를 Person으로 담아서 리턴
		Connection conn = getConnection(); // 연결
		Statement stmt = null; // 명령 객체 선언
		ResultSet rs = null; // 명령실행 결과 select 를 참조할 객체 선언
		Person person = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(select_sql);

			while (rs.next()) { // 로우데이터가 있으면 한줄 씩 읽어서 리턴 해줘
				// case 1 : 매개인자 생성자로 값을 전달 후 add
				// all.add(new Person(rs.getString(1),rs.getString(2),rs.getString("phone")));

				// case 2: 기본 생성자 객체 생성 후 setter로 값전달 후 add
				person = new Person();
				person.setAddress(rs.getString(2));
				person.setName(rs.getString(1));
				person.setPhone(rs.getString("phone"));
				all.add(person);

			}

		} catch (Exception e) {
			System.out.println(e);

		} finally {
			Close(rs);
			Close(stmt);
			Close(conn);
		}
		return all;
	}
}
