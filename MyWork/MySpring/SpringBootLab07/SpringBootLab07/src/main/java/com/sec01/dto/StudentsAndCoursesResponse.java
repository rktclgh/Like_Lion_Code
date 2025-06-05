package com.sec01.dto;


import com.sec01.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StudentsAndCoursesResponse {

    private List<StudentResponseDto> students;
    private List<Course> courses;
}
