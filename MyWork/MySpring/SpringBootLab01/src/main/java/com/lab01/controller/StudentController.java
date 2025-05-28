package com.lab01.controller;

import com.lab01.entity.Student;
import com.lab01.repository.StudentRepository;
import com.lab01.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private  StudentService studentService;

//    @GetMapping
//    public List<Student> getAllStudent(){
//        return studentService.findAll();
//    }





    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

//    // 학생 상세 조회 get // Students/{id}
//    @GetMapping("/{id}")
//    public Student getStudentById(@PathVariable Long id) {
//        return studentService.findById(id);
//    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id ,@RequestBody Student student) {
        Student res = studentService.findById(id); // 수정할 ID로 객체를 찾아와서
        res.setGrade(student.getGrade()); // 입력된 데이터를 담은 객체인 Student의 grade와 name으로 대입
        res.setName(student.getName());

        return studentService.save(res); //수정된 내용을 저장 후 리턴
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.delete(id);
    }



    // (1) 전체 학생 조회 - HATEOAS 링크 포함
    @GetMapping
    public CollectionModel<EntityModel<Student>> getAllStudents() {
        List<Student> students = studentService.findAll();

        List<EntityModel<Student>> studentModels = students.stream()
                .map(student -> EntityModel.of(student,
                        linkTo(methodOn(StudentController.class)
                                .getStudentById(student.getId())).withSelfRel(),
                        linkTo(methodOn(StudentController.class)
                                .getAllStudents()).withRel("all-students")
                ))
                .toList();

        return CollectionModel.of(studentModels,
                linkTo(methodOn(StudentController.class).getAllStudents()).withSelfRel());
    }


    // (2) 특정 학생 조회 - HATEOAS 링크 포함
    @GetMapping("/{id}")
    public EntityModel<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.findById(id);

        return EntityModel.of(student,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                        .methodOn(StudentController.class)
                        .getStudentById(id)).withSelfRel(),

                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
                        .methodOn(StudentController.class)
                        .getAllStudents()).withRel("students"));
    }



}


