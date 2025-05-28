//package com.lab01;
//
//import com.lab01.entity.Student;
//import com.lab01.repository.StudentRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.util.List;
//@SpringBootTest(classes = SpringBootLab01Application.class)
//public class StudentRepositoryTest {
//
//    @Autowired
//    private StudentRepository studentRepository;
//    @Test
//    public void testSaveStudent() {
//        Student student = new Student();
//        student.setName("John");
//        student.setGrade(2);
//        Student savedStudent = studentRepository.save(student);
//        assertThat(savedStudent.getId()).isNotNull();
//        assertThat(savedStudent.getName()).isEqualTo("John");
//
//
//        List<Student> all = studentRepository.findAll();
//        assertThat(all).hasSizeGreaterThan(0);
//        System.out.println("저장된 학생 목록: " + all);
//    }

//}
