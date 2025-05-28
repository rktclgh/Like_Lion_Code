package com.lab01.repository;

import com.lab01.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    //메소드 내가 추가 가능하다!
}
