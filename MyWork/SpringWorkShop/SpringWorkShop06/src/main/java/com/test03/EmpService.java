package com.test03;



import com.test01.EmpMapper;
import jakarta.transaction.Transactional;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;


public class EmpService {

    private final EmpMapper empMapper;

    public EmpService(SqlSessionTemplate sqlSessionTemplate) {
        this.empMapper = sqlSessionTemplate.getMapper(EmpMapper.class);
    }

    @Transactional
    public void insertThenFail(String name)
    {
        empMapper.insertEmp(name);
        System.out.println("INSERT 성공 후 예외 발생 예정");
        throw new RuntimeException("강제 예외");
    }
}
