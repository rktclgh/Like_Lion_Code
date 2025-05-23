package myweb01.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    //save(), findById, findAll(), delete() 등 = CRUD 이미 구현되어있다!


}
