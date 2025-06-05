package com.sec01.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class StudentResponseDto {

    private Long id;
    private String name;
    private List<CourseDto> courses;
}
