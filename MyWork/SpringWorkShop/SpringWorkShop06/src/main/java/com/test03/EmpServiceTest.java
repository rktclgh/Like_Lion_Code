package com.test03;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpServiceTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        SqlSessionTemplate template = context.getBean("sqlSessionTemplate", SqlSessionTemplate.class);
        EmpService empService = new EmpService(template);



        try{
            empService.insertThenFail("김춘덕");

        }catch (Exception e)
        {
            System.out.println("예외발생: "+ e.getMessage());
        }



    }
}

