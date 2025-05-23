package com.test01;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.*;

@Mapper
public interface EmpMapper {
    @Insert("INSERT INTO emp (ename) VALUES (#{name})")
    void insertEmp(String name);

    @Select("SELECT ename FROM emp")
    List<String> getEmpList();
}
