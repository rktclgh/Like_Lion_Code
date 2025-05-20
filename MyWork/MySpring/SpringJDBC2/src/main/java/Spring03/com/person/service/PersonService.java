package Spring03.com.person.service;

import com.person.model.Person;

import java.util.List;

//view -> Controller  -> Model (Service(biz), Dao)  -> Db
public interface PersonService {
  //biz
  //Dao  
	List<Person> selectAllPerson();
	int insertPerson(Person p);
	int deletePerson(Person p);
	int updatePerson(Person p);
	Person searchByName(Person p);
	List<Person> getPersonByPage(int page, int size);	
}
