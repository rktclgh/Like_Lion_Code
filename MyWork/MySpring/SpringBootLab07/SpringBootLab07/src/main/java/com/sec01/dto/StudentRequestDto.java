package com.sec01.dto;


import lombok.Data;

import java.util.List;

@Data

public class StudentRequestDto {
    private String name;
    private List<Long> courseIds;

}
