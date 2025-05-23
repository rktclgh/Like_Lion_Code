package com.mine01;

import com.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.util.List;
public class EmpMapperTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        EmpMapper empMapper = context.getBean(EmpMapper.class);


        empMapper.insertEmp(new Emp("김춘복"));
        empMapper.insertEmp(new Emp("장덕팔"));
        System.out.println("등록!");

        List<Emp> list = empMapper.getEmpList();

        System.out.println("전체 목록");
        for (Emp emp : list) {
            System.out.println(emp);
        }

        context.close();
    }
}
