package com.mydb.core;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private int empno;
    private String ename;
    private String job;
    private int deptno;
}
