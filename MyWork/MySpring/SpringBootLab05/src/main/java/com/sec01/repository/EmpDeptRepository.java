package com.sec01.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sec01.dto.EmpDeptDto;
import com.sec01.entity.Emp;

@Repository
public interface EmpDeptRepository extends JpaRepository<Emp, Integer> {
	//case: 1 Dto를 활용한 JQPL
	@Query("SELECT new com.sec01.dto.EmpDeptDto(e.ename, e.sal, d.dname) " + "FROM Emp e JOIN e.dept d")
	List<EmpDeptDto> findEmpDeptInfo();

	//case : 2 DB 쿼리
	@Query(value = "SELECT e.ENAME, e.SAL, d.DNAME "
			+ "FROM EMP e JOIN DEPT d ON e.DEPTNO = d.DEPTNO", nativeQuery = true)
	List<Object[]> findEmpDeptNative(); // 결과 그대로 배열로 받아서 형변환  직접 DTO로 형변환 
	
	//case : 3 Dto를 활용한 JPQL  -> 내부적으로 전체 개수 처리를 한다 
	@Query("SELECT new com.sec01.dto.EmpDeptDto(e.ename, e.sal, d.dname)" + "FROM #{#entityName} e JOIN e.dept d") // page= 데이터 + 페이지정보

	Page<EmpDeptDto> findEmpDeptPage(Pageable pageable);
	
	//Select e.ename , e.sal ,  d.dname
	//FROM emp e 
	// join dept d on e.deptno = d.dpetno
	//Limit ?,?- offset, pageSize  기반으로 결정된다 . -> Pageable 
	
	// case 4:  nativeQuery를 사용한 카운트 처리 -> 명시적으로 전체 개수 처리를 지정해줘야 한다 
    @Query(value = "SELECT e.ENAME, e.SAL, d.DNAME " + "FROM EMP e NATURAL JOIN DEPT d",
            countQuery = "SELECT COUNT(*) FROM EMP e NATURAL JOIN DEPT d", // 페이지 전체 개수 용
            nativeQuery = true)
    		Page<Object[]> findEmpDeptPageNative(Pageable pageable); // page = 데이터 + 페이지 정보 
	
}
