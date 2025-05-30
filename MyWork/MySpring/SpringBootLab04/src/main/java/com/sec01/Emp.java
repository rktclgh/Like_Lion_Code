package com.sec01;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


    @jakarta.persistence.Entity
    @NoArgsConstructor
    @AllArgsConstructor
    public @Data class Emp
    {
        @Id
        private int empno;
        private String ename;
        private String job;
        private int sal;
        @ManyToOne
        @JoinColumn(name = "deptno")
        private Dept dept;
    }
