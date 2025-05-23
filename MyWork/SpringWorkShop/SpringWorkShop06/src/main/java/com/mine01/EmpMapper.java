package com.mine01;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import java.util.List;

@Mapper
public interface EmpMapper {

    @Insert("insert into emp(ename) values (#{ename})")
    @Options(useGeneratedKeys = true , keyProperty = "empno")
    void insertEmp(Emp emp);



    @Select("select empno, ename from emp")
    List<Emp> getEmpList();
}
