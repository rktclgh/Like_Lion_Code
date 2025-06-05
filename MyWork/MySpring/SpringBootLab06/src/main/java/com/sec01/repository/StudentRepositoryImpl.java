package com.sec01.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sec01.dto.StudentCourseDto;
import com.sec01.entity.QCourse;
import com.sec01.entity.QStudent;
import com.sec01.entity.Student;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.querydsl.core.types.ExpressionUtils.as;

@Repository
public class StudentRepositoryImpl extends QuerydslRepositorySupport implements StudentRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    //생성자 명시로 수동 값전달
    public StudentRepositoryImpl(JPAQueryFactory queryFactory) {
        // Repository가 명시된 엔티티로 결정
        super(Student.class);// 선조에게 (QuerydslRepositorySupport) 엔티티 (Student) 를 지정 대입
        this.queryFactory = queryFactory;

    }


    @Override
    public List<Student> findByCourseTitle(String courseTitle) {
        QStudent student = QStudent.student; // 싱글톤으로 생성된 객체
        QCourse course = QCourse.course; // 싱글톤으로 생성된 객체

        return queryFactory
                .selectFrom(student)
                .join(student.courses, course)
                .where(course.title.eq(courseTitle))
                .fetch();
    }

    @Override
    public List<StudentCourseDto> findStudentCourseDtoList() {
        QStudent student = QStudent.student;
        QCourse course = QCourse.course;


        return queryFactory
//                .select(Projections.constructor(StudentCourseDto.class, student.name, course.title))
                .select(Projections.fields(StudentCourseDto.class,
                        student.name.as("studentName"), course.title.as("courseTitle")
                ))
                .from(student)
                .join(student.courses, course)
                .fetch();
    }
    //Projections.constructor() -> DTO 생성자가 명시되어야 한다 -> Querydsl에서 dto 생성할 때 사용한다.

}
