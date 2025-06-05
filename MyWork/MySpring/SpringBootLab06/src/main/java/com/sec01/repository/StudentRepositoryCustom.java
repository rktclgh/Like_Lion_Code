package com.sec01.repository;


import com.sec01.dto.StudentCourseDto;
import com.sec01.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
//[1] 사용자 추가 쿼리메서드 선언
// 과목을 입력하면 추가하는 학생의 목록을 리턴
//select * from student join course on(student.id = course.id)
//                  where title = "특정과목";

public interface StudentRepositoryCustom {
    List<Student> findByCourseTitle(String courseTitle);
    List<StudentCourseDto> findStudentCourseDtoList();

}
