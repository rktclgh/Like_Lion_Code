package com.sec01.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(
            name = "student_course",//중간 테이블 이름
            joinColumns = @JoinColumn(name = "student_id"), // 현재 클래스 = Student 외래키
            inverseJoinColumns = @JoinColumn(name = "course_id")// 반대 클래스 = Course 외래키
    )
    @ToString.Exclude
    private List<Course> courses = new ArrayList<>(); // ✅ 리스트 초기화
}