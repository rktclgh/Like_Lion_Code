package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpServiceTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        EmpService service = new EmpService(
                (org.apache.ibatis.session.SqlSessionFactory) context.getBean("sqlSessionFactory")
        );

        service.insertEmp("박영희");             // 정상 → commit
        service.insertEmpWithError("김순옥");  // 예외 발생 → rollback
    }
    }

