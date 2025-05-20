package Spring03.com.person.dao;

import com.person.model.Person;

import java.util.List;

public interface PersonDao {
	String insert_sql="insert into person(name, address,phone) values (?,?,?)";
	String update_sql="update person set address=?, phone=? where name= ?";
	String delete_sal="delete from person where name=?";
	String select_sql="select name, address, phone from person";
	String find_sql="select name, address, phone from person where name =?";
	String page_sql  ="select  * from person LIMIT  ?  OFFSET ? ";
	
	public int deletePerson(Person p);
	public int insertPerson(Person p);
	public int updatePerson(Person p);
	public List<Person> selectAllPerson();
	public Person searchByName(Person p);

	List<Person> getPersonByPage();

	public List getPersonByPage(int page, int size);

}
