package com.sec01.controller;

import com.sec01.dto.CourseDto;
import com.sec01.dto.StudentRequestDto;
import com.sec01.dto.StudentResponseDto;
import com.sec01.dto.StudentsAndCoursesResponse;
import com.sec01.entity.Course;
import com.sec01.entity.Student;
import com.sec01.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")// API 경로로 분리
@CrossOrigin(origins = "http://localhost:3000")
public class StudentCourseController {

    @Autowired
    private StudentCourseService service;

    // [1] 모든 학생 + 과목 목록 조회 (courses 포함)
    @GetMapping("/students")
    public StudentsAndCoursesResponse showStudents() {
        List<Student> students = service.getAllStudents();
        List<Course> courses = service.getAllCourses();

        // [1-1] 학생 응답 DTO 변환
        List<StudentResponseDto> studentDtos = students.stream()
                .map(student -> new StudentResponseDto(
                        student.getId(),
                        student.getName(),
                        student.getCourses().stream()
                                .map(c -> new CourseDto(c.getId(), c.getTitle()))
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());

        return new StudentsAndCoursesResponse(studentDtos, courses);
    }

    // [2] 모든 과목 목록 조회
    @GetMapping("/courses")
    public List<Course> showCourses() {
        return service.getAllCourses();
    }

    // [3] 학생 추가 (학생 이름 + 수강 과목 PK 함께 받음)
    @PostMapping("/students")
    public void addStudent(@RequestBody StudentRequestDto dto) {
        service.addStudent(dto.getName(), dto.getCourseIds());
    }

    // [4] 과목 추가 (과목명만 받음)
    @PostMapping("/courses")
    public void addCourse(@RequestBody Course course) {
        service.addCourse(course.getTitle());
    }

    // [5] 특정 학생 삭제
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
    }

    // [6] 특정 과목 삭제
    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable Long id) {
        service.deleteCourse(id);
    }

}
