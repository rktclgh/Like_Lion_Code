package com.person.dao;


import com.person.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


//DB CRUD 
// view -> controller -> dao  [JDBCTemplate] -> db
//view <-  controller <- dao  [JDBCTemplate] <- db

@Repository
public class PersonDaoImple implements PersonDao {



	@Autowired
	private JdbcTemplate jdbcTemplate;

//	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}


	/// 1.insert


	public int insertPerson(Person p) {
	return jdbcTemplate.update(insert_sql, p.getName(),p.getAddress(),p.getPhone());
	}

//	@Override
//	public Person searchByName(Person p) {
//
//return jdbcTemplate.query("select * from person where name=?", new Object[]{p.getName()}, new RowMapper<Person>() {});
//
//	}

	/// 2.delete
	public int deletePerson(Person p) {
//
		return jdbcTemplate.update(delete_sal, p.getName());
	}

	/// 3.update
	public int updatePerson(Person p) {

		return jdbcTemplate.update(update_sql, p.getAddress(), p.getPhone(), p.getName());
	}

	private RowMapper<Person> personRowMapper  = (rs,rowNum) -> new Person(
			rs.getString("name"),
			rs.getString("address"),
			rs.getString("phone"));


	/// 4.select
	public List<Person> selectAllPerson() {
		return jdbcTemplate.query(select_sql, personRowMapper);
	}

	@Override
	public Person searchByName(Person p) {
		return jdbcTemplate.queryForObject(select_sql, personRowMapper, p.getName());
	}

	@Override
    public List<Person> getPersonByPage() {
		return jdbcTemplate.query(select_sql, personRowMapper);
    }

    @Override
	public List<Person> getPersonByPage(int page, int size) {
	return jdbcTemplate.query(select_sql, personRowMapper, page, size);
	}
}











