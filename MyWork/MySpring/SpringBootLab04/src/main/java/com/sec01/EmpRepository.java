package com.sec01;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpRepository extends JpaRepository<Emp, Integer> {
    //추가코드
    //findBy Dept Deptno
    // JPQL -> select e from emp e where e.dept.deptno = :deptno
    List<Emp> findByDeptDeptno(int deptno);
}
