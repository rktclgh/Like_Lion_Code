package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;
public class EmpMapperTest {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmpMapper mapper = context.getBean(EmpMapper.class);


        mapper.insertEmp("홍길동");
        mapper.insertEmp("김철수");
        System.out.println("사원 등록 완료!");

        // 사원 목록 출력
        List<String> empList = mapper.getEmpList();
        System.out.println("사원 목록:");
        for (String name : empList) {
            System.out.println(name);
        }

    }
}
