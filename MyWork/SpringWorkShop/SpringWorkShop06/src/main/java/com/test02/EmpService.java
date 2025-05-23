package com.test02;



import com.test01.EmpMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


public class EmpService {

    private final SqlSessionFactory sqlSessionFactory;


    public EmpService(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }


    public void insertEmp(String name)
    {
        try(SqlSession session = sqlSessionFactory.openSession(false)) {
            EmpMapper mapper = session.getMapper(EmpMapper.class);
            System.out.println("[INSERT] 이름: "+ name);
            mapper.insertEmp(name);
            session.commit();
            System.out.println("[COMMIT 완료]");

        }catch (Exception e)
        {
            System.out.println("[ROLLBACK 발생]" + e.getMessage());
        }
    }


    public void insertEmpWithError(String name)
    {
        try(SqlSession session = sqlSessionFactory.openSession(false)) {
            EmpMapper mapper = session.getMapper(EmpMapper.class);
            System.out.println("[INSERT 시도] 이름: " + name);
            mapper.insertEmp(name);
            if (true)
            {
                throw new RuntimeException("강제 에러 발생");
            }

            session.commit();// 도달 x

        }catch (Exception e)
        {
            System.out.println("[ROLLBACK 발생] "+e.getMessage());
        }

    }



}
